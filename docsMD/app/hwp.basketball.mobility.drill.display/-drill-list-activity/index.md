[app](../../index.md) / [hwp.basketball.mobility.drill.display](../index.md) / [DrillListActivity](.)

# DrillListActivity

`class DrillListActivity : `[`AppCompatActivity`](https://developer.android.com/reference/android/support/v7/app/AppCompatActivity.html)`, `[`View`](../-drill-list-activity-contract/-view/index.md)

An activity representing a list of Drills. This activity
has different presentations for handset and tablet-size devices. On
handsets, the activity presents a list of items, which when touched,
lead to a [DrillDetailActivity](../-drill-detail-activity/index.md) representing
item details. On tablets, the activity presents the list of items and
item details side-by-side using two vertical panes.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DrillListActivity()`<br>An activity representing a list of Drills. This activity has different presentations for handset and tablet-size devices. On handsets, the activity presents a list of items, which when touched, lead to a [DrillDetailActivity](../-drill-detail-activity/index.md) representing item details. On tablets, the activity presents the list of items and item details side-by-side using two vertical panes. |

### Functions

| Name | Summary |
|---|---|
| [hideProgressDialog](hide-progress-dialog.md) | `fun hideProgressDialog(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreate](on-create.md) | `fun onCreate(savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onDrillsFetched](on-drills-fetched.md) | `fun onDrillsFetched(drills: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`DrillViewModel`](../../hwp.basketball.mobility.entitiy.drills/-drill-view-model/index.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [showDrillDetailedView](show-drill-detailed-view.md) | `fun showDrillDetailedView(drillOutcome: `[`DrillOutcome`](../../hwp.basketball.mobility.entitiy.drills.outcomes/-drill-outcome/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [showErrorMessage](show-error-message.md) | `fun showErrorMessage(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [showProgressDialog](show-progress-dialog.md) | `fun showProgressDialog(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [getStartIntent](get-start-intent.md) | `fun getStartIntent(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`Intent`](https://developer.android.com/reference/android/content/Intent.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [bindView](../../hwp.basketball.mobility.util/android.support.v7.app.-app-compat-activity/bind-view.md) | `fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`AppCompatActivity`](https://developer.android.com/reference/android/support/v7/app/AppCompatActivity.html)`.bindView(viewId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Binder`](../../hwp.basketball.mobility.util/-binder/index.md)`<T>`<br>Type safe find view by id replacement. It is being called only once and then the value is being read next time. Much more convenient then having to have a field initialized in onCreate, can be used while declaring the property. |
| [toast](../../hwp.basketball.mobility.util/android.support.v7.app.-app-compat-activity/toast.md) | `fun `[`AppCompatActivity`](https://developer.android.com/reference/android/support/v7/app/AppCompatActivity.html)`.toast(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Used for displaying toasts from within activity objects. |
