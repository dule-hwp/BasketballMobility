package hwp.basketball.mobility.account.login

import hwp.basketball.mobility.account.login.google.signin.SignInResultWrapper

/**
 * This onterface defines login contract.
 * Presenter implementation is in charge of getting the data and dealing with events
 * View implementation is in charge of simply passing the events to presenter and displaying data
 * Interactor implementation handles sign in result and in forms
 * Created by dusan_cvetkovic on 3/23/17.
 */
interface LoginContract {
    interface View{
        /***/
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
        fun handleSignInResult(result: SignInResultWrapper?, callbackListener: Callback)
        interface Callback {
            fun logInSuccess(email: String)
            fun logInFail(error: String)
        }
    }
}


