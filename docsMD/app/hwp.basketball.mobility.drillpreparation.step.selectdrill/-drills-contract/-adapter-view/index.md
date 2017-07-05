[app](../../../index.md) / [hwp.basketball.mobility.drillpreparation.step.selectdrill](../../index.md) / [DrillsContract](../index.md) / [AdapterView](.)

# AdapterView

`interface AdapterView`

### Functions

| Name | Summary |
|---|---|
| [addDrill](add-drill.md) | `abstract fun addDrill(drill: `[`DrillViewModel`](../../../hwp.basketball.mobility.entitiy.drills/-drill-view-model/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [addListener](add-listener.md) | `abstract fun addListener(listener: `[`Presenter`](../-presenter/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getItem](get-item.md) | `abstract fun getItem(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`DrillViewModel`](../../../hwp.basketball.mobility.entitiy.drills/-drill-view-model/index.md)`?` |
| [notifyDrillDeleted](notify-drill-deleted.md) | `abstract fun notifyDrillDeleted(drill: `[`DrillViewModel`](../../../hwp.basketball.mobility.entitiy.drills/-drill-view-model/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [swapData](swap-data.md) | `abstract fun swapData(data: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`DrillViewModel`](../../../hwp.basketball.mobility.entitiy.drills/-drill-view-model/index.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| Name | Summary |
|---|---|
| [DrillsAdapter](../../-drills-adapter/index.md) | `class DrillsAdapter : `[`Adapter`](https://developer.android.com/reference/android/support/v7/widget/RecyclerView/Adapter.html)`<`[`DrillViewHolder`](../../-drills-adapter/-drill-view-holder/index.md)`>, AdapterView`<br>Created by dusan_cvetkovic on 3/28/17. |
