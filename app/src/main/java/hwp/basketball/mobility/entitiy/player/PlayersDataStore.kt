package hwp.basketball.mobility.entitiy.player

import io.reactivex.Single

/**
 * Created by dusan_cvetkovic on 3/28/17.
 */
interface PlayersDataStore {
    fun add(item: PlayerViewModel): Single<PlayerViewModel>
    fun remove(id: Int)
    fun update(player: PlayerViewModel)
    fun findAll(): Single<List<PlayerViewModel>>
}