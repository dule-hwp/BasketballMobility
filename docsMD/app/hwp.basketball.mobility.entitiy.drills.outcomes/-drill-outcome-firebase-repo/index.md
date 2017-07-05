[app](../../index.md) / [hwp.basketball.mobility.entitiy.drills.outcomes](../index.md) / [DrillOutcomeFirebaseRepo](.)

# DrillOutcomeFirebaseRepo

`class DrillOutcomeFirebaseRepo : `[`DrillOutcomeStore`](../-drill-outcome-store/index.md)

Created by dusan_cvetkovic on 6/24/17.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DrillOutcomeFirebaseRepo()`<br>Created by dusan_cvetkovic on 6/24/17. |

### Functions

| Name | Summary |
|---|---|
| [addDrillOutcomeToDatabase](add-drill-outcome-to-database.md) | `fun addDrillOutcomeToDatabase(drillOutcome: `[`DrillOutcome`](../-drill-outcome/index.md)`, drillBitmap: `[`Bitmap`](https://developer.android.com/reference/android/graphics/Bitmap.html)`, drillBitmapArea: `[`Bitmap`](https://developer.android.com/reference/android/graphics/Bitmap.html)`): Completable` |
| [delete](delete.md) | `fun delete(drillOutcome: `[`DrillOutcome`](../-drill-outcome/index.md)`): Completable` |
| [findAll](find-all.md) | `fun findAll(): Maybe<`[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`DrillOutcome`](../-drill-outcome/index.md)`>>` |
| [findAllDrillOutcomes](find-all-drill-outcomes.md) | `fun findAllDrillOutcomes(drillID: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Maybe<`[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`DrillOutcome`](../-drill-outcome/index.md)`>>` |
| [saveDrillImage](save-drill-image.md) | `fun saveDrillImage(bitmap: `[`Bitmap`](https://developer.android.com/reference/android/graphics/Bitmap.html)`?, drillOutcome: `[`DrillOutcome`](../-drill-outcome/index.md)`, name: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): Single<`[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`>` |

### Companion Object Properties

| Name | Summary |
|---|---|
| [DATE_FORMAT](-d-a-t-e_-f-o-r-m-a-t.md) | `val DATE_FORMAT: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
