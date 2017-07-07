package hwp.basketball.mobility.login

import com.google.firebase.auth.FirebaseAuth
import durdinapps.rxfirebase2.RxFirebaseAuth
import hwp.basketball.mobility.BasePresenter
import hwp.basketball.mobility.entitiy.user.UserDataStore
import hwp.basketball.mobility.entitiy.user.CoachViewModel
import hwp.basketball.mobility.login.google.signin.SignInResultWrapper
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by dusan_cvetkovic on 3/23/17.
 */

class LoginPresenter(private val view: LoginContract.View,
                     val coachDataStore: UserDataStore<CoachViewModel>)
    : LoginContract.Presenter, LoginContract.Interactor.Callback, BasePresenter {

    override fun loginWithUserPass(email: String, password: String) {

        RxFirebaseAuth.signInWithEmailAndPassword(FirebaseAuth.getInstance(), email, password)
                .map { authResult -> authResult.user != null }
                .subscribe({
                    loginCompleted()
                }, {
                    view.displayError("Auth error: "+ it.message)
                })
    }

    private var disposables: CompositeDisposable = CompositeDisposable()
    private val googleLoginInteractor: LoginContract.Interactor = GoogleLoginInteractor()

    override fun attach() {

    }

    override fun detach() {
        disposables.clear()
    }

    override fun loadBMUser(email: String) {
        val findByEmailObservable = coachDataStore.findByEmail(email)
        if (findByEmailObservable == null)
//            disposables.addDrillToDatabase(coachDataStore.addDrillToDatabase(email)
//                    .subscribe({
//                        Timber.d("added to user db")
//                        loginCompleted(email)
//                    },{ error ->
//                        Timber.e(error)
//                    })
//            )
            view.displayError("This account is not registered. Please Sign UP!!!")
        else
            disposables.add(findByEmailObservable
                    .subscribe({
                        userViewModel ->
                        loginCompleted()
                    }, {
                        view.displayError(it.message ?: "error message not avail")
                    })
            )
    }

    private fun loginCompleted() {
//        view.onBMUserLoaded(coachViewModel)
        view.startHomeActivity("")
    }

    override fun handleGoogleSignInResult(result: SignInResultWrapper?) {
        googleLoginInteractor.handleSignInResult(result, this)
    }

    override fun logInSuccess(email: String) {
        view.displayLoggedUserName(email)
//        firebaseAuthWithGoogle(coachViewModel)
//        loadBMUser(email)
        loginCompleted()
    }

    override fun logInFail(error: String) {
        view.displayError(error)
    }
}
