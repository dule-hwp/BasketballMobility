package hwp.basketball.mobility.device.sensor.android

import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import hwp.basketball.mobility.device.sensor.BMSensorManager
import hwp.basketball.mobility.device.sensor.BMSensorManager.*
import hwp.basketball.mobility.device.sensor.BaseSensor
import org.joda.time.DateTime
import timber.log.Timber

/**
 * Created by dusan_cvetkovic on 3/4/17.
 */

class AndroidSensor(context: Context) : BaseSensor(), SensorEventListener {
    override fun subscribeForUpdates() {
        subscribeToAccChange()
        subscribeToGyroChange()
        subscribeToMagnetometerChange()
    }

    override fun disconnect() {
        sm.unregisterListener(this)
        stateListener?.onStateDisconnected()
    }

    fun subscribeToMagnetometerChange() {
        val sensor =
                sm.getDefaultSensor(android.hardware.Sensor.TYPE_MAGNETIC_FIELD)
                        ?: throw RuntimeException("No magnetometer available !")
        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_GAME)
    }

    fun subscribeToAccChange() {
        val sensor =
                sm.getDefaultSensor(android.hardware.Sensor.TYPE_ACCELEROMETER)
                        ?: throw RuntimeException("No acc available !")
        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST)
    }

    fun subscribeToGyroChange() {
        val sensor =
                sm.getDefaultSensor(android.hardware.Sensor.TYPE_GYROSCOPE)
                        ?: throw RuntimeException("No gyro available !")
        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST)
    }

    override fun getName(): String {
        return AndroidSensor::class.java.simpleName
    }

    override fun connectTo(deviceID: String) {
        stateListener?.onStateConnected("Android")
    }

    override fun onAccuracyChanged(sensor: android.hardware.Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        event?.let { e ->
            when (e.sensor.type) {
                Sensor.TYPE_MAGNETIC_FIELD -> {
                    System.arraycopy(event.values, 0, mMagnetometerReading, 0, mMagnetometerReading.size)
//                    magnetometerListener?.onMagnetometerDataUpdate(mMagnetometerReading)
                    haveMag = true
                }
                Sensor.TYPE_ACCELEROMETER -> {
                    System.arraycopy(event.values, 0, mAccelerometerReading, 0, mAccelerometerReading.size)
                    haveAcc = true
                    accelerometerObservable.onNext(AccData(mAccelerometerReading.map { it*1000 }.toFloatArray()
                            ,System.currentTimeMillis()))
                    motionObservable.onNext(true)
                }
                Sensor.TYPE_STEP_COUNTER -> {
                    Timber.d("step count: ${event.values[0]}")
                    motionObservable.onNext(false)
                    motionObservable.onNext(true)
                }
                Sensor.TYPE_GYROSCOPE -> {
                    for (i in mGyroReading.indices) {
                        mGyroReading[i] = event.values[i]
                    }
//                    gyroListener?.onGyroDataUpdate(mGyroReading)
                }
                else -> {

                }
            }
            updateAngle()
        }

    }

    private var haveAcc: Boolean = false
    private var haveMag: Boolean = false
    var R = FloatArray(9)
    var I = FloatArray(9)
    var orientation = FloatArray(3)

    private var mAzimuth: Double = 0.0

    fun updateAngle() {
        if (haveMag && haveAcc) {
            if (SensorManager.getRotationMatrix(R, I, mAccelerometerReading, mMagnetometerReading)) {
                val prevAz = mAzimuth
                mAzimuth = (Math.toDegrees(SensorManager.getOrientation(R, orientation)[0].toDouble()) + 360) % 360
//                Timber.d("${mAzimuth.toInt()}")
                angleObservable.onNext(mAzimuth.toFloat())

            }
        }
    }

    private var sm: SensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

    override val isConnectable: Boolean
        get() {
            return false
        }

}