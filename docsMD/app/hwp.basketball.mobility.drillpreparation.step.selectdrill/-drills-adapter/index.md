[app](../../index.md) / [hwp.basketball.mobility.drillpreparation.step.selectdrill](../index.md) / [DrillsAdapter](.)

# DrillsAdapter

`class DrillsAdapter : `[`Adapter`](https://developer.android.com/reference/android/support/v7/widget/RecyclerView/Adapter.html)`<`[`DrillViewHolder`](-drill-view-holder/index.md)`>, `[`AdapterView`](../-drills-contract/-adapter-view/index.md)

Created by dusan_cvetkovic on 3/28/17.

### Types

| [DrillViewHolder](-drill-view-holder/index.md) | `class DrillViewHolder : `[`ViewHolder`](https://developer.android.com/reference/android/support/v7/widget/RecyclerView/ViewHolder.html) |

### Constructors

| [&lt;init&gt;](-init-.md) | `DrillsAdapter()`<br>Created by dusan_cvetkovic on 3/28/17. |

### Properties

| [drills](drills.md) | `var drills: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`DrillViewModel`](../../hwp.basketball.mobility.entitiy.drills/-drill-view-model/index.md)`>` |
| [listener](listener.md) | `var listener: `[`Presenter`](../-drills-contract/-presenter/index.md)`?` |

### Functions

| [addDrill](add-drill.md) | `fun addDrill(drill: `[`DrillViewModel`](../../hwp.basketball.mobility.entitiy.drills/-drill-view-model/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [addListener](add-listener.md) | `fun addListener(listener: `[`Presenter`](../-drills-contract/-presenter/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getItem](get-item.md) | `fun getItem(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`DrillViewModel`](../../hwp.basketball.mobility.entitiy.drills/-drill-view-model/index.md)`?` |
| [getItemCount](get-item-count.md) | `fun getItemCount(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [notifyDrillDeleted](notify-drill-deleted.md) | `fun notifyDrillDeleted(drill: `[`DrillViewModel`](../../hwp.basketball.mobility.entitiy.drills/-drill-view-model/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onBindViewHolder](on-bind-view-holder.md) | `fun onBindViewHolder(holder: `[`DrillViewHolder`](-drill-view-holder/index.md)`?, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateViewHolder](on-create-view-holder.md) | `fun onCreateViewHolder(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`?, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`DrillViewHolder`](-drill-view-holder/index.md) |
| [swapData](swap-data.md) | `fun swapData(data: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`DrillViewModel`](../../hwp.basketball.mobility.entitiy.drills/-drill-view-model/index.md)`>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

