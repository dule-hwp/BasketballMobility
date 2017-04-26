package hwp.basketball.mobility.device.sensor

import android.content.SharedPreferences
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import org.reactivestreams.Subscriber
import timber.log.Timber


/**
 * Created by dusan_cvetkovic on 3/4/17.
 */

abstract class BaseSensor {

    var magnetometerListener: MagnetometerDataChangedCallback? = null
    var accelerometerListener: AccelerometerDataChangedCallback? = null
    var gyroListener: GyroDataChangedCallback? = null


    protected val mAccelerometerReading = FloatArray(3)
    protected val mMagnetometerReading = FloatArray(3)
    protected val mGyroReading = FloatArray(3)

//    private val mRotationMatrix = FloatArray(9)
//    private val mOrientationAngles = FloatArray(3)

    abstract fun disconnect()
    abstract fun connectTo(deviceID: String)
    abstract fun getName(): String
    abstract fun isConnectable(): Boolean

    interface MagnetometerDataChangedCallback {
        fun onMagnetometerDataUpdate(data: FloatArray)
    }

    interface AccelerometerDataChangedCallback {
        fun onAccelerometerDataUpdate(data: FloatArray)
    }

    interface GyroDataChangedCallback {
        fun onGyroDataUpdate(data: FloatArray)
    }

    interface SensorStateChangedCallback {
        fun onStateConnected(name: String)
        fun onStateDisconnected()
    }

    enum class Type {
        SENSOR_TILE,
        ANDROID_DEVICE
    }

//    @Inject
//    private val sharedPref = getSharedPrefs()

    abstract fun getSharedPrefs(): SharedPreferences

    fun loadCalibrationData(): FloatArray? {
//        val sharedPref = BasketballMobilityApp.activity.getSharedPreferences(sensorPrefs,Context.MODE_PRIVATE)
        val calibrationDataJson = getSharedPrefs().getString(this.getName(), null)
        val calibrationData = Gson().fromJson(calibrationDataJson, FloatArray::class.java)
        return calibrationData
    }

//    fun saveCalibrationData(calibrationData: FloatArray?) {
////        val sharedPref = BasketballMobilityApp.activity.getSharedPreferences(sensorPrefs,Context.MODE_PRIVATE)
//        val editor = getSharedPrefs().edit()
//        val json = Gson().toJson(calibrationData)
//        val writeOk = editor.putString(getName(), json).commit()
//        if (!writeOk)
//            throw RuntimeException("Error saving calibration data !")
//    }

    abstract fun subscribeToMagnetometerChange()

//    private var mSensorManager: SensorManager = activity.getSystemService(Context.SENSOR_SERVICE) as SensorManager

//    fun updateOrientationAngles(): Float {
//        // Update rotation matrix, which is needed to update orientation angles.
//
//        SensorManager.getRotationMatrix(mRotationMatrix, null,
//                mAccelerometerReading, mMagnetometerReading)
//
//        // "mRotationMatrix" now has up-to-date information.
//
//        SensorManager.getOrientation(mRotationMatrix, mOrientationAngles)
//
//        // "mOrientationAngles" now has up-to-date information.
//
//        Timber.d(mOrientationAngles.toString())
//        return mOrientationAngles[0]
//    }

    abstract fun subscribeToAccChange()
    abstract fun unSubscribeFromAccChange()
    abstract fun unSubscribeFromMagnetometerChange()
    abstract fun subscribeToGyroChange()
    abstract fun unSubscribeFromGyroChange()
}