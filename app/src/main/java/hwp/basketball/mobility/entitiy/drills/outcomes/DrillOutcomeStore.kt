package hwp.basketball.mobility.entitiy.drills.outcomes

import android.graphics.Bitmap
import io.reactivex.Completable
import io.reactivex.Maybe

/**
 * Created by dusan_cvetkovic on 3/28/17.
 */
interface DrillOutcomeStore {
    fun addDrillOutcomeToDatabase(drillOutcome: DrillOutcome, drillBitmap: Bitmap, drillBitmapArea: Bitmap): Completable
    fun delete(drillOutcome: DrillOutcome): Completable
    fun findAll(): Maybe<MutableList<DrillOutcome>>
    fun findAllDrillOutcomes(drillID: String): Maybe<MutableList<DrillOutcome>>
}