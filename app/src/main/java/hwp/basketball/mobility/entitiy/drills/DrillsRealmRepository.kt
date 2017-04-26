package hwp.basketball.mobility.entitiy.drills

import hugo.weaving.DebugLog
import io.reactivex.Single
import timber.log.Timber

/**
 * Created by dusan_cvetkovic on 4/4/17.
 */
object DrillsRealmRepository: DrillsDataStore{

    private val repoItems = mutableListOf<DrillViewModel>()


//    companion object{
//        fun getInstance(): DrillsRealmRepository = DrillsRealmRepository()
//    }

    override fun add(item: DrillViewModel): Single<DrillViewModel> {
        repoItems.add(item)
        return Single.just(item)

    }

    @DebugLog
    override fun remove(id: Int) {
        Timber.d("drill should be deleted from db here!!!")
    }

    @DebugLog
    override fun findAll(): Single<List<DrillViewModel>> {
        val list:List<DrillViewModel> = (1..10).map { DrillViewModel("drill$it", it, 1, null, null) }
        val allDrills = list.toMutableList()
        allDrills.addAll(repoItems)
        return Single.just(allDrills)
    }
}