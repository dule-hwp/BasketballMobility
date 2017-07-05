[app](../../index.md) / [hwp.basketball.mobility.drillpreparation.step.connectplayers](../index.md) / [ConnectPlayersAdapter](.)

# ConnectPlayersAdapter

`class ConnectPlayersAdapter : `[`Adapter`](https://developer.android.com/reference/android/support/v7/widget/RecyclerView/Adapter.html)`<`[`ConnectPlayerViewHolder`](-connect-player-view-holder/index.md)`>, `[`AdapterView`](../-connect-players-contract/-adapter-view/index.md)

Created by dusan_cvetkovic on 3/28/17.

### Types

| [ConnectPlayerViewHolder](-connect-player-view-holder/index.md) | `class ConnectPlayerViewHolder : `[`ViewHolder`](https://developer.android.com/reference/android/support/v7/widget/RecyclerView/ViewHolder.html) |

### Constructors

| [&lt;init&gt;](-init-.md) | `ConnectPlayersAdapter()`<br>Created by dusan_cvetkovic on 3/28/17. |

### Properties

| [listener](listener.md) | `var listener: `[`AdapterViewCallback`](../-connect-players-contract/-adapter-view-callback/index.md)`?` |
| [players](players.md) | `var players: `[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`PlayerViewModel`](../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`>` |

### Functions

| [addListener](add-listener.md) | `fun addListener(listener: `[`AdapterViewCallback`](../-connect-players-contract/-adapter-view-callback/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getItem](get-item.md) | `fun getItem(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`PlayerViewModel`](../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`?` |
| [getItemCount](get-item-count.md) | `fun getItemCount(): `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html) |
| [onBindViewHolder](on-bind-view-holder.md) | `fun onBindViewHolder(holder: `[`ConnectPlayerViewHolder`](-connect-player-view-holder/index.md)`?, position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [onCreateViewHolder](on-create-view-holder.md) | `fun onCreateViewHolder(parent: `[`ViewGroup`](https://developer.android.com/reference/android/view/ViewGroup.html)`?, viewType: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`ConnectPlayerViewHolder`](-connect-player-view-holder/index.md) |
| [setConnected](set-connected.md) | `fun setConnected(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, checked: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [swapData](swap-data.md) | `fun swapData(data: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`PlayerViewModel`](../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

