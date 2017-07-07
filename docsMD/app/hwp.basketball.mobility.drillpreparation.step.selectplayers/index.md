[app](../index.md) / [hwp.basketball.mobility.drillpreparation.step.selectplayers](.)

## Package hwp.basketball.mobility.drillpreparation.step.selectplayers

MVP fragment implementation of the select player. In this step it is also possible to create/edit/delete player, so thats why it makses sense to introduce MVP pattern.

### Types

| Name | Summary |
|---|---|
| [PlayerDialog](-player-dialog/index.md) | `class PlayerDialog`<br>Created by dusan_cvetkovic on 4/2/17. |
| [PlayersAdapter](-players-adapter/index.md) | `class PlayersAdapter : `[`Adapter`](https://developer.android.com/reference/android/support/v7/widget/RecyclerView/Adapter.html)`<`[`PlayerViewHolder`](-players-adapter/-player-view-holder/index.md)`>, `[`AdapterView`](-players-contract/-adapter-view/index.md)<br>Created by dusan_cvetkovic on 3/28/17. |
| [PlayersContract](-players-contract/index.md) | `interface PlayersContract`<br>Created by dusan_cvetkovic on 3/28/17. |
| [PlayersFragment](-players-fragment/index.md) | `class PlayersFragment : `[`BaseStepFragment`](../hwp.basketball.mobility.drillpreparation.step/-base-step-fragment/index.md)`, `[`View`](-players-contract/-view/index.md)<br>Created by dusan_cvetkovic on 3/23/17. |
| [PlayersPresenter](-players-presenter/index.md) | `class PlayersPresenter : `[`Presenter`](-players-contract/-presenter/index.md)<br>Created by dusan_cvetkovic on 3/28/17. |
