[app](../../index.md) / [hwp.basketball.mobility.drillpreparation.step](../index.md) / [BaseStepFragment](.)

# BaseStepFragment

`abstract class BaseStepFragment : `[`Fragment`](https://developer.android.com/reference/android/support/v4/app/Fragment.html)`, Step`

Created by dusan_cvetkovic on 4/10/17.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `BaseStepFragment()`<br>Created by dusan_cvetkovic on 4/10/17. |

### Functions

| Name | Summary |
|---|---|
| [onAttach](on-attach.md) | `open fun onAttach(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreate](on-create.md) | `open fun onCreate(savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onError](on-error.md) | `open fun onError(error: VerificationError): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onSelected](on-selected.md) | `open fun onSelected(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onStepVisible](on-step-visible.md) | `abstract fun onStepVisible(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setupHideAddButtonBehaviour](setup-hide-add-button-behaviour.md) | `fun setupHideAddButtonBehaviour(btnAdd: `[`FloatingActionButton`](https://developer.android.com/reference/android/support/design/widget/FloatingActionButton.html)`, recyclerView: `[`RecyclerView`](https://developer.android.com/reference/android/support/v7/widget/RecyclerView.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [stepTitle](step-title.md) | `abstract fun stepTitle(): `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [toast](../../hwp.basketball.mobility.util/android.support.v4.app.-fragment/toast.md) | `fun `[`Fragment`](https://developer.android.com/reference/android/support/v4/app/Fragment.html)`.toast(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Used for displaying toasts from within fragment objects. |

### Inheritors

| Name | Summary |
|---|---|
| [ConnectPlayersFragment](../../hwp.basketball.mobility.drillpreparation.step.connectplayers/-connect-players-fragment/index.md) | `class ConnectPlayersFragment : BaseStepFragment, `[`View`](../../hwp.basketball.mobility.drillpreparation.step.connectplayers/-connect-players-contract/-view/index.md)<br>Created by dusan_cvetkovic on 3/23/17. |
| [DrillsFragment](../../hwp.basketball.mobility.drillpreparation.step.selectdrill/-drills-fragment/index.md) | `class DrillsFragment : BaseStepFragment, `[`View`](../../hwp.basketball.mobility.drillpreparation.step.selectdrill/-drills-contract/-view/index.md)<br>Created by dusan_cvetkovic on 3/23/17. |
| [PlayersFragment](../../hwp.basketball.mobility.drillpreparation.step.selectplayers/-players-fragment/index.md) | `class PlayersFragment : BaseStepFragment, `[`View`](../../hwp.basketball.mobility.drillpreparation.step.selectplayers/-players-contract/-view/index.md)<br>Created by dusan_cvetkovic on 3/23/17. |
| [ReviewFragment](../../hwp.basketball.mobility.drillpreparation.step.review/-review-fragment/index.md) | `class ReviewFragment : BaseStepFragment`<br>Created by dusan_cvetkovic on 4/10/17. |
