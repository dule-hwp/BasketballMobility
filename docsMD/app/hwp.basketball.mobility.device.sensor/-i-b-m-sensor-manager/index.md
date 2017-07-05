[app](../../index.md) / [hwp.basketball.mobility.device.sensor](../index.md) / [IBMSensorManager](.)

# IBMSensorManager

`interface IBMSensorManager`

Created by dusan_cvetkovic on 5/21/17.

### Types

| [Callback](-callback/index.md) | `interface Callback` |

### Functions

| [connectTo](connect-to.md) | `abstract fun connectTo(nodeTag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [observeAccSensorChanged](observe-acc-sensor-changed.md) | `abstract fun observeAccSensorChanged(): Observable<`[`AccData`](../-b-m-sensor-manager/-acc-data/index.md)`>` |
| [observeAngleChanged](observe-angle-changed.md) | `abstract fun observeAngleChanged(): Observable<`[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`>` |
| [observeMotionIntensityChanged](observe-motion-intensity-changed.md) | `abstract fun observeMotionIntensityChanged(): Observable<`[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`>` |
| [observeStepsChanged](observe-steps-changed.md) | `abstract fun observeStepsChanged(): Observable<`[`StepData`](../-base-sensor/-step-data/index.md)`>` |
| [saveTestData](save-test-data.md) | `abstract fun saveTestData(suffix: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?` |
| [startSensorUpdates](start-sensor-updates.md) | `abstract fun startSensorUpdates(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [stopSensorUpdates](stop-sensor-updates.md) | `abstract fun stopSensorUpdates(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| [BMSensorManager](../-b-m-sensor-manager/index.md) | `class BMSensorManager : IBMSensorManager, `[`SensorStateChangedCallback`](../-base-sensor/-sensor-state-changed-callback/index.md)<br>Created by dusan_cvetkovic on 4/7/17. |

