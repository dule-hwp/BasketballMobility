package hwp.basketball.mobility.entitiy.user

import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import durdinapps.rxfirebase2.RxFirebaseDatabase
import io.reactivex.Completable
import io.reactivex.Maybe
import timber.log.Timber

//import io.realm.Realm


/**
 * Created by dusan_cvetkovic on 3/26/17.
 */

class UserFirebaseDataStore : UserDataStore<CoachViewModel> {

    companion object {
        val COACHES_CHILD = "coaches"
    }

    private val mCoachesDBReference: DatabaseReference by lazy {
        FirebaseDatabase.getInstance().reference.child(COACHES_CHILD)
    }


    private fun getCoachDBReference(coach: CoachViewModel) = mCoachesDBReference.child(coach.email)

    override fun add(coach: CoachViewModel): Completable {
//        return Completable.create { emitter ->
//            getCoachDBReference(coach)
//                    .setValue(coach, { databaseError, databaseReference ->
//                        if (databaseError == null) {
//                            val key = databaseReference.key
//                            databaseReference.child("id").ref.setValue(key)
//                            emitter.onComplete()
//                        } else {
//                            Timber.e("Unable to add coach to database.", databaseError.toException())
//                            emitter.onError(databaseError.toException())
//                        }
//                    })
//    }
        return RxFirebaseDatabase.setValue(getCoachDBReference(coach), coach)
    }

    override fun findByEmail(email: String): Maybe<CoachViewModel> {
        return RxFirebaseDatabase.observeSingleValueEvent(mCoachesDBReference.child(email),
                CoachViewModel::class.java)
    }
}

