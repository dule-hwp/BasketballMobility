[app](../../index.md) / [hwp.basketball.mobility.entitiy.drills](../index.md) / [DrillsFirebaseRepository](.)

# DrillsFirebaseRepository

`class DrillsFirebaseRepository : `[`DrillsDataStore`](../-drills-data-store/index.md)

Firebase DrillsDataStore implementation.

Responsible for manipulating data from firebase.
Created by dusan_cvetkovic on 4/4/17.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DrillsFirebaseRepository()`<br>Firebase DrillsDataStore implementation. |

### Functions

| Name | Summary |
|---|---|
| [addDrillToDatabase](add-drill-to-database.md) | `fun addDrillToDatabase(item: `[`DrillViewModel`](../-drill-view-model/index.md)`, bitmap: `[`Bitmap`](https://developer.android.com/reference/android/graphics/Bitmap.html)`): Completable` |
| [cleanup](cleanup.md) | `fun cleanup(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [delete](delete.md) | `fun delete(drillViewModel: `[`DrillViewModel`](../-drill-view-model/index.md)`): Completable` |
| [findAll](find-all.md) | `fun findAll(): Maybe<`[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`DrillViewModel`](../-drill-view-model/index.md)`>>` |
| [saveDrillImage](save-drill-image.md) | `fun saveDrillImage(bitmap: `[`Bitmap`](https://developer.android.com/reference/android/graphics/Bitmap.html)`, drillAddedToDatabase: `[`DrillViewModel`](../-drill-view-model/index.md)`): Completable` |

### Companion Object Properties

| Name | Summary |
|---|---|
| [DRILLS_CHILD](-d-r-i-l-l-s_-c-h-i-l-d.md) | `val DRILLS_CHILD: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
