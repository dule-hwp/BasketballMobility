[app](../../index.md) / [hwp.basketball.mobility.drillpreparation.step.selectplayers](../index.md) / [PlayersAdapter](.)

# PlayersAdapter

`class PlayersAdapter : `[`Adapter`](https://developer.android.com/reference/android/support/v7/widget/RecyclerView/Adapter.html)`<`[`PlayerViewHolder`](-player-view-holder/index.md)`>, `[`AdapterView`](../-players-contract/-adapter-view/index.md)

Created by dusan_cvetkovic on 3/28/17.

### Types

| Name | Summary |
|---|---|
| [PlayerViewHolder](-player-view-holder/index.md) | `class PlayerViewHolder : `[`ViewHolder`](https://developer.android.com/reference/android/support/v7/widget/RecyclerView/ViewHolder.html) |

### Constructors

| Name | Summary |
|---|---|
| [&lt;init&gt;](-init-.md) | `PlayersAdapter()`<br>Created by dusan_cvetkovic on 3/28/17. |

### Properties

| Name | Summary |
|---|---|
| [listener](listener.md) | `lateinit var listener: `[`Presenter`](../-players-contract/-presenter/index.md) |
| [players](players.md) | `var players: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`PlayerViewModel`](../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`>` |

### Functions

| Name | Summary |
|---|---|
| [addPlayer](add-player.md) | `fun addPlayer(player: `[`PlayerViewModel`](../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Update UI after player was added to the list of players |
| [getCount](get-count.md) | `fun getCount(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)<br>Return number of players in the list. |
| [getCurrentEditingItem](get-current-editing-item.md) | `fun getCurrentEditingItem(): `[`PlayerViewModel`](../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`?`<br>Return item currently being edited. |
| [getItem](get-item.md) | `fun getItem(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`PlayerViewModel`](../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`?`<br>Return player sitting on index. |
| [getItemCount](get-item-count.md) | `fun getItemCount(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [listener](listener.md) | `fun listener(listener: `[`Presenter`](../-players-contract/-presenter/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Set listener for tap events on the list items. |
| [notifyInsertedAt](notify-inserted-at.md) | `fun notifyInsertedAt(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Notify that the player has be inserted at position. |
| [notifyPlayerDeleted](notify-player-deleted.md) | `fun notifyPlayerDeleted(playerPosition: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Update UI after player has been deleted from list. |
| [notifyPlayerUpdated](notify-player-updated.md) | `fun notifyPlayerUpdated(player: `[`PlayerViewModel`](../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Update UI after player data has been changed. This will be triggered after user has updated the player data. |
| [onBindViewHolder](on-bind-view-holder.md) | `fun onBindViewHolder(holder: `[`PlayerViewHolder`](-player-view-holder/index.md)`?, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateViewHolder](on-create-view-holder.md) | `fun onCreateViewHolder(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`?, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`PlayerViewHolder`](-player-view-holder/index.md) |
| [swapData](swap-data.md) | `fun swapData(data: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`PlayerViewModel`](../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)<br>Replace the data displayed with new data. |
