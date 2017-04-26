package hwp.basketball.mobility.entitiy.user

import io.realm.RealmObject

/**
 * Created by dusan_cvetkovic on 3/26/17.
 */
open class UserRealmModel(
        var username: String = "",
        var email: String = "",
        var imageUrl: String = ""
) : RealmObject() {

    companion object Fields {
        val ID: String = "id"
        val EMAIL: String = "email"

    }
}