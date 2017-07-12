package hwp.basketball.mobility.device.sensor

import hwp.basketball.mobility.device.sensor.BMSensorManager.AccData
import io.reactivex.subjects.PublishSubject


/**
 * Each of the sensors needs to extend this class and implement required methods.
 *
 * After sensor is connected during drill preparation phase, connecting to sensor should be done
 * via uuid which is argument passed to [connectTo] method.
 *
 * Implementation of this class should trigger each of the listeners to inform sensor user what data has changed.
 *
 * Note that connection to sensor should be done separately, because each of the BLE sensors
 * has its own SDK and connecting/searching for devices is done differently for each wearable sensor.
 *
 * @see connectTo
 */

abstract class BaseSensor {

    /**
     * Trigger this listener when your sensor detects change in accelerometer
     * <br/>
     * */
    val accelerometerObservable: PublishSubject<AccData> = PublishSubject.create<AccData>()

    /**
     *
     * Trigger this listener when your sensor detects change in angle
     * <br/>
     * */
    val angleObservable: PublishSubject<Float> = PublishSubject.create<Float>()

    /**
     *
     * Trigger this listener when your sensor detects change in movement
     * <br/>
     * */
    val motionObservable: PublishSubject<Boolean> = PublishSubject.create<Boolean>()

    /**
     *
     * @property stateListener Trigger this listener when your sensor gets (dis)connected
     *
     * */
    var stateListener: SensorStateChangedCallback? = null

    protected val mAccelerometerReading = FloatArray(3)
    protected val mMagnetometerReading = FloatArray(3)
    protected val mGyroReading = FloatArray(3)

    fun addStateListener(listener: SensorStateChangedCallback?) {
        stateListener = listener
    }

    interface SensorStateChangedCallback {
        fun onStateConnected(name: String)
        fun onStateDisconnected()
    }

    /**
     * Ble devices return true, others false
     * */
    abstract val isConnectable: Boolean

    /**
     * Implement this method and register callbacks specific for each sensor.
     *
     * E.g. if it is BLE enable notifications for characteristics you need
     *
     * If it is Android device register needed listeners...
     * */
    abstract fun subscribeForUpdates()

    /** Unregister listeners to prevent wasting resources, and disconnect if needed (BLE). */
    abstract fun disconnect()

    /** Connect to BLE node if it is BLE device
     * @param deviceID Id of the device to connect to. Usually found after BLE scan.
     * */
    abstract fun connectTo(deviceID: String)

    /**Return name of BLE node(address).*/
    abstract fun getName(): String
}


