[app](../../index.md) / [hwp.basketball.mobility.drillpreparation.step.selectplayers](../index.md) / [PlayerDialog](.)

# PlayerDialog

`class PlayerDialog`

Class in charge of displaying show/edit dialog.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PlayerDialog(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, playersPresenter: `[`Presenter`](../-players-contract/-presenter/index.md)`)`<br>Class in charge of displaying show/edit dialog. |

### Properties

| Name | Summary |
|---|---|
| [context](context.md) | `val context: `[`Context`](https://developer.android.com/reference/android/content/Context.html) |
| [playersPresenter](players-presenter.md) | `val playersPresenter: `[`Presenter`](../-players-contract/-presenter/index.md) |

### Functions

| Name | Summary |
|---|---|
| [createBaseDialogBuilder](create-base-dialog-builder.md) | `fun createBaseDialogBuilder(): `[`Builder`](https://developer.android.com/reference/android/support/v7/app/AlertDialog/Builder.html) |
| [showAddPlayerDialog](show-add-player-dialog.md) | `fun showAddPlayerDialog(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [showEditPlayerDialog](show-edit-player-dialog.md) | `fun showEditPlayerDialog(player: `[`PlayerViewModel`](../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
