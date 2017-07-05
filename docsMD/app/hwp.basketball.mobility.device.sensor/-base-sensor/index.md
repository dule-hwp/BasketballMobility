[app](../../index.md) / [hwp.basketball.mobility.device.sensor](../index.md) / [BaseSensor](.)

# BaseSensor

`abstract class BaseSensor`

Created by dusan_cvetkovic on 3/4/17.

### Types

| [AccelerometerDataChangedCallback](-accelerometer-data-changed-callback/index.md) | `interface AccelerometerDataChangedCallback` |
| [AngleDataChangedCallback](-angle-data-changed-callback/index.md) | `interface AngleDataChangedCallback` |
| [MagnetometerDataChangedCallback](-magnetometer-data-changed-callback/index.md) | `interface MagnetometerDataChangedCallback` |
| [MovingStateChangedCallback](-moving-state-changed-callback/index.md) | `interface MovingStateChangedCallback` |
| [SensorStateChangedCallback](-sensor-state-changed-callback/index.md) | `interface SensorStateChangedCallback` |
| [Type](-type/index.md) | `enum class Type` |

### Constructors

| [&lt;init&gt;](-init-.md) | `BaseSensor(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`)`<br>Created by dusan_cvetkovic on 3/4/17. |

### Properties

| [accelerometerListener](accelerometer-listener.md) | `var accelerometerListener: `[`AccelerometerDataChangedCallback`](-accelerometer-data-changed-callback/index.md)`?` |
| [angleListener](angle-listener.md) | `var angleListener: `[`AngleDataChangedCallback`](-angle-data-changed-callback/index.md)`?`<br>Trigger this listener when your sensor detects change in angle |
| [context](context.md) | `val context: `[`Context`](https://developer.android.com/reference/android/content/Context.html) |
| [isConnectable](is-connectable.md) | `abstract val isConnectable: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Ble devices return true, others false |
| [mAccelerometerReading](m-accelerometer-reading.md) | `val mAccelerometerReading: `[`FloatArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/index.html) |
| [mGyroReading](m-gyro-reading.md) | `val mGyroReading: `[`FloatArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/index.html) |
| [mMagnetometerReading](m-magnetometer-reading.md) | `val mMagnetometerReading: `[`FloatArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/index.html) |
| [magnetometerListener](magnetometer-listener.md) | `var magnetometerListener: `[`MagnetometerDataChangedCallback`](-magnetometer-data-changed-callback/index.md)`?` |
| [motionListener](motion-listener.md) | `var motionListener: `[`MovingStateChangedCallback`](-moving-state-changed-callback/index.md)`?`<br>Trigger this listener when your sensor detects change in movement |
| [stateListener](state-listener.md) | `var stateListener: `[`SensorStateChangedCallback`](-sensor-state-changed-callback/index.md)`?`<br>Trigger this listener when your sensor gets (dis)connected |

### Functions

| [addStateListener](add-state-listener.md) | `fun addStateListener(listener: `[`SensorStateChangedCallback`](-sensor-state-changed-callback/index.md)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [connectTo](connect-to.md) | `abstract fun connectTo(deviceID: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Connect to BLE node if it is BLE device |
| [disconnect](disconnect.md) | `abstract fun disconnect(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Unregister listeners to prevent wasting resources, and disconnect if needed (BLE). |
| [getName](get-name.md) | `abstract fun getName(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Return name of BLE node(address). |
| [subscribeForUpdates](subscribe-for-updates.md) | `abstract fun subscribeForUpdates(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Implement this method and register callbacks specific for each sensor. |

### Inheritors

| [AndroidSensor](../../hwp.basketball.mobility.device.sensor.android/-android-sensor/index.md) | `class AndroidSensor : BaseSensor, `[`SensorEventListener`](https://developer.android.com/reference/android/hardware/SensorEventListener.html)<br>Created by dusan_cvetkovic on 3/4/17. |
| [MockedSensor](../../hwp.basketball.mobility.device.sensor.test/-mocked-sensor/index.md) | `class MockedSensor : BaseSensor`<br>Created by dusan_cvetkovic on 5/21/17. |
| [SensorTileSensor](../../hwp.basketball.mobility.device.sensor.sensortile/-sensor-tile-sensor/index.md) | `open class SensorTileSensor : BaseSensor, FeatureListener, NodeStateListener`<br>Created by dusan_cvetkovic on 3/4/17. |
| [WicedSenseSensor](../../hwp.basketball.mobility.device.sensor.wicedsense/-wiced-sense-sensor/index.md) | `class WicedSenseSensor : BaseSensor, `[`Callback`](../../hwp.basketball.mobility.device.sensor.wicedsense.ledevicepicker/-device-picker/-callback/index.md)`, `[`Callback`](https://developer.android.com/reference/android/os/Handler/Callback.html)<br>Created by dusan_cvetkovic on 7/4/17. |

