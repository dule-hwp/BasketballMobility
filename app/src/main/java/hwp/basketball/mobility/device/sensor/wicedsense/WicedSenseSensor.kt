package hwp.basketball.mobility.device.sensor.wicedsense

import android.bluetooth.BluetoothDevice
import android.content.Context
import android.net.Uri
import android.os.Handler
import android.os.HandlerThread
import android.os.Message
import hwp.basketball.mobility.R
import hwp.basketball.mobility.device.sensor.BMSensorManager.AccData
import hwp.basketball.mobility.device.sensor.BaseSensor
import hwp.basketball.mobility.device.sensor.wicedsense.ledevicepicker.DevicePicker
import hwp.basketball.mobility.device.sensor.wicedsense.wicedsmart.ota.OtaAppInfo
import hwp.basketball.mobility.device.sensor.wicedsense.ws_bs.SenseManager
import hwp.basketball.mobility.device.sensor.wicedsense.ws_bs.SensorDataParser
import hwp.basketball.mobility.device.sensor.wicedsense.ws_bs.Settings
import hwp.basketball.mobility.device.sensor.wicedsense.ws_bs.Settings.DBG
import timber.log.Timber


/**
 * Wiced Sense Base Sensor implementation.
 */
class WicedSenseSensor(val context: Context) : BaseSensor(), DevicePicker.Callback, Handler.Callback {
    override fun onDevicePicked(device: BluetoothDevice?) {
        Timber.d("onDevicePicked")
        mSenseManager?.device = device
        updateConnectionStateWidgets()
    }

    override fun onDevicePickCancelled() {
        Timber.d("onDevicePickCancelled")
        updateConnectionStateWidgets()
    }

    private val COMPLETE_INIT = 800
    private val PROCESS_SENSOR_DATA_ON_UI = 801
    private val PROCESS_BATTERY_STATUS_UI = 802
    private val PROCESS_EVENT_DEVICE_UNSUPPORTED = 803
    private val PROCESS_CONNECTION_STATE_CHANGE_UI = 804

    override val isConnectable: Boolean = true

    override fun subscribeForUpdates() {

    }

    override fun disconnect() {

    }

    private var mSenseManager: SenseManager? = null

    private val mUiHandler: android.os.Handler by lazy {
        UiHandlerCallback()
    }

    private inner class UiHandlerCallback : android.os.Handler() {

        override fun handleMessage(msg: Message) {
            when (msg.what) {
            // These events run on the mUiHandler on the UI Main Thread
                COMPLETE_INIT -> initResourcesAndResume(context)
                PROCESS_EVENT_DEVICE_UNSUPPORTED -> Timber.d("error_unsupported_device")
                PROCESS_CONNECTION_STATE_CHANGE_UI -> updateConnectionStateWidgets()
//                PROCESS_BATTERY_STATUS_UI -> updateBatteryLevelWidget(msg.arg1)
                PROCESS_SENSOR_DATA_ON_UI -> processSensorData(msg.obj as ByteArray)
            }
//            return true
        }
    }

    private var mLastRefreshTimeMs: Long = 0

    /**
     * Parses the sensor data bytes and updates the corresponding sensor(s) UI
     * component

     * @param sensorData
     */
    private fun processSensorData(sensorData: ByteArray) {

        val maskField = sensorData[0].toInt()
        var offset: Int
        val values = IntArray(3)
        val currentTimeMs = System.currentTimeMillis()
        when (sensorData.size) {
            19 -> {
                if (currentTimeMs - mLastRefreshTimeMs < Settings.REFRESH_INTERVAL_MS) {
                    return
                } else {
                    mLastRefreshTimeMs = currentTimeMs
                }

                // packet type specifying accelerometer, gyro, magno
                offset = 1
                if (SensorDataParser.accelerometerHasChanged(maskField)) {
                    for (i in mAccelerometerReading.indices) {
                        mAccelerometerReading[i] = values[i].toFloat()
                    }
//                    mAccelerometerFrag.setValue(mAnimation, values[0], values[1], values[2])
                    accelerometerObservable.onNext(AccData(mAccelerometerReading, System.currentTimeMillis()))

                    offset += SensorDataParser.SENSOR_ACCEL_DATA_SIZE
                }

                if (SensorDataParser.gyroHasChanged(maskField)) {
                    for (i in mGyroReading.indices) {
                        mGyroReading[i] = values[i].toFloat()
                    }
//                    mGyroFrag.setValue(mAnimation, values[0], values[1], values[2])

                    offset += SensorDataParser.SENSOR_GYRO_DATA_SIZE
                }

                if (SensorDataParser.magnetometerHasChanged(maskField)) {

                    val angle = SensorDataParser.getCompassAngleDegrees(values)
//                    mCompassFrag.setValue(mAnimation, angle, values[0], values[1], values[2])
                    angleObservable.onNext(angle)

                    offset += SensorDataParser.SENSOR_MAGNO_DATA_SIZE
                }
            }

        }
        // If animation is enabled, call animate...
    }


    private var mInitState: Int = 0

    private val mSensorDataEventHandler by lazy {
        android.os.Handler(mSensorDataEventThread.looper, this)
    }

    private val mSensorDataEventThread = HandlerThread("WicedSenseEventHandlerThread")

    private val mDevicePicker by lazy {
        DevicePicker(context, this, Uri.parse("content://com.brodcom.app.wicedsense/device/pick"))
    }

    init {
        mSensorDataEventThread.start()
        mDevicePicker.init()
    }


    /**
     * Initialize async resources in series

     * @return
     */
    fun initResourcesAndResume(context: Context): Boolean {
        when (mInitState) {
            0 -> {
                // Check if license accepted. If not, prompt user
//                if (!mLicense.checkLicenseAccepted(getFragmentManager())) {
//                    return false
//                }
                mInitState++
                // Check if BT is on, If not, prompt user
//                if (!BluetoothEnabler.checkBluetoothOn(this)) {
//                    return false
//                }
                mInitState++
                SenseManager.init(context)
                // Check if sense manager initialized. If not, keep waiting
                if (waitForSenseManager()) {
                    return false
                }
                mInitState = -1
                checkDevicePicked()
            }
            1 -> {
//                if (!BluetoothEnabler.checkBluetoothOn(this)) {
//                    return false
//                }
                mInitState++
                SenseManager.init(context)
                if (waitForSenseManager()) {
                    return false
                }
                mInitState = -1
                checkDevicePicked()
            }
            2 -> {
                if (waitForSenseManager()) {
                    return false
                }
                mInitState = -1
                checkDevicePicked()
            }
        }
        mSenseManager?.registerEventCallbackHandler(mSensorDataEventHandler)

        mSenseManager?.isConnectedAndAvailable.let {
            mSenseManager?.enableNotifications(true)
        }
        updateConnectionStateWidgets()
//        updateTemperatureScaleType()
//        updateGyroState()
//        updateAccelerometerState()
//        updateCompassState()
//        Settings.addChangeListener(this)
        return true
    }

    /**
     * Handler callback used for two purposes
     *
     *
     * 1. This callback is invoked by the event handler loop when the
     * SenseManager service sends a event from the sensor tag using the
     * mEventHandler object. The event handler loop runs in a child thread, so
     * that it can queue up events and allow the SenseManager (and Bluetooth
     * callbacks) to return asynchronously before the UI processes the event.
     * The event handler loop reposts the event to the main UI handler loop via
     * the mUiHandler Handler
     *
     *
     * 2. This callback is invoked by the mEventHandler object to run a UI
     * operation in the main event loop of the application
     */
    override fun handleMessage(msg: Message): Boolean {
        when (msg.what) {
            SenseManager.EVENT_DEVICE_UNSUPPORTED -> mUiHandler.sendEmptyMessage(PROCESS_EVENT_DEVICE_UNSUPPORTED)
            SenseManager.EVENT_CONNECTED -> {
                mUiHandler.sendEmptyMessage(PROCESS_CONNECTION_STATE_CHANGE_UI)
                onConnected()
            }
            SenseManager.EVENT_DISCONNECTED -> mUiHandler.sendEmptyMessage(PROCESS_CONNECTION_STATE_CHANGE_UI)
            SenseManager.EVENT_BATTERY_STATUS -> mUiHandler.sendMessage(mUiHandler.obtainMessage(PROCESS_BATTERY_STATUS_UI, msg.arg1,
                    msg.arg1))
            SenseManager.EVENT_SENSOR_DATA -> mUiHandler.sendMessage(mUiHandler.obtainMessage(PROCESS_SENSOR_DATA_ON_UI, msg.obj))
            SenseManager.EVENT_APP_INFO -> {
                val success = msg.arg1 == 1
                val appInfo = msg.obj as OtaAppInfo
                if (DBG) {
                    Timber.d("EVENT_APP_INFO: success=$success,otaAppInfo=$appInfo")
                }
            }
        }
        return true
    }

    private fun onConnected() {

        if (DBG) {
            Timber.d("onConnected: enabling notifications")
        }
        mSenseManager?.enableNotifications(true)

    }


    /**
     * Check if a device has been picked, and launch the device picker if not...

     * @return
     */
    private fun checkDevicePicked(): Boolean {
        if (mSenseManager?.device != null) {
            return true
        }
        // Launch device picker
        launchDevicePicker()
        return false
    }

    /**
     * Launch the device picker
     */
    private fun launchDevicePicker() {
        mDevicePicker.launch(mDevicePickerTitle, null, null, context)
    }

    private val mDevicePickerTitle by lazy {
        context.getString(R.string.title_devicepicker)
    }

    /**
     * Acquire reference to the SenseManager serivce....This is asynchronous

     * @return
     */
    private fun waitForSenseManager(): Boolean {
        // Check if the SenseManager is available. If not, keep retrying
        mSenseManager = SenseManager.getInstance()
        if (mSenseManager == null) {
            mUiHandler.sendEmptyMessageDelayed(COMPLETE_INIT, Settings.SERVICE_INIT_TIMEOUT_MS)
            return true
        }
        return false
    }

    override fun connectTo(deviceID: String) {
        initResourcesAndResume(context)
        mSenseManager?.let { senseManager ->
            if (senseManager.isConnectedAndAvailable) {
                if (!senseManager.connect()) {
                    updateConnectionStateWidgets()
                }
            } else {
                if (!senseManager.disconnect()) {
                    updateConnectionStateWidgets()
                }
            }
        }
    }

    private fun updateConnectionStateWidgets() {
        Timber.d("updateConnectionStateWidgets")
    }

    override fun getName(): String = "WicedSense"
}