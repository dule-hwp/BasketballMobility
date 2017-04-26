package hwp.basketball.mobility.entitiy.drills

import io.reactivex.Single

/**
 * Created by dusan_cvetkovic on 3/28/17.
 */
interface DrillsDataStore {
    fun add(item: DrillViewModel): Single<DrillViewModel>
    fun remove(id: Int)
    fun findAll(): Single<List<DrillViewModel>>
}