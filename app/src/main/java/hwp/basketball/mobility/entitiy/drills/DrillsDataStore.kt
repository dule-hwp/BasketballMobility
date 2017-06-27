package hwp.basketball.mobility.entitiy.drills

import android.graphics.Bitmap
import io.reactivex.Completable
import io.reactivex.Maybe

/**
 * Created by dusan_cvetkovic on 3/28/17.
 */
interface DrillsDataStore {
    fun addDrillToDatabase(item: DrillViewModel, bitmap: Bitmap): Completable
    fun delete(drillViewModel: DrillViewModel): Completable
    fun findAll(): Maybe<MutableList<DrillViewModel>>
    fun cleanup()
}