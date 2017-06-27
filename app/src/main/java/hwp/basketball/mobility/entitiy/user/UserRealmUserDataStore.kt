package hwp.basketball.mobility.entitiy.user

import io.reactivex.Completable
import io.reactivex.Single
//import io.realm.Realm


/**
 * Created by dusan_cvetkovic on 3/26/17.
 */

class UserRealmUserDataStore : UserDataStore<CoachViewModel> {
    override fun add(item: CoachViewModel): Completable {
        return Completable.error(Exception("addDrillToDatabase CoachModel not implemented"))
    }

    override fun findByEmail(email: String): Single<CoachViewModel>? {
        return Single.just(CoachViewModel())
    }

//    override fun addDrillToDatabase(item: CoachViewModel) : Completable {
//        return Completable.create { emitter ->
//            Realm.getDefaultInstance().use { realm ->
//                realm.executeTransaction({ realm ->
//                    try {
//                        val userRealmModel = realm.createObject(UserRealmModel::class.java)
//                        userRealmModel.username = item.username
//                        userRealmModel.email = item.email
//                        userRealmModel.imageUrl = item.imageUrl
//                        realm.insertOrUpdate(userRealmModel)
//                        emitter.onComplete()
//                    }
//                    catch (e :Exception){
//                        emitter.onError(e)
//                    }
//                })
//            }
//        }
//    }
//
//    override fun findByEmail(email: String): Single<CoachViewModel>? {
//        Realm.getDefaultInstance().use { realm ->
//            val realmResults = realm.where(UserRealmModel::class.java)
//                    .equalTo(UserRealmModel.EMAIL, email)
//                    .findFirst()
//            realmResults?.let {
//                val copyFromRealm = realm.copyFromRealm(realmResults)
//                return Single.just(copyFromRealm)
//                        .map(::CoachViewModel)
//            }
//            return null
//        }
//    }
}

