[app](../../index.md) / [hwp.basketball.mobility.device.sensor.test](../index.md) / [MockedSensor](.)

# MockedSensor

`class MockedSensor : `[`BaseSensor`](../../hwp.basketball.mobility.device.sensor/-base-sensor/index.md)

Created by dusan_cvetkovic on 5/21/17.

### Constructors

| [&lt;init&gt;](-init-.md) | `MockedSensor(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`)`<br>Created by dusan_cvetkovic on 5/21/17. |

### Properties

| [isConnectable](is-connectable.md) | `val isConnectable: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Ble devices return true, others false |

### Inherited Properties

| [accelerometerListener](../../hwp.basketball.mobility.device.sensor/-base-sensor/accelerometer-listener.md) | `var accelerometerListener: `[`AccelerometerDataChangedCallback`](../../hwp.basketball.mobility.device.sensor/-base-sensor/-accelerometer-data-changed-callback/index.md)`?` |
| [angleListener](../../hwp.basketball.mobility.device.sensor/-base-sensor/angle-listener.md) | `var angleListener: `[`AngleDataChangedCallback`](../../hwp.basketball.mobility.device.sensor/-base-sensor/-angle-data-changed-callback/index.md)`?`<br>Trigger this listener when your sensor detects change in angle |
| [context](../../hwp.basketball.mobility.device.sensor/-base-sensor/context.md) | `val context: `[`Context`](https://developer.android.com/reference/android/content/Context.html) |
| [mAccelerometerReading](../../hwp.basketball.mobility.device.sensor/-base-sensor/m-accelerometer-reading.md) | `val mAccelerometerReading: `[`FloatArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/index.html) |
| [mGyroReading](../../hwp.basketball.mobility.device.sensor/-base-sensor/m-gyro-reading.md) | `val mGyroReading: `[`FloatArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/index.html) |
| [mMagnetometerReading](../../hwp.basketball.mobility.device.sensor/-base-sensor/m-magnetometer-reading.md) | `val mMagnetometerReading: `[`FloatArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/index.html) |
| [magnetometerListener](../../hwp.basketball.mobility.device.sensor/-base-sensor/magnetometer-listener.md) | `var magnetometerListener: `[`MagnetometerDataChangedCallback`](../../hwp.basketball.mobility.device.sensor/-base-sensor/-magnetometer-data-changed-callback/index.md)`?` |
| [motionListener](../../hwp.basketball.mobility.device.sensor/-base-sensor/motion-listener.md) | `var motionListener: `[`MovingStateChangedCallback`](../../hwp.basketball.mobility.device.sensor/-base-sensor/-moving-state-changed-callback/index.md)`?`<br>Trigger this listener when your sensor detects change in movement |
| [stateListener](../../hwp.basketball.mobility.device.sensor/-base-sensor/state-listener.md) | `var stateListener: `[`SensorStateChangedCallback`](../../hwp.basketball.mobility.device.sensor/-base-sensor/-sensor-state-changed-callback/index.md)`?`<br>Trigger this listener when your sensor gets (dis)connected |

### Functions

| [connectTo](connect-to.md) | `fun connectTo(deviceID: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Connect to BLE node if it is BLE device |
| [disconnect](disconnect.md) | `fun disconnect(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Unregister listeners to prevent wasting resources, and disconnect if needed (BLE). |
| [getFile](get-file.md) | `fun getFile(clazz: `[`Class`](https://developer.android.com/reference/java/lang/Class.html)`<*>, filename: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`File`](https://developer.android.com/reference/java/io/File.html) |
| [getName](get-name.md) | `fun getName(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Return name of BLE node(address). |
| [subscribeForUpdates](subscribe-for-updates.md) | `fun subscribeForUpdates(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Implement this method and register callbacks specific for each sensor. |

### Inherited Functions

| [addStateListener](../../hwp.basketball.mobility.device.sensor/-base-sensor/add-state-listener.md) | `fun addStateListener(listener: `[`SensorStateChangedCallback`](../../hwp.basketball.mobility.device.sensor/-base-sensor/-sensor-state-changed-callback/index.md)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

