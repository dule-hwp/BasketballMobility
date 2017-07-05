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
| [attach](attach.md) | `fun attach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [deletePlayer](delete-player.md) | `fun deletePlayer(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [detach](detach.md) | `fun detach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onAddPlayerButtonClicked](on-add-player-button-clicked.md) | `fun onAddPlayerButtonClicked(first: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, last: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, position: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, height: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onEditPlayerButtonClicked](on-edit-player-button-clicked.md) | `fun onEditPlayerButtonClicked(first: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, last: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, position: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`, height: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [playerChecked](player-checked.md) | `fun playerChecked(player: `[`PlayerViewModel`](../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [playerUnChecked](player-un-checked.md) | `fun playerUnChecked(player: `[`PlayerViewModel`](../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [selectedCount](selected-count.md) | `fun selectedCount(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [setPlayerAdapterView](set-player-adapter-view.md) | `fun setPlayerAdapterView(playersAdapter: `[`AdapterView`](../-players-contract/-adapter-view/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [showEditPlayerDialog](show-edit-player-dialog.md) | `fun showEditPlayerDialog(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
