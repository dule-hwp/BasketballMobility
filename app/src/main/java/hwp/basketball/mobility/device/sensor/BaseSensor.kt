package hwp.basketball.mobility.device.sensor

import android.content.Context


/**
 * Created by dusan_cvetkovic on 3/4/17.
 */

abstract class BaseSensor(val context: Context) {

    var magnetometerListener: MagnetometerDataChangedCallback? = null
    var accelerometerListener: AccelerometerDataChangedCallback? = null
    var gyroListener: GyroDataChangedCallback? = null
    var stepListener: StepDataChangedCallback? = null
    var angleListener: AngleDataChangedCallback? = null
    var motionListener: MotionDataChangedCallback? = null

    var stateListener: SensorStateChangedCallback? = null

    protected val mAccelerometerReading = FloatArray(3)
    protected val mMagnetometerReading = FloatArray(3)
    protected val mGyroReading = FloatArray(3)

    abstract fun disconnect()
    abstract fun connectTo(deviceID: String)
    abstract fun getName(): String
    abstract fun isConnectable(): Boolean

    fun addStateListener(listener: SensorStateChangedCallback?){
        stateListener = listener
    }

    interface MagnetometerDataChangedCallback {
        fun onMagnetometerDataUpdate(data: FloatArray)
    }

    interface AccelerometerDataChangedCallback {
        fun onAccelerometerDataUpdate(data: FloatArray, timestamp: Long)
    }

    interface GyroDataChangedCallback {
        fun onGyroDataUpdate(data: FloatArray)
    }

    interface StepDataChangedCallback {
        fun onStepDataUpdate(data: StepData)
    }

    interface AngleDataChangedCallback {
        fun onAngleDataUpdate(data: Float)
    }

    interface MotionDataChangedCallback {
        fun onMotionDataUpdate(data: Int)
    }

    interface SensorStateChangedCallback {
        fun onStateConnected(name: String)
        fun onStateDisconnected()
    }

    enum class Type {
        SENSOR_TILE,
        ANDROID_DEVICE,
        MOCKED_SENSOR
    }

    data class StepData(val stepCount: Int, val frequency: Int)

    abstract fun subscribeToMagnetometerChange()
    abstract fun subscribeToAccChange()
    abstract fun subscribeToGyroChange()
    abstract fun subscribeToMotionChange()
    abstract fun subscribeToAngleChangeChange()
    abstract fun subscribeToSpeedChange()
    abstract fun unSubscribe()
    abstract fun saveSensorData(suffix: String): String
}


