[app](../../../index.md) / [hwp.basketball.mobility.drill.display](../../index.md) / [DrillListActivityContract](../index.md) / [View](.)

# View

`interface View`

### Functions

| Name | Summary |
|---|---|
| [hideProgressDialog](hide-progress-dialog.md) | `abstract fun hideProgressDialog(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onDrillsFetched](on-drills-fetched.md) | `abstract fun onDrillsFetched(drills: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`DrillViewModel`](../../../hwp.basketball.mobility.entitiy.drills/-drill-view-model/index.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [showDrillDetailedView](show-drill-detailed-view.md) | `abstract fun showDrillDetailedView(drillOutcome: `[`DrillOutcome`](../../../hwp.basketball.mobility.entitiy.drills.outcomes/-drill-outcome/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [showErrorMessage](show-error-message.md) | `abstract fun showErrorMessage(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [showProgressDialog](show-progress-dialog.md) | `abstract fun showProgressDialog(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [DrillListActivity](../../-drill-list-activity/index.md) | `class DrillListActivity : `[`AppCompatActivity`](https://developer.android.com/reference/android/support/v7/app/AppCompatActivity.html)`, View`<br>An activity representing a list of Drills. This activity has different presentations for handset and tablet-size devices. On handsets, the activity presents a list of items, which when touched, lead to a [DrillDetailActivity](../../-drill-detail-activity/index.md) representing item details. On tablets, the activity presents the list of items and item details side-by-side using two vertical panes. |
