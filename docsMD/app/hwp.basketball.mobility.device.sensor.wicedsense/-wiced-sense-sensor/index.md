[app](../../index.md) / [hwp.basketball.mobility.device.sensor.wicedsense](../index.md) / [WicedSenseSensor](.)

# WicedSenseSensor

`class WicedSenseSensor : `[`BaseSensor`](../../hwp.basketball.mobility.device.sensor/-base-sensor/index.md)`, `[`Callback`](../../hwp.basketball.mobility.device.sensor.wicedsense.ledevicepicker/-device-picker/-callback/index.md)`, `[`Callback`](https://developer.android.com/reference/android/os/Handler/Callback.html)

Wiced Sense Base Sensor implementation.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `WicedSenseSensor(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`)`<br>Wiced Sense Base Sensor implementation. |

### Properties

| Name | Summary |
|---|---|
| [context](context.md) | `val context: `[`Context`](https://developer.android.com/reference/android/content/Context.html) |
| [isConnectable](is-connectable.md) | `val isConnectable: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Ble devices return true, others false |

### Inherited Properties

| Name | Summary |
|---|---|
| [accelerometerObservable](../../hwp.basketball.mobility.device.sensor/-base-sensor/accelerometer-observable.md) | `val accelerometerObservable: PublishSubject<`[`AccData`](../../hwp.basketball.mobility.device.sensor/-b-m-sensor-manager/-acc-data/index.md)`>`<br>Trigger this listener when your sensor detects change in accelerometer  |
| [angleObservable](../../hwp.basketball.mobility.device.sensor/-base-sensor/angle-observable.md) | `val angleObservable: PublishSubject<`[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`>`<br>Trigger this listener when your sensor detects change in angle  |
| [mAccelerometerReading](../../hwp.basketball.mobility.device.sensor/-base-sensor/m-accelerometer-reading.md) | `val mAccelerometerReading: `[`FloatArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/index.html) |
| [mGyroReading](../../hwp.basketball.mobility.device.sensor/-base-sensor/m-gyro-reading.md) | `val mGyroReading: `[`FloatArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/index.html) |
| [mMagnetometerReading](../../hwp.basketball.mobility.device.sensor/-base-sensor/m-magnetometer-reading.md) | `val mMagnetometerReading: `[`FloatArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/index.html) |
| [motionObservable](../../hwp.basketball.mobility.device.sensor/-base-sensor/motion-observable.md) | `val motionObservable: PublishSubject<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>`<br>Trigger this listener when your sensor detects change in movement  |
| [stateListener](../../hwp.basketball.mobility.device.sensor/-base-sensor/state-listener.md) | `var stateListener: `[`SensorStateChangedCallback`](../../hwp.basketball.mobility.device.sensor/-base-sensor/-sensor-state-changed-callback/index.md)`?` |

### Functions

| Name | Summary |
|---|---|
| [connectTo](connect-to.md) | `fun connectTo(deviceID: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Connect to BLE node if it is BLE device |
| [disconnect](disconnect.md) | `fun disconnect(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Unregister listeners to prevent wasting resources, and disconnect if needed (BLE). |
| [getName](get-name.md) | `fun getName(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Return name of BLE node(address). |
| [handleMessage](handle-message.md) | `fun handleMessage(msg: `[`Message`](https://developer.android.com/reference/android/os/Message.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Handler callback used for two purposes |
| [initResourcesAndResume](init-resources-and-resume.md) | `fun initResourcesAndResume(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Initialize async resources in series |
| [onDevicePickCancelled](on-device-pick-cancelled.md) | `fun onDevicePickCancelled(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onDevicePicked](on-device-picked.md) | `fun onDevicePicked(device: `[`BluetoothDevice`](https://developer.android.com/reference/android/bluetooth/BluetoothDevice.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [subscribeForUpdates](subscribe-for-updates.md) | `fun subscribeForUpdates(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Implement this method and register callbacks specific for each sensor. |

### Inherited Functions

| Name | Summary |
|---|---|
| [addStateListener](../../hwp.basketball.mobility.device.sensor/-base-sensor/add-state-listener.md) | `fun addStateListener(listener: `[`SensorStateChangedCallback`](../../hwp.basketball.mobility.device.sensor/-base-sensor/-sensor-state-changed-callback/index.md)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
