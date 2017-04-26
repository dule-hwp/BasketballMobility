package hwp.basketball.mobility.entitiy.player

import io.reactivex.Single
import io.realm.Realm


/**
 * Created by dusan_cvetkovic on 3/26/17.
 */

class PlayerRealmRepository : PlayersDataStore {
    override fun findAll(): Single<List<PlayerViewModel>> {
        return Single.create<List<PlayerViewModel>> { emitter ->
            Realm.getDefaultInstance().use { realm ->
                val realmPlayers = realm.where(PlayerRealmModel::class.java).findAll()
                val modelViewPlayers = realmPlayers.map(::PlayerViewModel)
                emitter.onSuccess(modelViewPlayers)
            }
        }
    }

    override fun update(player: PlayerViewModel) {
        PlayerRealmModel()
        Realm.getDefaultInstance().use { realm ->
            realm.executeTransaction({
                realm.insertOrUpdate(PlayerRealmModel.fromViewModel(player))
            })
        }
    }

    override fun add(item: PlayerViewModel): Single<PlayerViewModel> {
        Realm.getDefaultInstance().use { realm ->
            realm.executeTransaction({
                val currentIdNum = realm.where(PlayerRealmModel::class.java).max(PlayerRealmModel.ID)
                val nextId: Int
                if (currentIdNum == null) {
                    nextId = 1
                } else {
                    nextId = currentIdNum.toInt() + 1
                }

                val playerRealmModel = realm.createObject(PlayerRealmModel::class.java, nextId)
                playerRealmModel.firstName = item.firstName
                playerRealmModel.heightInCm = item.height
                playerRealmModel.lastName = item.lastName
                playerRealmModel.position = item.imageUrl
                realm.insertOrUpdate(playerRealmModel)
                item.id=nextId
            })
            return Single.just(item)
        }

    }

    override fun remove(id: Int) {
        Realm.getDefaultInstance().use { realm ->
            realm?.executeTransaction {
                realm.where(PlayerRealmModel::class.java)
                        .equalTo(PlayerRealmModel.ID, id)
                        .findFirst()
                        .deleteFromRealm()
            }
        }
    }
}




