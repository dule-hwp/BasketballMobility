[app](../../index.md) / [hwp.basketball.mobility.device.sensor](../index.md) / [BMSensorManager](.)

# BMSensorManager

`class BMSensorManager : `[`IBMSensorManager`](../-i-b-m-sensor-manager/index.md)`, `[`SensorStateChangedCallback`](../-base-sensor/-sensor-state-changed-callback/index.md)

Created by dusan_cvetkovic on 4/7/17.

### Types

| [AccData](-acc-data/index.md) | `data class AccData` |

### Constructors

| [&lt;init&gt;](-init-.md) | `BMSensorManager(sensor: `[`BaseSensor`](../-base-sensor/index.md)`, callback: `[`Callback`](../-i-b-m-sensor-manager/-callback/index.md)`?)`<br>Created by dusan_cvetkovic on 4/7/17. |

### Properties

| [callback](callback.md) | `val callback: `[`Callback`](../-i-b-m-sensor-manager/-callback/index.md)`?` |
| [sensor](sensor.md) | `val sensor: `[`BaseSensor`](../-base-sensor/index.md) |

### Functions

| [connectTo](connect-to.md) | `fun connectTo(nodeTag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [observeAccSensorChanged](observe-acc-sensor-changed.md) | `fun observeAccSensorChanged(): Observable<`[`AccData`](-acc-data/index.md)`>` |
| [observeAngleChanged](observe-angle-changed.md) | `fun observeAngleChanged(): Observable<`[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`>` |
| [observeGyroSensorChanged](observe-gyro-sensor-changed.md) | `fun observeGyroSensorChanged(): Observable<`[`FloatArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/index.html)`>` |
| [observeMagSensorChanged](observe-mag-sensor-changed.md) | `fun observeMagSensorChanged(): Observable<`[`FloatArray`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float-array/index.html)`>` |
| [observeMotionIntensityChanged](observe-motion-intensity-changed.md) | `fun observeMotionIntensityChanged(): Observable<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>` |
| [observeStepsChanged](observe-steps-changed.md) | `fun observeStepsChanged(): Observable<`[`StepData`](../-base-sensor/-step-data/index.md)`>` |
| [onStateConnected](on-state-connected.md) | `fun onStateConnected(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onStateDisconnected](on-state-disconnected.md) | `fun onStateDisconnected(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [saveTestData](save-test-data.md) | `fun saveTestData(suffix: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [startSensorUpdates](start-sensor-updates.md) | `fun startSensorUpdates(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [stopSensorUpdates](stop-sensor-updates.md) | `fun stopSensorUpdates(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [toString](to-string.md) | `fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

