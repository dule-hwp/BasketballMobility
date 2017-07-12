package hwp.basketball.mobility.entitiy.drills

import android.graphics.Bitmap
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import durdinapps.rxfirebase2.DataSnapshotMapper
import durdinapps.rxfirebase2.RxFirebaseDatabase
import hwp.basketball.mobility.util.FirebaseStorageUtils
import hwp.basketball.mobility.util.getFireBaseDBEmail
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber


/**
 * Firebase DrillsDataStore implementation.
 *
 * Responsible for manipulating data from firebase.
 * Created by dusan_cvetkovic on 4/4/17.
 */
class DrillsFirebaseRepository : DrillsDataStore {

    companion object {
        val DRILLS_CHILD: String = "drills"
    }

    private val mUserDrillsDBReference: DatabaseReference by lazy {
        FirebaseDatabase.getInstance()
                .reference
                .child(DRILLS_CHILD)
                .child(mFirebaseUser.getFireBaseDBEmail())
    }

    private val mFirebaseAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }
    private val mFirebaseUser: FirebaseUser by lazy {
        mFirebaseAuth.currentUser!!
    }

    private val compositeDisposable by lazy { CompositeDisposable() }

    override fun addDrillToDatabase(item: DrillViewModel, bitmap: Bitmap): Completable {
        return Completable.create { emitter ->
            val push = getDrillDBreference(item).push()
            item.id = push.key
            push.setValue(item, { databaseError, _ ->
                if (databaseError == null) {
                    val disposable = saveDrillImage(bitmap, item)
                            .subscribe({
                                Timber.d("onComplete drill image uploaded")
                                emitter.onComplete()
                            }, {
                                Timber.e("Bitmap not saved to storage.")
                                Timber.e(it)
                                emitter.onComplete()
                            })
                    compositeDisposable.add(disposable)
//                    emitter.onComplete()
                } else {
                    Timber.e("Unable to write message to database.", databaseError.toException())
                    emitter.onError(databaseError.toException())
                }
            })
        }
    }

    override fun delete(drillViewModel: DrillViewModel): Completable {
        return Completable.create({ emitter ->
            Timber.d("drill should be deleted from db here!!!")
            getDrillDBreference(drillViewModel).ref.removeValue()
                    .addOnCompleteListener {
                        deleteImageFromStorage(drillViewModel)
                        emitter.onComplete()
                    }
                    .addOnFailureListener {
                        deleteImageFromStorage(drillViewModel)
                        emitter.onError(it)
                    }
        })

    }

    private fun getDrillDBreference(item: DrillViewModel) = mUserDrillsDBReference.child(item.name)

    private fun deleteImageFromStorage(drillViewModel: DrillViewModel) {
        getStorageRefForDrill(drillViewModel).delete()
    }

    override fun findAll(): Maybe<MutableList<DrillViewModel>> {
        return RxFirebaseDatabase.observeSingleValueEvent(mUserDrillsDBReference,
                DataSnapshotMapper.listOf(DrillViewModel::class.java))
    }

    fun saveDrillImage(bitmap: Bitmap, drillAddedToDatabase: DrillViewModel): Completable {
        return Completable.create { emitter ->
            val storageReference = getStorageRefForDrill(drillAddedToDatabase)
            FirebaseStorageUtils.saveBitmapToStorage(bitmap, storageReference)
                    .subscribe({
                        drillAddedToDatabase.drillImage = it
                        getDrillDBreference(drillAddedToDatabase).ref
                                .setValue(drillAddedToDatabase)
                                .addOnSuccessListener { emitter.onComplete() }
                                .addOnFailureListener {
                                    Timber.d(it)
                                    emitter.onComplete()
                                }
                    }, {
                        emitter.onError(it)
                    })
        }

    }

    private fun getStorageRefForDrill(drillAddedToDatabase: DrillViewModel): StorageReference {
        val storageReference = FirebaseStorage.getInstance()
                .getReference(DRILLS_CHILD)
                .child(mFirebaseUser.getFireBaseDBEmail())
                .child("${drillAddedToDatabase.name}.png")
        return storageReference
    }

    override fun cleanup() {
        compositeDisposable.clear()
    }
}