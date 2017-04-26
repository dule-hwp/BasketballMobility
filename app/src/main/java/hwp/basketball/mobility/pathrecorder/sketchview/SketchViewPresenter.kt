package hwp.basketball.mobility.pathrecorder.sketchview

import android.hardware.SensorManager
import android.hardware.SensorManager.*
import android.support.annotation.IntRange
import hwp.basketball.mobility.device.sensor.BMSensorManager
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function3
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.*

/**
 * Created by dusan_cvetkovic on 3/7/17.
 */
class SketchViewPresenter(val sketchView: SketchView) : SketchViewContract.Presenter, SketchViewContract.MovementCallback {
    private lateinit var compositeDisposable: CompositeDisposable

    override fun attach() {
        compositeDisposable = CompositeDisposable()
    }

    override fun detach() {
        compositeDisposable.clear()
        mBmSensorManager?.stopSensorUpdates()
        mBmSensorManager = null
    }

    override fun followDeviceRotation() {
        val rotateMap = !movement.isMapRotatedAccordingToCompass
        movement.isMapRotatedAccordingToCompass = rotateMap
        val line2 = "Map auto-rotation is " + if (rotateMap) "ON" else "OFF"
        sketchView.setMessagesWithTimeout("Info:", line2)
    }

    override fun startResumeMovement() {
        addAngleChangeListener()
        if (movement.movementWasStarted()) {
            sketchView.setMessages("Movement:", "Tap on screen for menu")
            movement.ResumeMovement()
        } else {
            sketchView.setMessages("Movement:", "Started movement")
            movement.StartMovement()
        }
    }

    override fun isInRecordingMode(): Boolean {
        return movement.isMovement
    }

    override fun stopMovement() {
        removeAngleChangeListener()
        sketchView.setMessages("Movement:", "Movement stopped")
        movement.StopMovement()
    }

    override fun showStats() {
        movement.isMovementStatisticsNeeded = !movement.isMovementStatisticsNeeded
        val showMovementStats = if (movement.isMovementStatisticsNeeded) "ON" else "OFF"
        val line2forStats = "Movements statistics is $showMovementStats"
        sketchView.setMessagesWithTimeout("Info:", line2forStats)
    }

    override fun exportPath() {
        sketchView.exportPathToBitmap(true)
    }

    override fun onZoomIn() {
        movement.setPixels_for_1_second(true)
        sketchView.setMessages(movement.getMessage(true), movement.getMessage(false))
    }

    override fun onZoomOut() {
        movement.setPixels_for_1_second(false)
        sketchView.setMessages(movement.getMessage(true), movement.getMessage(false))
    }

    private var movement: Movement = Movement()

    init {
        sketchView.setPresenter(this)
        sketchView.invalidate()
        beginMovementStateMonitoring()
    }

    override fun setDegreesToNorth(degreesToNorth: Int) {
        sketchView.setDegreesToNorth(degreesToNorth)
    }

    override fun getMovementDataForDraw(startPoint: FloatArray): Movement.MovementData? {
        return movement.getMovementDataForDraw(startPoint)
    }

    private var mBmSensorManager: BMSensorManager? = null

    override fun enableRequiredSensorsUpdate(bmSensorManager: BMSensorManager) {
        mBmSensorManager = bmSensorManager
        mBmSensorManager?.startSensorUpdates()
    }

    override fun disableSensorsUpdate() {
        mBmSensorManager?.stopSensorUpdates()
    }


    private val mRotationMatrix = FloatArray(9)
    private val mRotationMatrixReMapped = FloatArray(9)
    private val mOrientationAngles = FloatArray(3)

    // angle of rotation about z,x or y axis (0,1,2)
    @IntRange(from = 0, to = 2)
    private var mAngleOfRotation = 0

    override fun useRotationAxis(axisIndex: Int) {
        mAngleOfRotation = axisIndex
    }

    fun addAngleChangeListener() {
        val accObservable = mBmSensorManager?.observeAccSensorChanged()
        val magObservable = mBmSensorManager?.observeMagSensorChanged()
        val gyroObservable = mBmSensorManager?.observeGyroSensorChanged()
//        val observable = Observable.just(Math.random())

        val o = Observable
                .combineLatest(accObservable, magObservable, gyroObservable,
                        Function3<FloatArray, FloatArray, FloatArray, Triple<Float, FloatArray, Float>> { acc, mag, gyro ->
                            SensorManager.getRotationMatrix(mRotationMatrix, null, acc, mag)
                            // "mRotationMatrix" now has up-to-date information.
//                            SensorManager.getRotationMatrixFromVector()
//                            SensorManager.remapCoordinateSystem(mRotationMatrix, AXIS_Z, AXIS_Y, mRotationMatrixReMapped)
                            //rotation matrix remapped
                            SensorManager.getOrientation(mRotationMatrix, mOrientationAngles)

                            // "mOrientationAngles" now has up-to-date information.
//                            Timber.d(Arrays.toString(mOrientationAngles))
                            Triple(mOrientationAngles[mAngleOfRotation], acc, gyro[mAngleOfRotation])
                        })
//                .doFinally { mBmSensorManager?.stopSensorUpdates() }
                .subscribeOn(Schedulers.computation())
                .map {
                    val degrees = Math.toDegrees(it.first.toDouble())
                    Triple(degrees.toFloat(), it.second, it.third)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ pairAngleAcc ->
//                    Timber.d("gyro angle for ${axis[mAngleOfRotation]}: ${pairAngleAcc.third}")
                    movement.onSensorDataUpdate(pairAngleAcc)
                    sketchView.setDegreesToNorth(pairAngleAcc.first.toInt())
                    sketchView.invalidateView()
                }, { error -> Timber.e(error.toString()) })
        compositeDisposable.add(o)
    }

    val axis = listOf("x", "y", "z")


    override fun removeAngleChangeListener() {
        compositeDisposable.clear()
    }

    private fun beginMovementStateMonitoring() {
        object : Thread() {
            override fun run() {
                while (true) {
                    try {
                        movement.CheckMovement()
                        Thread.sleep(100)
                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }
                }
            }
        }.start()
    }

}