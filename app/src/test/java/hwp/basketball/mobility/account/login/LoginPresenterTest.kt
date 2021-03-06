package hwp.basketball.mobility.account.login

import hwp.basketball.mobility.account.login.google.signin.SignInResultWrapper
import hwp.basketball.mobility.entitiy.user.CoachViewModel
import hwp.basketball.mobility.entitiy.user.UserFirebaseDataStore
import io.reactivex.Maybe
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

/**
 * Created by dusan_cvetkovic on 3/23/17.
 */

class LoginPresenterTest {
    @Mock
    private lateinit var mockView: LoginContract.View
    @Mock
    private lateinit var mockGoogleLoginInteractor: LoginContract.Interactor
    @Mock
    private lateinit var mockGoogleSigninResult: SignInResultWrapper
    @Mock
    private lateinit var userRepository: UserFirebaseDataStore

    val userModel = CoachViewModel()

    @Before
    internal fun setUp() {

        MockitoAnnotations.initMocks(this)
        loginPresenter = LoginPresenter(view = mockView,
                coachDataStore = userRepository)
//        verify(mockGoogleLoginInteractor).setListener(loginPresenter)
    }

    private lateinit var loginPresenter: LoginPresenter

    @Test
    @Throws(Exception::class)
    fun handleActivityResultCalled() {
        mock(SignInResultWrapper::class.java)

        loginPresenter.handleGoogleSignInResult(mockGoogleSigninResult)

        verify(mockGoogleLoginInteractor)?.handleSignInResult(mockGoogleSigninResult, loginPresenter)
    }

    @Test
    @Throws(Exception::class)
    fun handleSignInresultFail() {
        `when`(mockGoogleLoginInteractor.handleSignInResult(null, loginPresenter)).thenAnswer {
            loginPresenter.logInFail("error")
        }

        loginPresenter.handleGoogleSignInResult(null)

        verify(mockView)?.displayError(anyString())
        verify(mockView, never())?.displayLoggedUserName(anyString())
    }

    @Test
    @Throws(Exception::class)
    fun handleSignInResultSuccess() {

        `when`(mockGoogleLoginInteractor.handleSignInResult(null, loginPresenter)).thenAnswer {
            loginPresenter.logInSuccess(userModel.email!!)
        }

        loginPresenter.handleGoogleSignInResult(null)

        verify(mockView)?.displayLoggedUserName(anyString())
//        verify(mockView)?.startHomeActivity(anyString())
        verify(mockView, never())?.displayError(anyString())
    }

    @Test
    fun handleLoginSuccessNull() {
//        loginPresenter.logInSuccess(null)

//        verify(mockView)?.displayError(anyString())
    }

    @Test
    fun handleLoginSuccessNotNul() {
        val displayName = "username"
        loginPresenter.logInSuccess(userModel.email!!)

        verify(mockView)?.displayLoggedUserName(displayName)
    }

    @Test
    fun loadBMUserFound() {
        val email = "test@test.com"

        `when`(userRepository.findByEmail(email))
                .thenReturn(Maybe.just(userModel))

        loginPresenter.loadBMUser(userModel.email!!)

//        verify(mockView)?.onBMUserLoaded(userModel)
    }

    @Test
    fun loadBMUserNotFound() {
        val email = "test@test.com"

        `when`(userRepository.findByEmail(email))
                .thenReturn(Maybe.just(userModel))

        loginPresenter.loadBMUser(userModel.email!!)

//        verify(mockView, never())?.onBMUserLoaded(any())
        verify(mockView)?.displayError(ArgumentMatchers.anyString())
    }

    @Test
    fun loadBMUserThrowIllegal() {
        val email = "test@test.com"

        `when`(userRepository.findByEmail(email))
                .thenReturn(Maybe.error(IllegalArgumentException("illegal args")))

        loginPresenter.loadBMUser(userModel.email!!)

//        verify(mockView, never())?.onBMUserLoaded(any())
        verify(mockView)?.displayError(ArgumentMatchers.anyString())
    }

}

