package hwp.basketball.mobility.entitiy.drills.outcomes

import android.graphics.Bitmap
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import durdinapps.rxfirebase2.DataSnapshotMapper
import durdinapps.rxfirebase2.RxFirebaseDatabase
import hwp.basketball.mobility.drillpreparation.step.DrillSetupOutput
import hwp.basketball.mobility.entitiy.drills.DrillsFirebaseRepository.Companion.DRILLS_CHILD
import hwp.basketball.mobility.util.FirebaseStorageUtils
import hwp.basketball.mobility.util.getFireBaseDBEmail
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.SingleEmitter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import org.joda.time.LocalDateTime
import timber.log.Timber

/**
 * Created by dusan_cvetkovic on 6/24/17.
 */
class DrillOutcomeFirebaseRepo : DrillOutcomeStore {

    companion object {
        val DATE_FORMAT = "MM-dd-YYYY_HH:mm"
    }

    private val PERFORMED_DRILLS_CHILD: String = "outcomes"
    private val mDrillOutcomeDBReference: DatabaseReference by lazy {
        FirebaseDatabase.getInstance().reference.child(DRILLS_CHILD).child(mFirebaseUser?.getFireBaseDBEmail())
    }

    private val mFirebaseAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }
    private val mFirebaseUser: FirebaseUser? by lazy {
        mFirebaseAuth.currentUser
    }

    override fun addDrillOutcomeToDatabase(drillOutcome: DrillOutcome, drillBitmap: Bitmap, drillBitmapArea: Bitmap): Completable {
        return Completable.create { emitter ->
            val push = getOutcomesDBReference(drillOutcome.drillName).push()
            drillOutcome.id = push.key
            push.setValue(drillOutcome, { databaseError, _ ->
                if (databaseError == null) {
                    val now = LocalDateTime.now().toString(DATE_FORMAT)
                    val completable = saveDrillImage(drillBitmap, drillOutcome, "drillPreformedBitmap-$now")
                    val completable2 = saveDrillImage(drillBitmapArea, drillOutcome, "drillPerformedMarked-$now")

                    Single.zip(completable, completable2,
                            BiFunction<String, String, DrillOutcome> { drillUrl, markedDrillUrl ->
                                drillOutcome.drillOutcomeImage = drillUrl
                                drillOutcome.drillOutcomeImageArea = markedDrillUrl
                                drillOutcome
                            })
                            .subscribeOn(Schedulers.newThread())
                            .observeOn(AndroidSchedulers.mainThread())
                            .onErrorReturn { drillOutcome }
                            .flatMap { drillOutcome ->
                                Single.create({ emitter: SingleEmitter<String> ->
                                    getOutcomeDBReference(drillOutcome).setValue(drillOutcome)
                                            .addOnFailureListener { emitter.onError(it) }
                                            .addOnSuccessListener { emitter.onSuccess("success") }
                                })
                            }
                            .subscribe({
                                emitter.onComplete()
                            }, {
                                Timber.d("Some unexpected error occurred!")
                                Timber.e(it)
                                emitter.onComplete()
                            })
                } else {
                    Timber.e("Unable to write message to database.", databaseError.toException())
                    emitter.onError(databaseError.toException())
                }
            })
        }
    }

    fun saveDrillImage(bitmap: Bitmap?, drillOutcome: DrillOutcome, name: String): Single<String> {
        if (bitmap != null) {
            return Single.create { emitter ->
                val storageReference = getStorageRefForDrillOutcome(drillOutcome,
                        DrillSetupOutput.connectMap.entries.first().key.name,
                        DrillSetupOutput.drill?.name)
                        .child("$name.png")

                FirebaseStorageUtils
                        .saveBitmapToStorage(bitmap, storageReference)
                        .subscribe({ emitter.onSuccess(it) },
                                { emitter.onError(it) })
            }
        }
        return Single.just("no bitmap")
    }


    private fun getOutcomesDBReference(drillName: String) =
            mDrillOutcomeDBReference.child(drillName).child(PERFORMED_DRILLS_CHILD)

    override fun delete(drillOutcome: DrillOutcome): Completable {
        return Completable.create({ emitter ->
            Timber.d("drill should be deleted from db here!!!")
            getOutcomeDBReference(drillOutcome).removeValue()
                    .addOnCompleteListener {
                        deleteImageFromStorage(drillOutcome)
                        emitter.onComplete()
                    }
                    .addOnFailureListener {
                        deleteImageFromStorage(drillOutcome)
                        emitter.onError(it)
                    }
        })
    }

    private fun deleteImageFromStorage(drillOutcome: DrillOutcome) {
        getStorageRefForDrillOutcome(drillOutcome, DrillSetupOutput.players[0].name, DrillSetupOutput.drill?.name).delete()
    }

    private fun getStorageRefForDrillOutcome(drillOutcome: DrillOutcome, playerName: String, drillName: String?): StorageReference {
        return FirebaseStorage.getInstance()
                .getReference("performed_drills")
                .child(drillOutcome.coachEmail ?: "unknown_coach")
                .child(drillName ?: "unknown_drill_name")
                .child(playerName)
                .child(drillOutcome.id)
    }

    private fun getOutcomeDBReference(drillOutcome: DrillOutcome) =
            getOutcomesDBReference(drillOutcome.drillName).child(drillOutcome.id).ref

    override fun findAll(): Maybe<MutableList<DrillOutcome>> {
        return findAllDrillOutcomes("")
    }

    override fun findAllDrillOutcomes(drillID: String): Maybe<MutableList<DrillOutcome>> {
        return RxFirebaseDatabase.observeSingleValueEvent(getOutcomesDBReference(drillID),
                DataSnapshotMapper.listOf(DrillOutcome::class.java))
    }

}