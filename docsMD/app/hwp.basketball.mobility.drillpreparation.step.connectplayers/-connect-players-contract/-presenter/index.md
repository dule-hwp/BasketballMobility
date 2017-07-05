[app](../../../index.md) / [hwp.basketball.mobility.drillpreparation.step.connectplayers](../../index.md) / [ConnectPlayersContract](../index.md) / [Presenter](.)

# Presenter

`interface Presenter : `[`BasePresenter`](../../../hwp.basketball.mobility/-base-presenter/index.md)`, `[`SensorChooserCallback`](../../../hwp.basketball.mobility.sensortilescan/-sensors-dialog/-sensor-chooser-callback/index.md)

### Functions

| Name | Summary |
|---|---|
| [onScanSuccessfulReturnTag](on-scan-successful-return-tag.md) | `abstract fun onScanSuccessfulReturnTag(nodeTag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [refreshData](refresh-data.md) | `abstract fun refreshData(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setConnectPlayersAdapterView](set-connect-players-adapter-view.md) | `abstract fun setConnectPlayersAdapterView(view: `[`AdapterView`](../-adapter-view/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [verifyStep](verify-step.md) | `abstract fun verifyStep(): VerificationError?` |

### Inherited Functions

| Name | Summary |
|---|---|
| [attach](../../../hwp.basketball.mobility/-base-presenter/attach.md) | `abstract fun attach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [detach](../../../hwp.basketball.mobility/-base-presenter/detach.md) | `abstract fun detach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onNothingSelected](../../../hwp.basketball.mobility.sensortilescan/-sensors-dialog/-sensor-chooser-callback/on-nothing-selected.md) | `abstract fun onNothingSelected(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onSensorTypeSelected](../../../hwp.basketball.mobility.sensortilescan/-sensors-dialog/-sensor-chooser-callback/on-sensor-type-selected.md) | `abstract fun onSensorTypeSelected(sensorType: `[`Type`](../../../hwp.basketball.mobility.device.sensor/-base-sensor/-type/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [ConnectPlayersPresenter](../../-connect-players-presenter/index.md) | `class ConnectPlayersPresenter : Presenter, `[`AdapterViewCallback`](../-adapter-view-callback/index.md)<br>Created by dusan_cvetkovic on 4/4/17. |
