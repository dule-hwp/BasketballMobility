[app](../../index.md) / [hwp.basketball.mobility.drillpreparation.step.connectplayers](../index.md) / [ConnectPlayersFragment](.)

# ConnectPlayersFragment

`class ConnectPlayersFragment : `[`BaseStepFragment`](../../hwp.basketball.mobility.drillpreparation.step/-base-step-fragment/index.md)`, `[`View`](../-connect-players-contract/-view/index.md)

Created by dusan_cvetkovic on 3/23/17.

### Constructors

| [&lt;init&gt;](-init-.md) | `ConnectPlayersFragment()`<br>Created by dusan_cvetkovic on 3/23/17. |

### Properties

| [connectPlayersPresenter](connect-players-presenter.md) | `lateinit var connectPlayersPresenter: `[`Presenter`](../-connect-players-contract/-presenter/index.md) |
| [playersAdapter](players-adapter.md) | `lateinit var playersAdapter: `[`ConnectPlayersAdapter`](../-connect-players-adapter/index.md) |

### Functions

| [displayError](display-error.md) | `fun displayError(s: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onActivityResult](on-activity-result.md) | `fun onActivityResult(requestCode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, resultCode: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, data: `[`Intent`](https://developer.android.com/reference/android/content/Intent.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreate](on-create.md) | `fun onCreate(savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateView](on-create-view.md) | `fun onCreateView(inflater: `[`LayoutInflater`](https://developer.android.com/reference/android/view/LayoutInflater.html)`?, container: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`?, savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`View`](https://developer.android.com/reference/android/view/View.html)`?` |
| [onDestroy](on-destroy.md) | `fun onDestroy(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onStepVisible](on-step-visible.md) | `fun onStepVisible(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onViewCreated](on-view-created.md) | `fun onViewCreated(view: `[`View`](https://developer.android.com/reference/android/view/View.html)`?, savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setupRecyclerView](setup-recycler-view.md) | `fun setupRecyclerView(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [showConnectDialog](show-connect-dialog.md) | `fun showConnectDialog(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [showSensorTypeChooser](show-sensor-type-chooser.md) | `fun showSensorTypeChooser(firstName: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [startScanActivity](start-scan-activity.md) | `fun startScanActivity(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [startWicedActivityScan](start-wiced-activity-scan.md) | `fun startWicedActivityScan(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [stepTitle](step-title.md) | `fun stepTitle(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [verifyStep](verify-step.md) | `fun verifyStep(): VerificationError?` |

### Inherited Functions

| [onAttach](../../hwp.basketball.mobility.drillpreparation.step/-base-step-fragment/on-attach.md) | `open fun onAttach(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onError](../../hwp.basketball.mobility.drillpreparation.step/-base-step-fragment/on-error.md) | `open fun onError(error: VerificationError): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onSelected](../../hwp.basketball.mobility.drillpreparation.step/-base-step-fragment/on-selected.md) | `open fun onSelected(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setupHideAddButtonBehaviour](../../hwp.basketball.mobility.drillpreparation.step/-base-step-fragment/setup-hide-add-button-behaviour.md) | `fun setupHideAddButtonBehaviour(btnAdd: `[`FloatingActionButton`](https://developer.android.com/reference/android/support/design/widget/FloatingActionButton.html)`, recyclerView: `[`RecyclerView`](https://developer.android.com/reference/android/support/v7/widget/RecyclerView.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Functions

| [newInstance](new-instance.md) | `fun newInstance(): ConnectPlayersFragment` |

### Extension Functions

| [toast](../../hwp.basketball.mobility.util/android.support.v4.app.-fragment/toast.md) | `fun `[`Fragment`](https://developer.android.com/reference/android/support/v4/app/Fragment.html)`.toast(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

