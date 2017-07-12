[app](../../../index.md) / [hwp.basketball.mobility.drillpreparation.step.connectplayers](../../index.md) / [ConnectPlayersContract](../index.md) / [AdapterView](.)

# AdapterView

`interface AdapterView`

### Functions

| Name | Summary |
|---|---|
| [addListener](add-listener.md) | `abstract fun addListener(listener: `[`AdapterViewCallback`](../-adapter-view-callback/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Set listener for tap events on the list items. |
| [getItem](get-item.md) | `abstract fun getItem(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`PlayerViewModel`](../../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`?`<br>Return player sitting on index. |
| [setConnected](set-connected.md) | `abstract fun setConnected(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, checked: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Update switch UI for given position and state. |
| [swapData](swap-data.md) | `abstract fun swapData(data: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`PlayerViewModel`](../../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Replace the data displayed with new data. |

### Inheritors

| Name | Summary |
|---|---|
| [ConnectPlayersAdapter](../../-connect-players-adapter/index.md) | `class ConnectPlayersAdapter : `[`Adapter`](https://developer.android.com/reference/android/support/v7/widget/RecyclerView/Adapter.html)`<`[`ConnectPlayerViewHolder`](../../-connect-players-adapter/-connect-player-view-holder/index.md)`>, AdapterView`<br>Created by dusan_cvetkovic on 3/28/17. |
