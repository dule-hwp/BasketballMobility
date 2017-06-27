package hwp.basketball.mobility.entitiy.player

import io.reactivex.Completable
import io.reactivex.Maybe

/**
 * Created by dusan_cvetkovic on 3/28/17.
 */
interface PlayersDataStore {
    fun add(player: PlayerViewModel): Completable
    fun remove(player: PlayerViewModel): Completable
    fun update(player: PlayerViewModel): Completable
    fun findAll(): Maybe<MutableList<PlayerViewModel>>
}