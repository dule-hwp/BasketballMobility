[app](../../index.md) / [hwp.basketball.mobility.entitiy.player](../index.md) / [PlayersDataStore](.)

# PlayersDataStore

`interface PlayersDataStore`

Created by dusan_cvetkovic on 3/28/17.

### Functions

| [add](add.md) | `abstract fun add(player: `[`PlayerViewModel`](../-player-view-model/index.md)`): Completable` |
| [findAll](find-all.md) | `abstract fun findAll(): Maybe<`[`MutableList`](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-mutable-list/index.html)`<`[`PlayerViewModel`](../-player-view-model/index.md)`>>` |
| [remove](remove.md) | `abstract fun remove(player: `[`PlayerViewModel`](../-player-view-model/index.md)`): Completable` |
| [update](update.md) | `abstract fun update(player: `[`PlayerViewModel`](../-player-view-model/index.md)`): Completable` |

### Inheritors

| [PlayerFirebaseRepository](../-player-firebase-repository/index.md) | `class PlayerFirebaseRepository : PlayersDataStore`<br>Created by dusan_cvetkovic on 3/26/17. |

