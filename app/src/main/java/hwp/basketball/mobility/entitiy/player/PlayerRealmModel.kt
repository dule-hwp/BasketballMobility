package hwp.basketball.mobility.entitiy.player

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

/**
 * Created by dusan_cvetkovic on 3/26/17.
 */
open class PlayerRealmModel(
        @PrimaryKey
        var _id: Int = -1,
        var firstName: String = "",
        var lastName: String = "",
        var position: String = "",
        var heightInCm: String = "",
        var photoUrl: String = ""
) : RealmObject() {


    companion object Fields {
        val ID: String = "_id"
        fun fromViewModel(player: PlayerViewModel): PlayerRealmModel {
            return PlayerRealmModel(_id = player.id,
                    firstName = player.firstName,
                    position = player.position,
                    lastName = player.lastName,
                    heightInCm = player.height,
                    photoUrl = player.imageUrl)
        }
    }
}