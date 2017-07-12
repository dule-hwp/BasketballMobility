[app](../../../index.md) / [hwp.basketball.mobility.drillpreparation.step.selectplayers](../../index.md) / [PlayersContract](../index.md) / [Presenter](.)

# Presenter

`interface Presenter : `[`BasePresenter`](../../../hwp.basketball.mobility/-base-presenter/index.md)

### Functions

| Name | Summary |
|---|---|
| [deletePlayer](delete-player.md) | `abstract fun deletePlayer(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Player delete button clicked. |
| [onAddPlayerButtonClicked](on-add-player-button-clicked.md) | `abstract fun onAddPlayerButtonClicked(first: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, last: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, position: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, height: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Data needed for player creation. |
| [onEditPlayerButtonClicked](on-edit-player-button-clicked.md) | `abstract fun onEditPlayerButtonClicked(playerFullName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, first: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, last: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, position: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, height: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Data needed for player update. |
| [onEditPlayerClicked](on-edit-player-clicked.md) | `abstract fun onEditPlayerClicked(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Player edit button clicked. |
| [playerChecked](player-checked.md) | `abstract fun playerChecked(player: `[`PlayerViewModel`](../../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Player checkbox checked |
| [playerUnChecked](player-un-checked.md) | `abstract fun playerUnChecked(player: `[`PlayerViewModel`](../../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Player checkbox unchecked |
| [selectedCount](selected-count.md) | `abstract fun selectedCount(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Get number of players selected to perform the drill |
| [setPlayerAdapterView](set-player-adapter-view.md) | `abstract fun setPlayerAdapterView(playersAdapter: `[`AdapterView`](../-adapter-view/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Passing adapterView reference to presenter so that presenter can handle logic for it |

### Inherited Functions

| Name | Summary |
|---|---|
| [attach](../../../hwp.basketball.mobility/-base-presenter/attach.md) | `abstract fun attach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>In this callback allocation of resources and initialization should happen. |
| [detach](../../../hwp.basketball.mobility/-base-presenter/detach.md) | `abstract fun detach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>In this callback cleanup should happen. |

### Inheritors

| Name | Summary |
|---|---|
| [PlayersPresenter](../../-players-presenter/index.md) | `class PlayersPresenter : Presenter`<br>Created by dusan_cvetkovic on 3/28/17. |
