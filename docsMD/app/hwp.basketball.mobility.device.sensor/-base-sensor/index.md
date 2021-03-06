[app](../../index.md) / [hwp.basketball.mobility.device.sensor](../index.md) / [BaseSensor](.)

# BaseSensor

`abstract class BaseSensor`

Each of the sensors needs to extend this class and implement required methods.

After sensor is connected during drill preparation phase, connecting to sensor should be done
via uuid which is argument passed to [connectTo](connect-to.md) method.

Implementation of this class should trigger each of the listeners to inform sensor user what data has changed.

Note that connection to sensor should be done separately, because each of the BLE sensors
has its own SDK and connecting/searching for devices is done differently for each wearable sensor.

**See Also**

[connectTo](connect-to.md)

### Types

| Name | Summary |
|---|---|
| [SensorStateChangedCallback](-sensor-state-changed-callback/index.md) | `interface SensorStateChangedCallback` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BaseSensor()`<br>Each of the sensors needs to extend this class and implement required methods. |

### Properties

| Name | Summary |
|---|---|
| [accelerometerObservable](accelerometer-observable.md) | `val accelerometerObservable: PublishSubject<`[`AccData`](../-b-m-sensor-manager/-acc-data/index.md)`>`<br>Trigger this listener when your sensor detects change in accelerometer  |
| [angleObservable](angle-observable.md) | `val angleObservable: PublishSubject<`[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`>`<br>Trigger this listener when your sensor detects change in angle  |
| [isConnectable](is-connectable.md) | `abstract val isConnectable: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Ble devices return true, others false |
| [mAccelerometerReading](m-accelerometer-reading.md) | `val mAccelerometerReading: `[`FloatArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/index.html) |
| [mGyroReading](m-gyro-reading.md) | `val mGyroReading: `[`FloatArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/index.html) |
| [mMagnetometerReading](m-magnetometer-reading.md) | `val mMagnetometerReading: `[`FloatArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/index.html) |
| [motionObservable](motion-observable.md) | `val motionObservable: PublishSubject<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>`<br>Trigger this listener when your sensor detects change in movement  |
| [stateListener](state-listener.md) | `var stateListener: `[`SensorStateChangedCallback`](-sensor-state-changed-callback/index.md)`?` |

### Functions

| Name | Summary |
|---|---|
| [addStateListener](add-state-listener.md) | `fun addStateListener(listener: `[`SensorStateChangedCallback`](-sensor-state-changed-callback/index.md)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [connectTo](connect-to.md) | `abstract fun connectTo(deviceID: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Connect to BLE node if it is BLE device |
| [disconnect](disconnect.md) | `abstract fun disconnect(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Unregister listeners to prevent wasting resources, and disconnect if needed (BLE). |
| [getName](get-name.md) | `abstract fun getName(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Return name of BLE node(address). |
| [subscribeForUpdates](subscribe-for-updates.md) | `abstract fun subscribeForUpdates(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Implement this method and register callbacks specific for each sensor. |

### Inheritors

| Name | Summary |
|---|---|
| [AndroidSensor](../../hwp.basketball.mobility.device.sensor.android/-android-sensor/index.md) | `class AndroidSensor : BaseSensor, `[`SensorEventListener`](https://developer.android.com/reference/android/hardware/SensorEventListener.html)<br>Created by dusan_cvetkovic on 3/4/17. |
| [MockedSensor](../../hwp.basketball.mobility.device.sensor.test/-mocked-sensor/index.md) | `class MockedSensor : BaseSensor`<br>Sensor implementation intended to be used in instrumented tests. |
| [SensorTileSensor](../../hwp.basketball.mobility.device.sensor.sensortile/-sensor-tile-sensor/index.md) | `open class SensorTileSensor : BaseSensor, FeatureListener, NodeStateListener`<br>Created by dusan_cvetkovic on 3/4/17. |
| [WicedSenseSensor](../../hwp.basketball.mobility.device.sensor.wicedsense/-wiced-sense-sensor/index.md) | `class WicedSenseSensor : BaseSensor, `[`Callback`](../../hwp.basketball.mobility.device.sensor.wicedsense.ledevicepicker/-device-picker/-callback/index.md)`, `[`Callback`](https://developer.android.com/reference/android/os/Handler/Callback.html)<br>Wiced Sense Base Sensor implementation. |
