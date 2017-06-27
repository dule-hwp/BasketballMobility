package hwp.basketball.mobility.entitiy.player

/**
 * Created by dusan_cvetkovic on 3/26/17.
 */
data class PlayerViewModel(var firstName: String = "def",
                           var lastName: String = "def",
                           var height: String = "def",
                           var position: String = "def",
                           var imageUrl: String = "def",
                           var id: String = "def") {
    val name: String
        get() = "$lastName $firstName"
}