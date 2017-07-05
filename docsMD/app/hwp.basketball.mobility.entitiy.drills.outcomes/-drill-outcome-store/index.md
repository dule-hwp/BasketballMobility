[app](../../index.md) / [hwp.basketball.mobility.entitiy.drills.outcomes](../index.md) / [DrillOutcomeStore](.)

# DrillOutcomeStore

`interface DrillOutcomeStore`

Created by dusan_cvetkovic on 3/28/17.

### Functions

| Name | Summary |
|---|---|
| [addDrillOutcomeToDatabase](add-drill-outcome-to-database.md) | `abstract fun addDrillOutcomeToDatabase(drillOutcome: `[`DrillOutcome`](../-drill-outcome/index.md)`, drillBitmap: `[`Bitmap`](https://developer.android.com/reference/android/graphics/Bitmap.html)`, drillBitmapArea: `[`Bitmap`](https://developer.android.com/reference/android/graphics/Bitmap.html)`): Completable` |
| [delete](delete.md) | `abstract fun delete(drillOutcome: `[`DrillOutcome`](../-drill-outcome/index.md)`): Completable` |
| [findAll](find-all.md) | `abstract fun findAll(): Maybe<`[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`DrillOutcome`](../-drill-outcome/index.md)`>>` |
| [findAllDrillOutcomes](find-all-drill-outcomes.md) | `abstract fun findAllDrillOutcomes(drillID: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Maybe<`[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`DrillOutcome`](../-drill-outcome/index.md)`>>` |

### Inheritors

| Name | Summary |
|---|---|
| [DrillOutcomeFirebaseRepo](../-drill-outcome-firebase-repo/index.md) | `class DrillOutcomeFirebaseRepo : DrillOutcomeStore`<br>Created by dusan_cvetkovic on 6/24/17. |
