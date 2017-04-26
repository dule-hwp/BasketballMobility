package hwp.basketball.mobility.entitiy.user

/**
 * Created by dusan_cvetkovic on 3/26/17.
 */
data class UserViewModel(var username: String = "def",
                         var email: String = "def",
                         var imageUrl: String = "def") {

    constructor(realmModel: UserRealmModel) : this(
            username = realmModel.username,
            email = realmModel.email,
            imageUrl = realmModel.imageUrl)
}