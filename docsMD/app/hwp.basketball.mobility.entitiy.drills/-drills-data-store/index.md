[app](../../index.md) / [hwp.basketball.mobility.entitiy.drills](../index.md) / [DrillsDataStore](.)

# DrillsDataStore

`interface DrillsDataStore`

Created by dusan_cvetkovic on 3/28/17.

### Functions

| Name | Summary |
|---|---|
| [addDrillToDatabase](add-drill-to-database.md) | `abstract fun addDrillToDatabase(item: `[`DrillViewModel`](../-drill-view-model/index.md)`, bitmap: `[`Bitmap`](https://developer.android.com/reference/android/graphics/Bitmap.html)`): Completable` |
| [cleanup](cleanup.md) | `abstract fun cleanup(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [delete](delete.md) | `abstract fun delete(drillViewModel: `[`DrillViewModel`](../-drill-view-model/index.md)`): Completable` |
| [findAll](find-all.md) | `abstract fun findAll(): Maybe<`[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`DrillViewModel`](../-drill-view-model/index.md)`>>` |

### Inheritors

| Name | Summary |
|---|---|
| [DrillsFirebaseRepository](../-drills-firebase-repository/index.md) | `class DrillsFirebaseRepository : DrillsDataStore`<br>Firebase DrillsDataStore implementation. |
