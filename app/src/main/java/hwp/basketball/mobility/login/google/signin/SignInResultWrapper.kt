package hwp.basketball.mobility.login.google.signin

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInResult

/**
 * Created by dusan_cvetkovic on 3/25/17.
 */
open class SignInResultWrapper(result: GoogleSignInResult) {
    val isSuccess: Boolean = result.isSuccess
    val signInAccount: SignInAccountWrapper = SignInAccountWrapper(result.signInAccount)
}

open class SignInAccountWrapper(account: GoogleSignInAccount?) {
    val displayName = account?.displayName ?: "N/A"
    val email = account?.email ?: "N/A"
    val photoUrl:String = account?.photoUrl?.toString() ?: "N/A"
}
