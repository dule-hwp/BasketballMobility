[app](../../../index.md) / [hwp.basketball.mobility.drillpreparation.step.selectplayers](../../index.md) / [PlayersContract](../index.md) / [AdapterView](.)

# AdapterView

`interface AdapterView`

### Functions

| [addPlayer](add-player.md) | `abstract fun addPlayer(player: `[`PlayerViewModel`](../../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getCount](get-count.md) | `abstract fun getCount(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [getCurrentEditingItem](get-current-editing-item.md) | `abstract fun getCurrentEditingItem(): `[`PlayerViewModel`](../../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`?` |
| [getItem](get-item.md) | `abstract fun getItem(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`PlayerViewModel`](../../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`?` |
| [listener](listener.md) | `abstract fun listener(listener: `[`Presenter`](../-presenter/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [notifyInsertedAt](notify-inserted-at.md) | `abstract fun notifyInsertedAt(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [notifyPlayerDeleted](notify-player-deleted.md) | `abstract fun notifyPlayerDeleted(playerPosition: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [notifyPlayerUpdated](notify-player-updated.md) | `abstract fun notifyPlayerUpdated(player: `[`PlayerViewModel`](../../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [swapData](swap-data.md) | `abstract fun swapData(data: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`PlayerViewModel`](../../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| [PlayersAdapter](../../-players-adapter/index.md) | `class PlayersAdapter : `[`Adapter`](https://developer.android.com/reference/android/support/v7/widget/RecyclerView/Adapter.html)`<`[`PlayerViewHolder`](../../-players-adapter/-player-view-holder/index.md)`>, AdapterView`<br>Created by dusan_cvetkovic on 3/28/17. |

