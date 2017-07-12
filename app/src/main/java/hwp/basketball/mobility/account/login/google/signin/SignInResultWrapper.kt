package hwp.basketball.mobility.account.login.google.signin

import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import timber.log.Timber

/**
 * Created by dusan_cvetkovic on 3/25/17.
 */
open class SignInResultWrapper(val result: GoogleSignInResult) {
    val isSuccess: Boolean = result.isSuccess
    val signInAccount: SignInAccountWrapper = SignInAccountWrapper(result.signInAccount)

    fun authenticate(callback: AuthCallback) {
        if (result.signInAccount == null)
            callback.onFailed()
        else
            firebaseAuthWithGoogle(result.signInAccount!!, callback)
    }

    private fun firebaseAuthWithGoogle(googleSignInAccount: GoogleSignInAccount, callback: AuthCallback) {
        val mAuth = FirebaseAuth.getInstance()
        Timber.d("firebaseAuthWithGoogle:" + googleSignInAccount.id)

        val credential = GoogleAuthProvider.getCredential(googleSignInAccount.idToken, null)
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener({ task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Timber.d("signInWithCredential:success")
                        val user = mAuth.currentUser
                        callback.onSuccess(signInAccount)
//                        updateUI(user)
                    } else {
                        // If sign in fails, display a message to the user.
                        Timber.w("signInWithCredential:failure", task.exception)
                        callback.onFailed()
//                        Toast.makeText(this@LoginActivity, "Authentication failed.",
//                                Toast.LENGTH_SHORT).show()
//                        updateUI(null)
                    }
                    // ...
                })
    }

}

interface AuthCallback {
    fun onFailed()
    fun onSuccess(signInAccount: SignInAccountWrapper)

}

open class SignInAccountWrapper(account: GoogleSignInAccount?) {
    val displayName = account?.displayName ?: "N/A"
    val email = account?.email ?: "N/A"
    val photoUrl: String = account?.photoUrl?.toString() ?: "N/A"
}
