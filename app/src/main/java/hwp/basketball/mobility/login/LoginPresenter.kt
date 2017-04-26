package hwp.basketball.mobility.login

import hwp.basketball.mobility.BasePresenter
import hwp.basketball.mobility.entitiy.user.UserDataStore
import hwp.basketball.mobility.entitiy.user.UserRealmUserDataStore
import hwp.basketball.mobility.entitiy.user.UserViewModel
import hwp.basketball.mobility.login.google.signin.SignInResultWrapper
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber

/**
 * Created by dusan_cvetkovic on 3/23/17.
 */

class LoginPresenter(private val view: LoginContract.View,
                     val userDataStore: UserDataStore<UserViewModel>)
    : LoginContract.Presenter, LoginContract.Interactor.Callback, BasePresenter {

    private var disposables: CompositeDisposable = CompositeDisposable()
    private val googleLoginInteractor: LoginContract.Interactor = GoogleLoginInteractor()

    override fun attach() {

    }

    override fun detach() {
        disposables.clear()
    }

    override fun loadBMUser(userViewModel: UserViewModel) {
        val findByEmailObservable = userDataStore.findByEmail(userViewModel.email)
        if (findByEmailObservable == null)
            disposables.add(userDataStore.add(userViewModel)
                    .subscribe({
                        Timber.d("added to user db")
                        loginCompleted(userViewModel)
                    },{ error ->
                        Timber.e(error)
                    })
            )
        else
            disposables.add(findByEmailObservable
                    .subscribe({
                        userViewModel -> loginCompleted(userViewModel)
                    }, {
                        view.displayError(it.message ?: "error message not avail")
                    })
            )
    }

    private fun loginCompleted(userViewModel: UserViewModel?) {
        view.onBMUserLoaded(userViewModel)
        view.startHomeActivity("")
    }

    override fun handleGoogleSignInResult(result: SignInResultWrapper?) {
        googleLoginInteractor.handleSignInResult(result, this)
    }

    override fun logInSuccess(userViewModel: UserViewModel) {
        view.displayLoggedUserName(userViewModel.username)
        loadBMUser(userViewModel)
    }

    override fun logInFail(error: String) {
        view.displayError(error)
    }
}
