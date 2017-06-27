package hwp.basketball.mobility.login

import hwp.basketball.mobility.entitiy.user.UserRealmUserDataStore
import hwp.basketball.mobility.entitiy.user.CoachViewModel
import hwp.basketball.mobility.login.google.signin.SignInResultWrapper

/**
 * Created by dusan_cvetkovic on 3/23/17.
 */
interface LoginContract {
    interface View{
        fun displayLoggedUserName(name:String)
        fun displayError(error: String)
        fun startHomeActivity(user: String)
//        fun onBMUserLoaded(coachModel: CoachViewModel?)
    }
    interface Presenter{
        fun handleGoogleSignInResult(result: SignInResultWrapper?)
        fun loadBMUser(email: String)
        fun detach()
        fun loginWithUserPass(email: String, password: String)
    }

    interface Interactor{
//        fun login()
        fun handleSignInResult(result: SignInResultWrapper?, callbackListener: Callback)
        interface Callback {
            fun logInSuccess(email: String)
            fun logInFail(error: String)
        }
    }
}


