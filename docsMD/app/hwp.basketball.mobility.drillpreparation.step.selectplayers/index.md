[app](../index.md) / [hwp.basketball.mobility.drillpreparation.step.selectplayers](.)

## Package hwp.basketball.mobility.drillpreparation.step.selectplayers

MVP fragment implementation of the select player. In this step it is also possible to create/edit/delete player, so thats why it makses sense to introduce MVP pattern.

### Types

| Name | Summary |
|---|---|
| [PlayerDialog](-player-dialog/index.md) | `class PlayerDialog`<br>Class in charge of displaying show/edit dialog. |
| [PlayersAdapter](-players-adapter/index.md) | `class PlayersAdapter : `[`Adapter`](https://developer.android.com/reference/android/support/v7/widget/RecyclerView/Adapter.html)`<`[`PlayerViewHolder`](-players-adapter/-player-view-holder/index.md)`>, `[`AdapterView`](-players-contract/-adapter-view/index.md)<br>Created by dusan_cvetkovic on 3/28/17. |
| [PlayersContract](-players-contract/index.md) | `interface PlayersContract`<br>Contract that needs to be fulfilled for players step to work properly. |
| [PlayersFragment](-players-fragment/index.md) | `class PlayersFragment : `[`BaseStepFragment`](../hwp.basketball.mobility.drillpreparation.step/-base-step-fragment/index.md)`, `[`View`](-players-contract/-view/index.md)<br>Player select step. View being shown in preparation drill process when coach selects player. |
| [PlayersPresenter](-players-presenter/index.md) | `class PlayersPresenter : `[`Presenter`](-players-contract/-presenter/index.md)<br>Created by dusan_cvetkovic on 3/28/17. |
