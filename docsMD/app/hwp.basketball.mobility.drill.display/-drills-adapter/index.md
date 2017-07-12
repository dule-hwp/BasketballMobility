[app](../../index.md) / [hwp.basketball.mobility.drill.display](../index.md) / [DrillsAdapter](.)

# DrillsAdapter

`class DrillsAdapter : ExpandableRecyclerViewAdapter<`[`DrillViewHolder`](-drill-view-holder/index.md)`, `[`DrillOutcomeViewHolder`](-drill-outcome-view-holder/index.md)`>`

Created by dusan_cvetkovic on 6/26/17.

### Types

| Name | Summary |
|---|---|
| [DrillOutcomeViewHolder](-drill-outcome-view-holder/index.md) | `inner class DrillOutcomeViewHolder : ChildViewHolder` |
| [DrillViewHolder](-drill-view-holder/index.md) | `inner class DrillViewHolder : GroupViewHolder` |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `DrillsAdapter(drills: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<ExpandableGroup<`[`DrillOutcome`](../../hwp.basketball.mobility.entitiy.drills.outcomes/-drill-outcome/index.md)`>>, drillOutcomeListener: `[`DrillOutcomeCallback`](../-drill-list-activity-contract/-drill-outcome-callback/index.md)`)`<br>Created by dusan_cvetkovic on 6/26/17. |

### Properties

| Name | Summary |
|---|---|
| [drillOutcomeListener](drill-outcome-listener.md) | `val drillOutcomeListener: `[`DrillOutcomeCallback`](../-drill-list-activity-contract/-drill-outcome-callback/index.md) |
| [drills](drills.md) | `val drills: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<ExpandableGroup<`[`DrillOutcome`](../../hwp.basketball.mobility.entitiy.drills.outcomes/-drill-outcome/index.md)`>>` |

### Functions

| Name | Summary |
|---|---|
| [onBindChildViewHolder](on-bind-child-view-holder.md) | `fun onBindChildViewHolder(holder: `[`DrillOutcomeViewHolder`](-drill-outcome-view-holder/index.md)`, flatPosition: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, group: ExpandableGroup<*>, childIndex: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onBindGroupViewHolder](on-bind-group-view-holder.md) | `fun onBindGroupViewHolder(holder: `[`DrillViewHolder`](-drill-view-holder/index.md)`, flatPosition: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, group: ExpandableGroup<*>): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateChildViewHolder](on-create-child-view-holder.md) | `fun onCreateChildViewHolder(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`DrillOutcomeViewHolder`](-drill-outcome-view-holder/index.md) |
| [onCreateGroupViewHolder](on-create-group-view-holder.md) | `fun onCreateGroupViewHolder(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`DrillViewHolder`](-drill-view-holder/index.md) |
