[app](../../index.md) / [hwp.basketball.mobility.device.sensor.sensortile](../index.md) / [SensorTileSensor](.)

# SensorTileSensor

`open class SensorTileSensor : `[`BaseSensor`](../../hwp.basketball.mobility.device.sensor/-base-sensor/index.md)`, FeatureListener, NodeStateListener`

Created by dusan_cvetkovic on 3/4/17.

### Types

| Name | Summary |
|---|---|
| [StepData](-step-data/index.md) | `data class StepData`<br>Type Used to save step data. |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `SensorTileSensor(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`)`<br>Created by dusan_cvetkovic on 3/4/17. |

### Properties

| Name | Summary |
|---|---|
| [context](context.md) | `val context: `[`Context`](https://developer.android.com/reference/android/content/Context.html) |
| [isConnectable](is-connectable.md) | `open val isConnectable: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Ble devices return true, others false |

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
| [connectTo](connect-to.md) | `open fun connectTo(deviceID: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Connect to BLE node if it is BLE device |
| [disconnect](disconnect.md) | `open fun disconnect(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Unregister listeners to prevent wasting resources, and disconnect if needed (BLE). |
| [getName](get-name.md) | `open fun getName(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>Return name of BLE node(address). |
| [onStateChange](on-state-change.md) | `open fun onStateChange(node: Node?, newState: State?, prevState: State?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onUpdate](on-update.md) | `open fun onUpdate(f: Feature, sample: Sample): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [subscribeForUpdates](subscribe-for-updates.md) | `open fun subscribeForUpdates(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Implement this method and register callbacks specific for each sensor. |
| [subscribeToAccChange](subscribe-to-acc-change.md) | `fun subscribeToAccChange(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [subscribeToAngleChangeChange](subscribe-to-angle-change-change.md) | `fun subscribeToAngleChangeChange(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [subscribeToGyroChange](subscribe-to-gyro-change.md) | `fun subscribeToGyroChange(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [subscribeToMagnetometerChange](subscribe-to-magnetometer-change.md) | `fun subscribeToMagnetometerChange(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [subscribeToMotionChange](subscribe-to-motion-change.md) | `fun subscribeToMotionChange(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [subscribeToSpeedChange](subscribe-to-speed-change.md) | `fun subscribeToSpeedChange(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inherited Functions

| Name | Summary |
|---|---|
| [addStateListener](../../hwp.basketball.mobility.device.sensor/-base-sensor/add-state-listener.md) | `fun addStateListener(listener: `[`SensorStateChangedCallback`](../../hwp.basketball.mobility.device.sensor/-base-sensor/-sensor-state-changed-callback/index.md)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
