package hwp.basketball.mobility.login

import hwp.basketball.mobility.entitiy.user.UserRealmUserDataStore
import hwp.basketball.mobility.entitiy.user.UserViewModel
import hwp.basketball.mobility.login.google.signin.SignInResultWrapper

/**
 * Created by dusan_cvetkovic on 3/23/17.
 */
interface LoginContract {
    interface View{
        fun displayLoggedUserName(name:String)
        fun displayError(error: String)
        fun startHomeActivity(user: String)
        fun onBMUserLoaded(userModel: UserViewModel?)
    }
    interface Presenter{
        fun handleGoogleSignInResult(result: SignInResultWrapper?)
        fun loadBMUser(userViewModel: UserViewModel)
        fun detach()
    }

    interface Interactor{
//        fun login()
        fun handleSignInResult(result: SignInResultWrapper?, callbackListener: Callback)
        interface Callback {
            fun logInSuccess(userViewModel: UserViewModel)
            fun logInFail(error: String)
        }
    }
}


