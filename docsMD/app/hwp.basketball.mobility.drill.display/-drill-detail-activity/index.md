[app](../../index.md) / [hwp.basketball.mobility.drill.display](../index.md) / [DrillDetailActivity](.)

# DrillDetailActivity

`class DrillDetailActivity : `[`AppCompatActivity`](https://developer.android.com/reference/android/support/v7/app/AppCompatActivity.html)

An activity representing a single Drill detail screen. This
activity is only used on narrow width devices. On tablet-size devices,
item details are presented side-by-side with a list of items
in a [DrillListActivity](../-drill-list-activity/index.md).

### Constructors

| [&lt;init&gt;](-init-.md) | `DrillDetailActivity()`<br>An activity representing a single Drill detail screen. This activity is only used on narrow width devices. On tablet-size devices, item details are presented side-by-side with a list of items in a [DrillListActivity](../-drill-list-activity/index.md). |

### Functions

| [onCreate](on-create.md) | `fun onCreate(savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onOptionsItemSelected](on-options-item-selected.md) | `fun onOptionsItemSelected(item: `[`MenuItem`](https://developer.android.com/reference/android/view/MenuItem.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |

### Companion Object Functions

| [getStartIntent](get-start-intent.md) | `fun getStartIntent(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`Intent`](https://developer.android.com/reference/android/content/Intent.html) |

### Extension Functions

| [bindView](../../hwp.basketball.mobility.util/android.support.v7.app.-app-compat-activity/bind-view.md) | `fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`AppCompatActivity`](https://developer.android.com/reference/android/support/v7/app/AppCompatActivity.html)`.bindView(viewId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Binder`](../../hwp.basketball.mobility.util/-binder/index.md)`<T>` |
| [toast](../../hwp.basketball.mobility.util/android.support.v7.app.-app-compat-activity/toast.md) | `fun `[`AppCompatActivity`](https://developer.android.com/reference/android/support/v7/app/AppCompatActivity.html)`.toast(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Created by dusan_cvetkovic on 6/26/17. |

