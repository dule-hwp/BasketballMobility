[app](../../index.md) / [hwp.basketball.mobility.drillpreparation.step.selectplayers](../index.md) / [PlayersFragment](.)

# PlayersFragment

`class PlayersFragment : `[`BaseStepFragment`](../../hwp.basketball.mobility.drillpreparation.step/-base-step-fragment/index.md)`, `[`View`](../-players-contract/-view/index.md)

Player select step.
View being shown in preparation drill process when coach selects player.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PlayersFragment()`<br>Player select step. View being shown in preparation drill process when coach selects player. |

### Properties

| Name | Summary |
|---|---|
| [playersAdapter](players-adapter.md) | `lateinit var playersAdapter: `[`PlayersAdapter`](../-players-adapter/index.md) |
| [playersDialog](players-dialog.md) | `lateinit var playersDialog: `[`PlayerDialog`](../-player-dialog/index.md) |
| [playersPresenter](players-presenter.md) | `lateinit var playersPresenter: `[`Presenter`](../-players-contract/-presenter/index.md) |

### Functions

| Name | Summary |
|---|---|
| [displayError](display-error.md) | `fun displayError(errorMessage: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>When some error has happened this method is triggered. View should display the error message. |
| [onCreate](on-create.md) | `fun onCreate(savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateView](on-create-view.md) | `fun onCreateView(inflater: `[`LayoutInflater`](https://developer.android.com/reference/android/view/LayoutInflater.html)`?, container: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`?, savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`View`](https://developer.android.com/reference/android/view/View.html)`?` |
| [onDestroy](on-destroy.md) | `fun onDestroy(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onStepVisible](on-step-visible.md) | `fun onStepVisible(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onViewCreated](on-view-created.md) | `fun onViewCreated(view: `[`View`](https://developer.android.com/reference/android/view/View.html)`?, savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setupPlayersRecyclerView](setup-players-recycler-view.md) | `fun setupPlayersRecyclerView(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [showAddPlayerDialog](show-add-player-dialog.md) | `fun showAddPlayerDialog(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>This method is triggered when add player button is clicked. View responsibility is to show add dialog. |
| [showEditPlayerDialog](show-edit-player-dialog.md) | `fun showEditPlayerDialog(player: `[`PlayerViewModel`](../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>This method is triggered when edit player was clicked. View responsibility is to show edit dialog. |
| [stepTitle](step-title.md) | `fun stepTitle(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [verifyStep](verify-step.md) | `fun verifyStep(): VerificationError?` |

### Inherited Functions

| Name | Summary |
|---|---|
| [onAttach](../../hwp.basketball.mobility.drillpreparation.step/-base-step-fragment/on-attach.md) | `open fun onAttach(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onError](../../hwp.basketball.mobility.drillpreparation.step/-base-step-fragment/on-error.md) | `open fun onError(error: VerificationError): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onSelected](../../hwp.basketball.mobility.drillpreparation.step/-base-step-fragment/on-selected.md) | `open fun onSelected(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setupHideAddButtonBehaviour](../../hwp.basketball.mobility.drillpreparation.step/-base-step-fragment/setup-hide-add-button-behaviour.md) | `fun setupHideAddButtonBehaviour(btnAdd: `[`FloatingActionButton`](https://developer.android.com/reference/android/support/design/widget/FloatingActionButton.html)`, recyclerView: `[`RecyclerView`](https://developer.android.com/reference/android/support/v7/widget/RecyclerView.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [newInstance](new-instance.md) | `fun newInstance(): PlayersFragment` |

### Extension Functions

| Name | Summary |
|---|---|
| [toast](../../hwp.basketball.mobility.util/android.support.v4.app.-fragment/toast.md) | `fun `[`Fragment`](https://developer.android.com/reference/android/support/v4/app/Fragment.html)`.toast(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Used for displaying toasts from within fragment objects. |
