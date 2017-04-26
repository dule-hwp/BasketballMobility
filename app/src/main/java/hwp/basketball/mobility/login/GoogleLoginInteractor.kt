package hwp.basketball.mobility.login

import hugo.weaving.DebugLog
import hwp.basketball.mobility.entitiy.user.UserViewModel
import hwp.basketball.mobility.login.google.signin.SignInResultWrapper

/**
 * Created by dusan_cvetkovic on 3/24/17.
 */

open class GoogleLoginInteractor : LoginContract.Interactor {

    @DebugLog
    override fun handleSignInResult(result: SignInResultWrapper?, callbackListener: LoginContract.Interactor.Callback) {
        if (result == null) {
            callbackListener.logInFail("result is null")
            return
        }
        if (result.isSuccess) {
            // Signed in successfully, show authenticated UI.
            val acct = result.signInAccount
            val userViewModel = UserViewModel(username = acct.displayName,
                    email = acct.email,
                    imageUrl = acct.photoUrl)
            callbackListener.logInSuccess(userViewModel)
        } else {
            callbackListener.logInFail("Sign in failed.")
        }
    }
}
