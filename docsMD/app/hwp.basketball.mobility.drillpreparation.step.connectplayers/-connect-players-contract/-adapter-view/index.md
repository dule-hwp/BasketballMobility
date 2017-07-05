[app](../../../index.md) / [hwp.basketball.mobility.drillpreparation.step.connectplayers](../../index.md) / [ConnectPlayersContract](../index.md) / [AdapterView](.)

# AdapterView

`interface AdapterView`

### Functions

| [addListener](add-listener.md) | `abstract fun addListener(listener: `[`AdapterViewCallback`](../-adapter-view-callback/index.md)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [getItem](get-item.md) | `abstract fun getItem(index: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`): `[`PlayerViewModel`](../../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`?` |
| [setConnected](set-connected.md) | `abstract fun setConnected(position: `[`Int`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)`, checked: `[`Boolean`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html)`): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |
| [swapData](swap-data.md) | `abstract fun swapData(data: `[`List`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)`<`[`PlayerViewModel`](../../../hwp.basketball.mobility.entitiy.player/-player-view-model/index.md)`>?): `[`Unit`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html) |

### Inheritors

| [ConnectPlayersAdapter](../../-connect-players-adapter/index.md) | `class ConnectPlayersAdapter : `[`Adapter`](https://developer.android.com/reference/android/support/v7/widget/RecyclerView/Adapter.html)`<`[`ConnectPlayerViewHolder`](../../-connect-players-adapter/-connect-player-view-holder/index.md)`>, AdapterView`<br>Created by dusan_cvetkovic on 3/28/17. |

