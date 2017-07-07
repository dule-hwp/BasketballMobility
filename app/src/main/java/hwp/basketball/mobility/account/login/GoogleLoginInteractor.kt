package hwp.basketball.mobility.login

import hwp.basketball.mobility.login.google.signin.AuthCallback
import hwp.basketball.mobility.login.google.signin.SignInAccountWrapper
import hwp.basketball.mobility.login.google.signin.SignInResultWrapper


/**
 *
 * Created by dusan_cvetkovic on 3/24/17.
 */

open class GoogleLoginInteractor : LoginContract.Interactor {

    override fun handleSignInResult(result: SignInResultWrapper?, callbackListener: LoginContract.Interactor.Callback) {
        if (result == null) {
            callbackListener.logInFail("result is null")
            return
        }
        if (result.isSuccess) {
            result.authenticate(object : AuthCallback {
                override fun onFailed() {
                    callbackListener.logInFail("Firebase auth failed.")
                }

                override fun onSuccess(signInAccount: SignInAccountWrapper) {
                    // Signed in successfully, show authenticated UI.
//                    val acct = signInAccount
//                    val userViewModel = CoachViewModel(signInAccount.displayName,
//                            signInAccount.email,
//                            signInAccount.photoUrl)
                    callbackListener.logInSuccess(signInAccount.email)
                }
            })
        } else {
            callbackListener.logInFail("Sign in failed.")
        }
    }
}
