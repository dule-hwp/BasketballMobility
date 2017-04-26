package hwp.basketball.mobility.entitiy.player

/**
 * Created by dusan_cvetkovic on 3/26/17.
 */
data class PlayerViewModel(var firstName: String = "def",
                           var lastName: String = "def",
                           var height: String = "def",
                           var position: String = "def",
                           var imageUrl: String = "def",
                           var id: Int = 0
) {

    constructor(realmModel: PlayerRealmModel) : this(
            firstName = realmModel.firstName,
            lastName = realmModel.lastName,
            imageUrl = realmModel.photoUrl,
            position = realmModel.position,
            height = realmModel.heightInCm,
            id = realmModel._id

    )
}