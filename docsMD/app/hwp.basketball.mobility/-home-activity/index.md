[app](../../index.md) / [hwp.basketball.mobility](../index.md) / [HomeActivity](.)

# HomeActivity

`class HomeActivity : `[`AppCompatActivity`](https://developer.android.com/reference/android/support/v7/app/AppCompatActivity.html)

Created by dusan_cvetkovic on 3/27/17.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `HomeActivity()`<br>Created by dusan_cvetkovic on 3/27/17. |

### Functions

| Name | Summary |
|---|---|
| [onCreate](on-create.md) | `fun onCreate(savedInstanceState: `[`Bundle`](https://developer.android.com/reference/android/os/Bundle.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Initialize and attach listeners to views. |
| [onCreateOptionsMenu](on-create-options-menu.md) | `fun onCreateOptionsMenu(menu: `[`Menu`](https://developer.android.com/reference/android/view/Menu.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Populating the options menu with logout button. |
| [onOptionsItemSelected](on-options-item-selected.md) | `fun onOptionsItemSelected(item: `[`MenuItem`](https://developer.android.com/reference/android/view/MenuItem.html)`): `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)<br>Handling logout functionality. |
| [onPastDrillsClick](on-past-drills-click.md) | `fun onPastDrillsClick(view: `[`View`](https://developer.android.com/reference/android/view/View.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Starts the activity where you can see all the past performed drills with results and images. This method is linked via .xml code. |
| [startScanForSTActivity](start-scan-for-s-t-activity.md) | `fun startScanForSTActivity(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Starting the BLE scan for SensorTile activity. The reason why we put this here and not in SensorTileSensor implementation is because we want to be able to check activity result and see what user selected. |

### Companion Object Functions

| Name | Summary |
|---|---|
| [getStartIntent](get-start-intent.md) | `fun getStartIntent(context: `[`Context`](https://developer.android.com/reference/android/content/Context.html)`): `[`Intent`](https://developer.android.com/reference/android/content/Intent.html)<br>Static method for creating start activity intent. |

### Extension Functions

| Name | Summary |
|---|---|
| [bindView](../../hwp.basketball.mobility.util/android.support.v7.app.-app-compat-activity/bind-view.md) | `fun <T : `[`Any`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)`> `[`AppCompatActivity`](https://developer.android.com/reference/android/support/v7/app/AppCompatActivity.html)`.bindView(viewId: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Binder`](../../hwp.basketball.mobility.util/-binder/index.md)`<T>`<br>Type safe find view by id replacement. It is being called only once and then the value is being read next time. Much more convenient then having to have a field initialized in onCreate, can be used while declaring the property. |
| [toast](../../hwp.basketball.mobility.util/android.support.v7.app.-app-compat-activity/toast.md) | `fun `[`AppCompatActivity`](https://developer.android.com/reference/android/support/v7/app/AppCompatActivity.html)`.toast(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Used for displaying toasts from within activity objects. |
