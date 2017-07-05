[app](../../../index.md) / [hwp.basketball.mobility.drillpreparation.step.selectdrill](../../index.md) / [DrillsContract](../index.md) / [Presenter](.)

# Presenter

`interface Presenter : `[`BasePresenter`](../../../hwp.basketball.mobility/-base-presenter/index.md)

### Functions

| Name | Summary |
|---|---|
| [deleteDrill](delete-drill.md) | `abstract fun deleteDrill(drill: `[`DrillViewModel`](../../../hwp.basketball.mobility.entitiy.drills/-drill-view-model/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [drillSelected](drill-selected.md) | `abstract fun drillSelected(drill: `[`DrillViewModel`](../../../hwp.basketball.mobility.entitiy.drills/-drill-view-model/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [handleNewDrillCreated](handle-new-drill-created.md) | `abstract fun handleNewDrillCreated(pathPoints: `[`Array`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-array/index.html)`<`[`PointF`](../../../hwp.basketball.mobility.util/-point-f/index.md)`>?, drillImage: `[`Bitmap`](https://developer.android.com/reference/android/graphics/Bitmap.html)`?, drillname: `[`String`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [refreshData](refresh-data.md) | `abstract fun refreshData(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [setDrillAdapterView](set-drill-adapter-view.md) | `abstract fun setDrillAdapterView(drillsAdapter: `[`AdapterView`](../-adapter-view/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [verifyStep](verify-step.md) | `abstract fun verifyStep(): VerificationError?` |

### Inherited Functions

| Name | Summary |
|---|---|
| [attach](../../../hwp.basketball.mobility/-base-presenter/attach.md) | `abstract fun attach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [detach](../../../hwp.basketball.mobility/-base-presenter/detach.md) | `abstract fun detach(): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [DrillsPresenter](../../-drills-presenter/index.md) | `class DrillsPresenter : Presenter`<br>Created by dusan_cvetkovic on 4/4/17. |
