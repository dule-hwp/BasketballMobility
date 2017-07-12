[app](../../index.md) / [hwp.basketball.mobility.drillpreparation.step.selectplayers](../index.md) / [PlayersPresenter](.)

# PlayersPresenter

`class PlayersPresenter : `[`Presenter`](../-players-contract/-presenter/index.md)

Created by dusan_cvetkovic on 3/28/17.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PlayersPresenter(view: `[`View`](../-players-contract/-view/index.md)`)`<br>Created by dusan_cvetkovic on 3/28/17. |

### Properties

| Name | Summary |
|---|---|
| [playersAdapterView](players-adapter-view.md) | `var playersAdapterView: `[`AdapterView`](../-players-contract/-adapter-view/index.md)`?` |
| [view](view.md) | `val view: `[`View`](../-players-contract/-view/index.md) |

### Functions

| Name | Summary |
|---|---|
| [attach](attach.md) | `fun attach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>In this callback allocation of resources and initialization should happen. |
| [deletePlayer](delete-player.md) | `fun deletePlayer(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Player delete button clicked. |
| [detach](detach.md) | `fun detach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>In this callback cleanup should happen. |
| [onAddPlayerButtonClicked](on-add-player-button-clicked.md) | `fun onAddPlayerButtonClicked(first: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, last: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, position: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, height: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Data needed for player creation. |
| [onEditPlayerButtonClicked](on-edit-player-button-clicked.md) | `fun onEditPlayerButtonClicked(playerFullName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, first: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, last: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, position: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, height: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Data needed for player update. |
| [onEditPlayerClicked](on-edit-player-clicked.md) | `fun onEditPlayerClicked(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Player edit button clicked. |
| [playerChecked](player-checked.md) | `fun playerChecked(player: `[`PlayerViewModel`](../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Player checkbox checked |
| [playerUnChecked](player-un-checked.md) | `fun playerUnChecked(player: `[`PlayerViewModel`](../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Player checkbox unchecked |
| [selectedCount](selected-count.md) | `fun selectedCount(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Get number of players selected to perform the drill |
| [setPlayerAdapterView](set-player-adapter-view.md) | `fun setPlayerAdapterView(playersAdapter: `[`AdapterView`](../-players-contract/-adapter-view/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Passing adapterView reference to presenter so that presenter can handle logic for it |
