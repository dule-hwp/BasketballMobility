[app](../index.md) / [hwp.basketball.mobility.drillpreparation.step.connectplayers](.)

## Package hwp.basketball.mobility.drillpreparation.step.connectplayers

MVP pattern fragment implementation of the connect players step.

### Types

| Name | Summary |
|---|---|
| [ConnectPlayersAdapter](-connect-players-adapter/index.md) | `class ConnectPlayersAdapter : `[`Adapter`](https://developer.android.com/reference/android/support/v7/widget/RecyclerView/Adapter.html)`<`[`ConnectPlayerViewHolder`](-connect-players-adapter/-connect-player-view-holder/index.md)`>, `[`AdapterView`](-connect-players-contract/-adapter-view/index.md)<br>Created by dusan_cvetkovic on 3/28/17. |
| [ConnectPlayersContract](-connect-players-contract/index.md) | `interface ConnectPlayersContract`<br>Contract that needs to be fulfilled for connect players step to work properly. |
| [ConnectPlayersFragment](-connect-players-fragment/index.md) | `class ConnectPlayersFragment : `[`BaseStepFragment`](../hwp.basketball.mobility.drillpreparation.step/-base-step-fragment/index.md)`, `[`View`](-connect-players-contract/-view/index.md)<br>Player connect step. View being shown in preparation drill process when coach connects all the selected players. |
| [ConnectPlayersPresenter](-connect-players-presenter/index.md) | `class ConnectPlayersPresenter : `[`Presenter`](-connect-players-contract/-presenter/index.md)`, `[`AdapterViewCallback`](-connect-players-contract/-adapter-view-callback/index.md)<br>Created by dusan_cvetkovic on 4/4/17. |
