package hwp.basketball.mobility.entitiy.player

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import durdinapps.rxfirebase2.DataSnapshotMapper
import durdinapps.rxfirebase2.RxFirebaseDatabase
import hwp.basketball.mobility.util.getFireBaseDBEmail
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import timber.log.Timber


/**
 * Created by dusan_cvetkovic on 3/26/17.
 */

class PlayerFirebaseRepository : PlayersDataStore {

    private val PLAYERS_CHILD: String = "players"
    private val mPlayersDBReference: DatabaseReference by lazy {
        FirebaseDatabase.getInstance().reference.child(PLAYERS_CHILD).child(mFirebaseUser.getFireBaseDBEmail())
    }

    private val mFirebaseAuth: FirebaseAuth by lazy {
        FirebaseAuth.getInstance()
    }
    private val mFirebaseUser: FirebaseUser by lazy {
        mFirebaseAuth.currentUser!!
    }

    override fun add(player: PlayerViewModel): Completable {
        return Completable.create { emitter ->
            getPlayerDBReference(player)
                    .setValue(player, { databaseError, databaseReference ->
                        if (databaseError == null) {
                            val key = databaseReference.key
                            databaseReference.child("id").ref.setValue(key)
                            emitter.onComplete()
                        } else {
                            Timber.e("Unable to write message to database.", databaseError.toException())
                            emitter.onError(databaseError.toException())
                        }
                    })
        }

    }

    override fun remove(player: PlayerViewModel): Completable {
        return Completable.create({ emitter ->
            Timber.d("drill should be deleted from db here!!!")
            getPlayerDBReference(player).ref.removeValue()
                    .addOnCompleteListener {
                        emitter.onComplete()
                    }
                    .addOnFailureListener {
                        emitter.onError(it)
                    }
        })
    }

    override fun update(player: PlayerViewModel, key: String): Completable {
        Timber.d("updating player: player")
        val databaseReference = getPlayerDBReference(player).ref
        val oldPlayer = mPlayersDBReference.child(key)
        val completable = RxFirebaseDatabase.setValue(databaseReference, player)
        val completable1 = RxFirebaseDatabase.setValue(oldPlayer, null)
        return completable.andThen(completable1)
    }

    private fun getPlayerDBReference(player: PlayerViewModel) = mPlayersDBReference.child(player.name)

    override fun findAll(): Maybe<MutableList<PlayerViewModel>> {
        return RxFirebaseDatabase.observeSingleValueEvent(mPlayersDBReference,
                DataSnapshotMapper.listOf(PlayerViewModel::class.java))
    }
}




