[app](../../index.md) / [hwp.basketball.mobility.device.sensor.test](../index.md) / [MockedSensor](.)

# MockedSensor

`class MockedSensor : `[`BaseSensor`](../../hwp.basketball.mobility.device.sensor/-base-sensor/index.md)

Sensor implementation intended to be used in instrumented tests.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `MockedSensor(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`)`<br>Sensor implementation intended to be used in instrumented tests. |

### Properties

| Name | Summary |
|---|---|
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
| [getFile](get-file.md) | `fun getFile(clazz: `[`Class`](https://developer.android.com/reference/java/lang/Class.html)`<*>, filename: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`File`](https://developer.android.com/reference/java/io/File.html) |
| [getName](get-name.md) | `fun getName(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Return name of BLE node(address). |
| [subscribeForUpdates](subscribe-for-updates.md) | `fun subscribeForUpdates(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Implement this method and register callbacks specific for each sensor. |

### Inherited Functions

| Name | Summary |
|---|---|
| [addStateListener](../../hwp.basketball.mobility.device.sensor/-base-sensor/add-state-listener.md) | `fun addStateListener(listener: `[`SensorStateChangedCallback`](../../hwp.basketball.mobility.device.sensor/-base-sensor/-sensor-state-changed-callback/index.md)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
