[app](../../../index.md) / [hwp.basketball.mobility.drillpreparation.step.selectplayers](../../index.md) / [PlayersContract](../index.md) / [View](.)

# View

`interface View`

### Functions

| Name | Summary |
|---|---|
| [displayError](display-error.md) | `abstract fun displayError(errorMessage: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>When some error has happened this method is triggered. View should display the error message. |
| [showAddPlayerDialog](show-add-player-dialog.md) | `abstract fun showAddPlayerDialog(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>This method is triggered when add player button is clicked. View responsibility is to show add dialog. |
| [showEditPlayerDialog](show-edit-player-dialog.md) | `abstract fun showEditPlayerDialog(player: `[`PlayerViewModel`](../../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>This method is triggered when edit player was clicked. View responsibility is to show edit dialog. |

### Inheritors

| Name | Summary |
|---|---|
| [PlayersFragment](../../-players-fragment/index.md) | `class PlayersFragment : `[`BaseStepFragment`](../../../hwp.basketball.mobility.drillpreparation.step/-base-step-fragment/index.md)`, View`<br>Player select step. View being shown in preparation drill process when coach selects player. |
