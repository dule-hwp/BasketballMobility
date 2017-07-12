[app](../../../index.md) / [hwp.basketball.mobility.drillpreparation.step.connectplayers](../../index.md) / [ConnectPlayersContract](../index.md) / [View](.)

# View

`interface View`

### Functions

| Name | Summary |
|---|---|
| [displayError](display-error.md) | `abstract fun displayError(errorMessage: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>When some error has happened this method is triggered. View should display the error message. |
| [showSensorTypeChooser](show-sensor-type-chooser.md) | `abstract fun showSensorTypeChooser(firstName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Show dialog for chosing sensor type player with 'firstName' is using. |
| [startSensorTileScanActivity](start-sensor-tile-scan-activity.md) | `abstract fun startSensorTileScanActivity(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Show SensorTile scan for BLE devices |
| [startWicedActivityScan](start-wiced-activity-scan.md) | `abstract fun startWicedActivityScan(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Show Wiced sense scan for BLE devices |

### Inheritors

| Name | Summary |
|---|---|
| [ConnectPlayersFragment](../../-connect-players-fragment/index.md) | `class ConnectPlayersFragment : `[`BaseStepFragment`](../../../hwp.basketball.mobility.drillpreparation.step/-base-step-fragment/index.md)`, View`<br>Player connect step. View being shown in preparation drill process when coach connects all the selected players. |
