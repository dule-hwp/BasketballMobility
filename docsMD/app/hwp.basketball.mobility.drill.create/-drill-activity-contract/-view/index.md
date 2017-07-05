[app](../../../index.md) / [hwp.basketball.mobility.drill.create](../../index.md) / [DrillActivityContract](../index.md) / [View](.)

# View

`interface View`

### Functions

| Name | Summary |
|---|---|
| [displayError](display-error.md) | `abstract fun displayError(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [finishActivity](finish-activity.md) | `abstract fun finishActivity(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [hideProgressDialog](hide-progress-dialog.md) | `abstract fun hideProgressDialog(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [promptForDrillNameDialog](prompt-for-drill-name-dialog.md) | `abstract fun promptForDrillNameDialog(draw: `[`Bitmap`](https://developer.android.com/reference/android/graphics/Bitmap.html)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [showProgressDialog](show-progress-dialog.md) | `abstract fun showProgressDialog(message: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [takeADrillScreenshot](take-a-drill-screenshot.md) | `abstract fun takeADrillScreenshot(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [DrillActivity](../../-drill-activity/index.md) | `class DrillActivity : `[`AppCompatActivity`](https://developer.android.com/reference/android/support/v7/app/AppCompatActivity.html)`, View, `[`OnClickListener`](https://developer.android.com/reference/android/content/DialogInterface/OnClickListener.html) |
