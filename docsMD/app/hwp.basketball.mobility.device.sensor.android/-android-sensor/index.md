[app](../../index.md) / [hwp.basketball.mobility.device.sensor.android](../index.md) / [AndroidSensor](.)

# AndroidSensor

`class AndroidSensor : `[`BaseSensor`](../../hwp.basketball.mobility.device.sensor/-base-sensor/index.md)`, `[`SensorEventListener`](https://developer.android.com/reference/android/hardware/SensorEventListener.html)

Created by dusan_cvetkovic on 3/4/17.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `AndroidSensor(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`)`<br>Created by dusan_cvetkovic on 3/4/17. |

### Properties

| Name | Summary |
|---|---|
| [I](-i.md) | `var I: `[`FloatArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/index.html) |
| [R](-r.md) | `var R: `[`FloatArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/index.html) |
| [isConnectable](is-connectable.md) | `val isConnectable: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Ble devices return true, others false |
| [orientation](orientation.md) | `var orientation: `[`FloatArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/index.html) |

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
| [onAccuracyChanged](on-accuracy-changed.md) | `fun onAccuracyChanged(sensor: `[`Sensor`](https://developer.android.com/reference/android/hardware/Sensor.html)`?, accuracy: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onSensorChanged](on-sensor-changed.md) | `fun onSensorChanged(event: `[`SensorEvent`](https://developer.android.com/reference/android/hardware/SensorEvent.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [subscribeForUpdates](subscribe-for-updates.md) | `fun subscribeForUpdates(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Implement this method and register callbacks specific for each sensor. |
| [subscribeToAccChange](subscribe-to-acc-change.md) | `fun subscribeToAccChange(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [subscribeToGyroChange](subscribe-to-gyro-change.md) | `fun subscribeToGyroChange(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [subscribeToMagnetometerChange](subscribe-to-magnetometer-change.md) | `fun subscribeToMagnetometerChange(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [updateAngle](update-angle.md) | `fun updateAngle(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [addStateListener](../../hwp.basketball.mobility.device.sensor/-base-sensor/add-state-listener.md) | `fun addStateListener(listener: `[`SensorStateChangedCallback`](../../hwp.basketball.mobility.device.sensor/-base-sensor/-sensor-state-changed-callback/index.md)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
