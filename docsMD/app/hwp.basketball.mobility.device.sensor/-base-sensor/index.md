[app](../../index.md) / [hwp.basketball.mobility.device.sensor](../index.md) / [BaseSensor](.)

# BaseSensor

`abstract class BaseSensor`

Created by dusan_cvetkovic on 3/4/17.

### Types

| [AccelerometerDataChangedCallback](-accelerometer-data-changed-callback/index.md) | `interface AccelerometerDataChangedCallback` |
| [AngleDataChangedCallback](-angle-data-changed-callback/index.md) | `interface AngleDataChangedCallback` |
| [GyroDataChangedCallback](-gyro-data-changed-callback/index.md) | `interface GyroDataChangedCallback` |
| [MagnetometerDataChangedCallback](-magnetometer-data-changed-callback/index.md) | `interface MagnetometerDataChangedCallback` |
| [MotionDataChangedCallback](-motion-data-changed-callback/index.md) | `interface MotionDataChangedCallback` |
| [SensorStateChangedCallback](-sensor-state-changed-callback/index.md) | `interface SensorStateChangedCallback` |
| [StepData](-step-data/index.md) | `data class StepData` |
| [StepDataChangedCallback](-step-data-changed-callback/index.md) | `interface StepDataChangedCallback` |
| [Type](-type/index.md) | `enum class Type` |

### Constructors

| [&lt;init&gt;](-init-.md) | `BaseSensor(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`)`<br>Created by dusan_cvetkovic on 3/4/17. |

### Properties

| [accelerometerListener](accelerometer-listener.md) | `var accelerometerListener: `[`AccelerometerDataChangedCallback`](-accelerometer-data-changed-callback/index.md)`?` |
| [angleListener](angle-listener.md) | `var angleListener: `[`AngleDataChangedCallback`](-angle-data-changed-callback/index.md)`?` |
| [context](context.md) | `val context: `[`Context`](https://developer.android.com/reference/android/content/Context.html) |
| [gyroListener](gyro-listener.md) | `var gyroListener: `[`GyroDataChangedCallback`](-gyro-data-changed-callback/index.md)`?` |
| [mAccelerometerReading](m-accelerometer-reading.md) | `val mAccelerometerReading: `[`FloatArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/index.html) |
| [mGyroReading](m-gyro-reading.md) | `val mGyroReading: `[`FloatArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/index.html) |
| [mMagnetometerReading](m-magnetometer-reading.md) | `val mMagnetometerReading: `[`FloatArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/index.html) |
| [magnetometerListener](magnetometer-listener.md) | `var magnetometerListener: `[`MagnetometerDataChangedCallback`](-magnetometer-data-changed-callback/index.md)`?` |
| [motionListener](motion-listener.md) | `var motionListener: `[`MotionDataChangedCallback`](-motion-data-changed-callback/index.md)`?` |
| [stateListener](state-listener.md) | `var stateListener: `[`SensorStateChangedCallback`](-sensor-state-changed-callback/index.md)`?` |
| [stepListener](step-listener.md) | `var stepListener: `[`StepDataChangedCallback`](-step-data-changed-callback/index.md)`?` |

### Functions

| [addStateListener](add-state-listener.md) | `fun addStateListener(listener: `[`SensorStateChangedCallback`](-sensor-state-changed-callback/index.md)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [connectTo](connect-to.md) | `abstract fun connectTo(deviceID: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [disconnect](disconnect.md) | `abstract fun disconnect(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getName](get-name.md) | `abstract fun getName(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [isConnectable](is-connectable.md) | `abstract fun isConnectable(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [saveSensorData](save-sensor-data.md) | `abstract fun saveSensorData(suffix: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [subscribeToAccChange](subscribe-to-acc-change.md) | `abstract fun subscribeToAccChange(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [subscribeToAngleChangeChange](subscribe-to-angle-change-change.md) | `abstract fun subscribeToAngleChangeChange(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [subscribeToGyroChange](subscribe-to-gyro-change.md) | `abstract fun subscribeToGyroChange(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [subscribeToMagnetometerChange](subscribe-to-magnetometer-change.md) | `abstract fun subscribeToMagnetometerChange(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [subscribeToMotionChange](subscribe-to-motion-change.md) | `abstract fun subscribeToMotionChange(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [subscribeToSpeedChange](subscribe-to-speed-change.md) | `abstract fun subscribeToSpeedChange(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [unSubscribe](un-subscribe.md) | `abstract fun unSubscribe(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| [AndroidSensor](../../hwp.basketball.mobility.device.sensor.android/-android-sensor/index.md) | `class AndroidSensor : BaseSensor, `[`SensorEventListener`](https://developer.android.com/reference/android/hardware/SensorEventListener.html)<br>Created by dusan_cvetkovic on 3/4/17. |
| [MockedSensor](../../hwp.basketball.mobility.device.sensor.test/-mocked-sensor/index.md) | `class MockedSensor : BaseSensor`<br>Created by dusan_cvetkovic on 5/21/17. |
| [SensorTileSensor](../../hwp.basketball.mobility.device.sensor.sensortile/-sensor-tile-sensor/index.md) | `open class SensorTileSensor : BaseSensor, FeatureListener, NodeStateListener`<br>Created by dusan_cvetkovic on 3/4/17. |

