[app](../../index.md) / [hwp.basketball.mobility.device.sensor](../index.md) / [BMSensorManager](.)

# BMSensorManager

`class BMSensorManager : `[`IBMSensorManager`](../-i-b-m-sensor-manager/index.md)`, `[`SensorStateChangedCallback`](../-base-sensor/-sensor-state-changed-callback/index.md)

Created by dusan_cvetkovic on 4/7/17.

### Types

| Name | Summary |
|---|---|
| [AccData](-acc-data/index.md) | `data class AccData` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BMSensorManager(sensor: `[`BaseSensor`](../-base-sensor/index.md)`, callback: `[`Callback`](../-i-b-m-sensor-manager/-callback/index.md)`?)`<br>Created by dusan_cvetkovic on 4/7/17. |

### Properties

| Name | Summary |
|---|---|
| [callback](callback.md) | `val callback: `[`Callback`](../-i-b-m-sensor-manager/-callback/index.md)`?` |
| [sensor](sensor.md) | `val sensor: `[`BaseSensor`](../-base-sensor/index.md) |

### Functions

| Name | Summary |
|---|---|
| [connectTo](connect-to.md) | `fun connectTo(nodeTag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [observeAccSensorChanged](observe-acc-sensor-changed.md) | `fun observeAccSensorChanged(): Observable<`[`AccData`](-acc-data/index.md)`>` |
| [observeAngleChanged](observe-angle-changed.md) | `fun observeAngleChanged(): Observable<`[`Float`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-float/index.html)`>` |
| [observeIsMoving](observe-is-moving.md) | `fun observeIsMoving(): Observable<`[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`>` |
| [onStateConnected](on-state-connected.md) | `fun onStateConnected(name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onStateDisconnected](on-state-disconnected.md) | `fun onStateDisconnected(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [startSensorUpdates](start-sensor-updates.md) | `fun startSensorUpdates(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [stopSensorUpdates](stop-sensor-updates.md) | `fun stopSensorUpdates(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [toString](to-string.md) | `fun toString(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
