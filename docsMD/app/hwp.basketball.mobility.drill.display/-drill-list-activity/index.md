[app](../../index.md) / [hwp.basketball.mobility.drill.display](../index.md) / [DrillListActivity](.)

# DrillListActivity

`class DrillListActivity : `[`AppCompatActivity`](https://developer.android.com/reference/android/support/v7/app/AppCompatActivity.html)`, `[`View`](../-drill-list-activity-contract/-view/index.md)

An activity representing a list of Drills. This activity
has different presentations for handset and tablet-size devices. On
handsets, the activity presents a list of items, which when touched,
lead to a [DrillDetailActivity](../-drill-detail-activity/index.md) representing
item details. On tablets, the activity presents the list of items and
item details side-by-side using two vertical panes.

### Types

| [SimpleItemRecyclerViewAdapter](-simple-item-recycler-view-adapter/index.md) | `inner class SimpleItemRecyclerViewAdapter : `[`Adapter`](https://developer.android.com/reference/android/support/v7/widget/RecyclerView/Adapter.html)`<`[`ViewHolder`](-simple-item-recycler-view-adapter/-view-holder/index.md)`>` |

### Constructors

| [&lt;init&gt;](-init-.md) | `DrillListActivity()`<br>An activity representing a list of Drills. This activity has different presentations for handset and tablet-size devices. On handsets, the activity presents a list of items, which when touched, lead to a [DrillDetailActivity](../-drill-detail-activity/index.md) representing item details. On tablets, the activity presents the list of items and item details side-by-side using two vertical panes. |

### Functions

| [hideProgressDialog](hide-progress-dialog.md) | `fun hideProgressDialog(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreate](on-create.md) | `fun onCreate(savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onDrillsFetched](on-drills-fetched.md) | `fun onDrillsFetched(drills: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`DrillViewModel`](../../hwp.basketball.mobility.entitiy.drills/-drill-view-model/index.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [showErrorMessage](show-error-message.md) | `fun showErrorMessage(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [showProgressDialog](show-progress-dialog.md) | `fun showProgressDialog(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Companion Object Functions

| [getStartIntent](get-start-intent.md) | `fun getStartIntent(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`Intent`](https://developer.android.com/reference/android/content/Intent.html) |

### Extension Functions

| [bindView](../../hwp.basketball.mobility.util/android.support.v7.app.-app-compat-activity/bind-view.md) | `fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`AppCompatActivity`](https://developer.android.com/reference/android/support/v7/app/AppCompatActivity.html)`.bindView(viewId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Binder`](../../hwp.basketball.mobility.util/-binder/index.md)`<T>` |
| [toast](../../hwp.basketball.mobility.util/android.support.v7.app.-app-compat-activity/toast.md) | `fun `[`AppCompatActivity`](https://developer.android.com/reference/android/support/v7/app/AppCompatActivity.html)`.toast(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Created by dusan_cvetkovic on 6/26/17. |

