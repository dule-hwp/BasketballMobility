[app](../../index.md) / [hwp.basketball.mobility.drillpreparation.step.selectdrill](../index.md) / [DrillsPresenter](.)

# DrillsPresenter

`class DrillsPresenter : `[`Presenter`](../-drills-contract/-presenter/index.md)

Created by dusan_cvetkovic on 4/4/17.

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DrillsPresenter(view: `[`View`](../-drills-contract/-view/index.md)`)`<br>Created by dusan_cvetkovic on 4/4/17. |

### Properties

| Name | Summary |
|---|---|
| [drillsDataStore](drills-data-store.md) | `val drillsDataStore: `[`DrillsFirebaseRepository`](../../hwp.basketball.mobility.entitiy.drills/-drills-firebase-repository/index.md) |
| [view](view.md) | `val view: `[`View`](../-drills-contract/-view/index.md) |

### Functions

| Name | Summary |
|---|---|
| [attach](attach.md) | `fun attach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>In this callback allocation of resources and initialization should happen. |
| [deleteDrill](delete-drill.md) | `fun deleteDrill(drill: `[`DrillViewModel`](../../hwp.basketball.mobility.entitiy.drills/-drill-view-model/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [detach](detach.md) | `fun detach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>In this callback cleanup should happen. |
| [drillSelected](drill-selected.md) | `fun drillSelected(drill: `[`DrillViewModel`](../../hwp.basketball.mobility.entitiy.drills/-drill-view-model/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [handleNewDrillCreated](handle-new-drill-created.md) | `fun handleNewDrillCreated(pathPoints: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`PointF`](../../hwp.basketball.mobility.util/-point-f/index.md)`>?, drillImage: `[`Bitmap`](https://developer.android.com/reference/android/graphics/Bitmap.html)`?, drillname: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [refreshData](refresh-data.md) | `fun refreshData(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setDrillAdapterView](set-drill-adapter-view.md) | `fun setDrillAdapterView(drillsAdapter: `[`AdapterView`](../-drills-contract/-adapter-view/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [verifyStep](verify-step.md) | `fun verifyStep(): VerificationError?` |
