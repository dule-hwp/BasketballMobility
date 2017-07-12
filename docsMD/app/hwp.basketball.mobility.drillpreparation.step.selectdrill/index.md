[app](../index.md) / [hwp.basketball.mobility.drillpreparation.step.selectdrill](.)

## Package hwp.basketball.mobility.drillpreparation.step.selectdrill

MVP fragment implementation of the select step. In this step it is also possible to create/delete drill, so thats why it makses sense to introduce MVP pattern.

### Types

| Name | Summary |
|---|---|
| [DrillsAdapter](-drills-adapter/index.md) | `class DrillsAdapter : `[`Adapter`](https://developer.android.com/reference/android/support/v7/widget/RecyclerView/Adapter.html)`<`[`DrillViewHolder`](-drills-adapter/-drill-view-holder/index.md)`>, `[`AdapterView`](-drills-contract/-adapter-view/index.md)<br>Created by dusan_cvetkovic on 3/28/17. |
| [DrillsContract](-drills-contract/index.md) | `interface DrillsContract`<br>Created by dusan_cvetkovic on 3/28/17. |
| [DrillsFragment](-drills-fragment/index.md) | `class DrillsFragment : `[`BaseStepFragment`](../hwp.basketball.mobility.drillpreparation.step/-base-step-fragment/index.md)`, `[`View`](-drills-contract/-view/index.md)<br>Drill select step. View being shown in preparation drill process when coach selects drill. |
| [DrillsPresenter](-drills-presenter/index.md) | `class DrillsPresenter : `[`Presenter`](-drills-contract/-presenter/index.md)<br>Created by dusan_cvetkovic on 4/4/17. |
