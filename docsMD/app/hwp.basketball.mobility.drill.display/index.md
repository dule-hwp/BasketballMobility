[app](../index.md) / [hwp.basketball.mobility.drill.display](.)

## Package hwp.basketball.mobility.drill.display

MVP implementation fo display drills acttivity.

### Types

| Name | Summary |
|---|---|
| [DrillDetailActivity](-drill-detail-activity/index.md) | `class DrillDetailActivity : `[`AppCompatActivity`](https://developer.android.com/reference/android/support/v7/app/AppCompatActivity.html)<br>An activity representing a single Drill detail screen. This activity is only used on narrow width devices. On tablet-size devices, item details are presented side-by-side with a list of items in a [DrillListActivity](-drill-list-activity/index.md). |
| [DrillListActivity](-drill-list-activity/index.md) | `class DrillListActivity : `[`AppCompatActivity`](https://developer.android.com/reference/android/support/v7/app/AppCompatActivity.html)`, `[`View`](-drill-list-activity-contract/-view/index.md)<br>An activity representing a list of Drills. This activity has different presentations for handset and tablet-size devices. On handsets, the activity presents a list of items, which when touched, lead to a [DrillDetailActivity](-drill-detail-activity/index.md) representing item details. On tablets, the activity presents the list of items and item details side-by-side using two vertical panes. |
| [DrillListActivityContract](-drill-list-activity-contract/index.md) | `interface DrillListActivityContract`<br>Created by dusan_cvetkovic on 6/26/17. |
| [DrillListActivityPresenter](-drill-list-activity-presenter/index.md) | `class DrillListActivityPresenter : `[`Presenter`](-drill-list-activity-contract/-presenter/index.md)<br>Created by dusan_cvetkovic on 6/26/17. |
| [DrillsAdapter](-drills-adapter/index.md) | `class DrillsAdapter : ExpandableRecyclerViewAdapter<`[`DrillViewHolder`](-drills-adapter/-drill-view-holder/index.md)`, `[`DrillOutcomeViewHolder`](-drills-adapter/-drill-outcome-view-holder/index.md)`>`<br>Created by dusan_cvetkovic on 6/26/17. |
