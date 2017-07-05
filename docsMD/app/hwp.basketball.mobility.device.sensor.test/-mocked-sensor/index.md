[app](../../index.md) / [hwp.basketball.mobility.device.sensor.test](../index.md) / [MockedSensor](.)

# MockedSensor

`class MockedSensor : `[`BaseSensor`](../../hwp.basketball.mobility.device.sensor/-base-sensor/index.md)

Created by dusan_cvetkovic on 5/21/17.

### Constructors

| [&lt;init&gt;](-init-.md) | `MockedSensor(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`)`<br>Created by dusan_cvetkovic on 5/21/17. |

### Inherited Properties

| [accelerometerListener](../../hwp.basketball.mobility.device.sensor/-base-sensor/accelerometer-listener.md) | `var accelerometerListener: `[`AccelerometerDataChangedCallback`](../../hwp.basketball.mobility.device.sensor/-base-sensor/-accelerometer-data-changed-callback/index.md)`?` |
| [angleListener](../../hwp.basketball.mobility.device.sensor/-base-sensor/angle-listener.md) | `var angleListener: `[`AngleDataChangedCallback`](../../hwp.basketball.mobility.device.sensor/-base-sensor/-angle-data-changed-callback/index.md)`?` |
| [context](../../hwp.basketball.mobility.device.sensor/-base-sensor/context.md) | `val context: `[`Context`](https://developer.android.com/reference/android/content/Context.html) |
| [gyroListener](../../hwp.basketball.mobility.device.sensor/-base-sensor/gyro-listener.md) | `var gyroListener: `[`GyroDataChangedCallback`](../../hwp.basketball.mobility.device.sensor/-base-sensor/-gyro-data-changed-callback/index.md)`?` |
| [mAccelerometerReading](../../hwp.basketball.mobility.device.sensor/-base-sensor/m-accelerometer-reading.md) | `val mAccelerometerReading: `[`FloatArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/index.html) |
| [mGyroReading](../../hwp.basketball.mobility.device.sensor/-base-sensor/m-gyro-reading.md) | `val mGyroReading: `[`FloatArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/index.html) |
| [mMagnetometerReading](../../hwp.basketball.mobility.device.sensor/-base-sensor/m-magnetometer-reading.md) | `val mMagnetometerReading: `[`FloatArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/index.html) |
| [magnetometerListener](../../hwp.basketball.mobility.device.sensor/-base-sensor/magnetometer-listener.md) | `var magnetometerListener: `[`MagnetometerDataChangedCallback`](../../hwp.basketball.mobility.device.sensor/-base-sensor/-magnetometer-data-changed-callback/index.md)`?` |
| [motionListener](../../hwp.basketball.mobility.device.sensor/-base-sensor/motion-listener.md) | `var motionListener: `[`MotionDataChangedCallback`](../../hwp.basketball.mobility.device.sensor/-base-sensor/-motion-data-changed-callback/index.md)`?` |
| [stateListener](../../hwp.basketball.mobility.device.sensor/-base-sensor/state-listener.md) | `var stateListener: `[`SensorStateChangedCallback`](../../hwp.basketball.mobility.device.sensor/-base-sensor/-sensor-state-changed-callback/index.md)`?` |
| [stepListener](../../hwp.basketball.mobility.device.sensor/-base-sensor/step-listener.md) | `var stepListener: `[`StepDataChangedCallback`](../../hwp.basketball.mobility.device.sensor/-base-sensor/-step-data-changed-callback/index.md)`?` |

### Functions

| [connectTo](connect-to.md) | `fun connectTo(deviceID: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [disconnect](disconnect.md) | `fun disconnect(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getFile](get-file.md) | `fun getFile(clazz: `[`Class`](https://developer.android.com/reference/java/lang/Class.html)`<*>, filename: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`File`](https://developer.android.com/reference/java/io/File.html) |
| [getName](get-name.md) | `fun getName(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [isConnectable](is-connectable.md) | `fun isConnectable(): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [saveSensorData](save-sensor-data.md) | `fun saveSensorData(suffix: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [subscribeToAccChange](subscribe-to-acc-change.md) | `fun subscribeToAccChange(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [subscribeToAngleChangeChange](subscribe-to-angle-change-change.md) | `fun subscribeToAngleChangeChange(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [subscribeToGyroChange](subscribe-to-gyro-change.md) | `fun subscribeToGyroChange(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [subscribeToMagnetometerChange](subscribe-to-magnetometer-change.md) | `fun subscribeToMagnetometerChange(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [subscribeToMotionChange](subscribe-to-motion-change.md) | `fun subscribeToMotionChange(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [subscribeToSpeedChange](subscribe-to-speed-change.md) | `fun subscribeToSpeedChange(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [unSubscribe](un-subscribe.md) | `fun unSubscribe(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| [addStateListener](../../hwp.basketball.mobility.device.sensor/-base-sensor/add-state-listener.md) | `fun addStateListener(listener: `[`SensorStateChangedCallback`](../../hwp.basketball.mobility.device.sensor/-base-sensor/-sensor-state-changed-callback/index.md)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

