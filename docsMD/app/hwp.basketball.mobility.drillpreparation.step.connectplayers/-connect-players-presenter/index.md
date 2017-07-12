[app](../../index.md) / [hwp.basketball.mobility.drillpreparation.step.connectplayers](../index.md) / [ConnectPlayersPresenter](.)

# ConnectPlayersPresenter

`class ConnectPlayersPresenter : `[`Presenter`](../-connect-players-contract/-presenter/index.md)`, `[`AdapterViewCallback`](../-connect-players-contract/-adapter-view-callback/index.md)

Created by dusan_cvetkovic on 4/4/17.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ConnectPlayersPresenter(view: `[`View`](../-connect-players-contract/-view/index.md)`)`<br>Created by dusan_cvetkovic on 4/4/17. |

### Properties

| Name | Summary |
|---|---|
| [view](view.md) | `val view: `[`View`](../-connect-players-contract/-view/index.md) |

### Functions

| Name | Summary |
|---|---|
| [attach](attach.md) | `fun attach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>In this callback allocation of resources and initialization should happen. |
| [detach](detach.md) | `fun detach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>In this callback cleanup should happen. |
| [onAndroidSensorSelected](on-android-sensor-selected.md) | `fun onAndroidSensorSelected(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onConnectSwitch](on-connect-switch.md) | `fun onConnectSwitch(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>On switch player connection clicked. |
| [onNothingSelected](on-nothing-selected.md) | `fun onNothingSelected(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onScanSuccessfulReturnTag](on-scan-successful-return-tag.md) | `fun onScanSuccessfulReturnTag(nodeTag: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onSensorTileSelected](on-sensor-tile-selected.md) | `fun onSensorTileSelected(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onSensorTypeSelected](on-sensor-type-selected.md) | `fun onSensorTypeSelected(sensorType: `[`Type`](../../hwp.basketball.mobility.device.sensor/-sensor-factory/-type/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [refreshData](refresh-data.md) | `fun refreshData(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setConnectPlayersAdapterView](set-connect-players-adapter-view.md) | `fun setConnectPlayersAdapterView(view: `[`AdapterView`](../-connect-players-contract/-adapter-view/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [verifyStep](verify-step.md) | `fun verifyStep(): VerificationError?` |
