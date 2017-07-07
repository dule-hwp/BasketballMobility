package hwp.basketball.mobility.pathrecorder.sketchview

import com.google.common.base.Joiner
import com.google.firebase.auth.FirebaseAuth
import hwp.basketball.mobility.device.sensor.BMSensorManager
import hwp.basketball.mobility.device.sensor.BaseSensor
import hwp.basketball.mobility.device.sensor.IBMSensorManager
import hwp.basketball.mobility.drillpreparation.step.DrillSetupOutput
import hwp.basketball.mobility.entitiy.drills.outcomes.DrillOutcome
import hwp.basketball.mobility.entitiy.drills.outcomes.DrillOutcomeFirebaseRepo
import hwp.basketball.mobility.entitiy.drills.outcomes.DrillOutcomeStore
import hwp.basketball.mobility.pathrecorder.PathRecorderActivityContract
import hwp.basketball.mobility.util.Geometry2D
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Function3
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import kotlin.properties.Delegates

/**
 * Created by dusan_cvetkovic on 3/7/17.
 */
class SensorDrawingViewPresenter(val sensorDrawingViewView: SensorDrawingViewViewContract.View, val sensor: BaseSensor,
                                 val pathRecorderActivityView: PathRecorderActivityContract.View) :
        SensorDrawingViewViewContract.Presenter {

    private lateinit var compositeDisposable: CompositeDisposable

    override fun attach() {
        compositeDisposable = CompositeDisposable()
    }

    override fun prepareConnectedSensor(name: String) {
        mBmSensorManager = BMSensorManager(sensor, object : IBMSensorManager.Callback {
            override fun onSensorConnected(name: IBMSensorManager) {
                sensorDrawingViewView.onSensorConnected(name)
                enableRequiredSensorsUpdate()
            }

            override fun onSensorDisconnected(bmSensorManager: IBMSensorManager) {
                sensorDrawingViewView.onSensorDisconnected(bmSensorManager)
//                inRecordingMode = false
            }

        })
        mBmSensorManager?.connectTo(name)
    }


    override fun detach() {
        compositeDisposable.clear()
        mBmSensorManager?.stopSensorUpdates()
    }

    /** Property with observable, whenever this property changes value it will inform view
     * to update itself.*/
    var inRecordingMode: Boolean by Delegates.observable(false,
            { property, oldValue, newValue ->
                Timber.d("prop $property old: $oldValue new: $newValue")
                if (oldValue != newValue) {
                    pathRecorderActivityView.onRecordingModeChange(newValue)
                    sensorDrawingViewView.onRecordingModeChange(newValue)
                }
            })

    override fun startResumeMovement() {
        inRecordingMode = addCompassAngleChangeListener()
    }

    private fun addCompassAngleChangeListener(): Boolean {
        if (mBmSensorManager == null)
            return false

        val observeAngleChanged = mBmSensorManager?.observeAngleChanged()
        val observeAccSensorChanged = mBmSensorManager?.observeAccSensorChanged()
        val observeMotionChanged = mBmSensorManager?.observeIsMoving()

        val disposable = Observable.combineLatest(observeAngleChanged, observeMotionChanged, observeAccSensorChanged,
                Function3<Float, Boolean, BMSensorManager.AccData, BMSensorManager.AccData>
                { angle, isMoving, accData ->
                    //                    Timber.d("$motionIntensity")
                    sensorDrawingViewView.setDegreesToNorth(angle)
                    sensorDrawingViewView.setIsMoving(isMoving)
                    sensorDrawingViewView.invalidateView()
                    accData
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    sensorDrawingViewView.addAccData(it)
//                    inRecordingMode = true
                }, { error -> Timber.e(error.toString()) })


        compositeDisposable.add(disposable)
        return true
    }

    private var accMin = Float.MAX_VALUE
    private var accMax = Float.MIN_VALUE

    init {
        resetAccValues()
    }

    private fun resetAccValues() {
        accMin = Float.MAX_VALUE
        accMax = Float.MIN_VALUE
    }

//    override fun isInRecordingMode() = inRecordingMode

    override fun stopMovement() {
        compositeDisposable.clear()
        inRecordingMode = false
    }

    init {
        sensorDrawingViewView.setPresenter(this)
        sensorDrawingViewView.invalidate()
    }

    private var mBmSensorManager: IBMSensorManager? = null

    fun enableRequiredSensorsUpdate() {
        mBmSensorManager?.startSensorUpdates()
    }

    override fun disableSensorsUpdate() {
        mBmSensorManager?.stopSensorUpdates()
    }

    override fun onDrillCompleted() {
        stopMovement()
        sensorDrawingViewView.showToastMessage("Drill completed!")
        pathRecorderActivityView.onDrillFinished()

        pathRecorderActivityView.showScoreProgress("Calculating area")
        val disposable = Geometry2D.getAreaForBitmap(sensorDrawingViewView.getBitmapArea())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ (progress, area) ->
                    pathRecorderActivityView.updateScoreProgress(progress)

                    if (progress == 100) {
                        val pathLength = sensorDrawingViewView.getDesiredPathLength()
                        val finalScore = area.toFloat() / pathLength
                        Timber.d("Area = $area, Path Length = $pathLength Final Score: $finalScore")
                        pathRecorderActivityView.hideProgress()
                        pathRecorderActivityView.displayOutcome(DrillOutcome(
                                playerName = DrillSetupOutput.connectMap.keys.first().name,
                                drillName = DrillSetupOutput.drill?.name ?: "unknown",
                                score = finalScore,
                                pathLength = pathLength,
                                pathArea = area,
                                coachEmail = FirebaseAuth.getInstance().currentUser?.email))
                    }
                }, {
                    Timber.e(it)
                    pathRecorderActivityView.showError(it.localizedMessage)
                })
        compositeDisposable.add(disposable)
    }

    override fun displayStats(statistics: ArrayList<String>) {
        val joiner = Joiner.on("\n")
        val res = joiner.join(statistics)
        pathRecorderActivityView.displayStats(res)
    }

    override fun restartDrill() {
        sensorDrawingViewView.resetDrill()
    }

    val outcomeDataStore: DrillOutcomeStore by lazy {
        DrillOutcomeFirebaseRepo()
    }

    override fun onSaveDrillOutcome(outcome: DrillOutcome) {
        val bitmap = sensorDrawingViewView.getBitmap()
        val bitmapArea = sensorDrawingViewView.getBitmapArea()
        pathRecorderActivityView.showProgress("Uploading results")
        outcomeDataStore.addDrillOutcomeToDatabase(outcome, bitmap, bitmapArea)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.newThread())
                .subscribe({
                    Timber.d("Added drill outcome to db")
                    pathRecorderActivityView.hideProgress()
                    pathRecorderActivityView.showMessage("Drill added successfully!")
                }, {
                    Timber.e(it)
                    pathRecorderActivityView.hideProgress()
                })
    }

    override fun onPlayPauseDrillClick() {
        if (!inRecordingMode) {
            startResumeMovement()
        } else {
            stopMovement()
        }
    }
}