[app](../../index.md) / [hwp.basketball.mobility.drill.display](../index.md) / [DrillDetailActivity](.)

# DrillDetailActivity

`class DrillDetailActivity : `[`AppCompatActivity`](https://developer.android.com/reference/android/support/v7/app/AppCompatActivity.html)

An activity representing a single Drill detail screen. This
activity is only used on narrow width devices. On tablet-size devices,
item details are presented side-by-side with a list of items
in a [DrillListActivity](../-drill-list-activity/index.md).

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DrillDetailActivity()`<br>An activity representing a single Drill detail screen. This activity is only used on narrow width devices. On tablet-size devices, item details are presented side-by-side with a list of items in a [DrillListActivity](../-drill-list-activity/index.md). |

### Functions

| Name | Summary |
|---|---|
| [onCreate](on-create.md) | `fun onCreate(savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onOptionsItemSelected](on-options-item-selected.md) | `fun onOptionsItemSelected(item: `[`MenuItem`](https://developer.android.com/reference/android/view/MenuItem.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [onResume](on-resume.md) | `fun onResume(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Properties

| Name | Summary |
|---|---|
| [DRILL_EXTRA](-d-r-i-l-l_-e-x-t-r-a.md) | `val DRILL_EXTRA: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

### Companion Object Functions

| Name | Summary |
|---|---|
| [getStartIntent](get-start-intent.md) | `fun getStartIntent(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`, drillOutcome: `[`DrillOutcome`](../../hwp.basketball.mobility.entitiy.drills.outcomes/-drill-outcome/index.md)`): `[`Intent`](https://developer.android.com/reference/android/content/Intent.html) |

### Extension Functions

| Name | Summary |
|---|---|
| [bindView](../../hwp.basketball.mobility.util/android.support.v7.app.-app-compat-activity/bind-view.md) | `fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`AppCompatActivity`](https://developer.android.com/reference/android/support/v7/app/AppCompatActivity.html)`.bindView(viewId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Binder`](../../hwp.basketball.mobility.util/-binder/index.md)`<T>`<br>Type safe find view by id replacement. It is being called only once and then the value is being read next time. Much more convenient then having to have a field initialized in onCreate, can be used while declaring the property. |
| [toast](../../hwp.basketball.mobility.util/android.support.v7.app.-app-compat-activity/toast.md) | `fun `[`AppCompatActivity`](https://developer.android.com/reference/android/support/v7/app/AppCompatActivity.html)`.toast(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Used for displaying toasts from within activity objects. |
