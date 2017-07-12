[app](../../index.md) / [hwp.basketball.mobility.drillpreparation.step.connectplayers](../index.md) / [ConnectPlayersFragment](.)

# ConnectPlayersFragment

`class ConnectPlayersFragment : `[`BaseStepFragment`](../../hwp.basketball.mobility.drillpreparation.step/-base-step-fragment/index.md)`, `[`View`](../-connect-players-contract/-view/index.md)

Player connect step.
View being shown in preparation drill process when coach connects all the selected players.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `ConnectPlayersFragment()`<br>Player connect step. View being shown in preparation drill process when coach connects all the selected players. |

### Properties

| Name | Summary |
|---|---|
| [connectPlayersPresenter](connect-players-presenter.md) | `lateinit var connectPlayersPresenter: `[`Presenter`](../-connect-players-contract/-presenter/index.md) |
| [playersAdapter](players-adapter.md) | `lateinit var playersAdapter: `[`ConnectPlayersAdapter`](../-connect-players-adapter/index.md) |

### Functions

| Name | Summary |
|---|---|
| [displayError](display-error.md) | `fun displayError(errorMessage: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>When some error has happened this method is triggered. View should display the error message. |
| [onActivityResult](on-activity-result.md) | `fun onActivityResult(requestCode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, resultCode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, data: `[`Intent`](https://developer.android.com/reference/android/content/Intent.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreate](on-create.md) | `fun onCreate(savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateView](on-create-view.md) | `fun onCreateView(inflater: `[`LayoutInflater`](https://developer.android.com/reference/android/view/LayoutInflater.html)`?, container: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`?, savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`View`](https://developer.android.com/reference/android/view/View.html)`?` |
| [onDestroy](on-destroy.md) | `fun onDestroy(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onStepVisible](on-step-visible.md) | `fun onStepVisible(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onViewCreated](on-view-created.md) | `fun onViewCreated(view: `[`View`](https://developer.android.com/reference/android/view/View.html)`?, savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setupRecyclerView](setup-recycler-view.md) | `fun setupRecyclerView(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [showSensorTypeChooser](show-sensor-type-chooser.md) | `fun showSensorTypeChooser(firstName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Show dialog for chosing sensor type player with 'firstName' is using. |
| [startSensorTileScanActivity](start-sensor-tile-scan-activity.md) | `fun startSensorTileScanActivity(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Show SensorTile scan for BLE devices |
| [startWicedActivityScan](start-wiced-activity-scan.md) | `fun startWicedActivityScan(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Show Wiced sense scan for BLE devices |
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
| [newInstance](new-instance.md) | `fun newInstance(): ConnectPlayersFragment` |

### Extension Functions

| Name | Summary |
|---|---|
| [toast](../../hwp.basketball.mobility.util/android.support.v4.app.-fragment/toast.md) | `fun `[`Fragment`](https://developer.android.com/reference/android/support/v4/app/Fragment.html)`.toast(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Used for displaying toasts from within fragment objects. |
