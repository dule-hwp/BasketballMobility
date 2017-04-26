package hwp.basketball.mobility.login

import hwp.basketball.mobility.entitiy.user.UserViewModel
import hwp.basketball.mobility.login.google.signin.SignInAccountWrapper
import hwp.basketball.mobility.login.google.signin.SignInResultWrapper
import org.junit.Before
import org.junit.Test
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.MockitoAnnotations

/**
 * Created by dusan_cvetkovic on 3/25/17.
 */
class GoogleLoginInteractorTest {
    @Mock
    private lateinit var mockListener: LoginContract.Interactor.Callback

    @Mock
    private lateinit var mockGoogleSignInWrapper: SignInResultWrapper

    @Mock
    private lateinit var mockAccount: SignInAccountWrapper

    private lateinit var googleLoginInteractor: GoogleLoginInteractor

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        googleLoginInteractor = GoogleLoginInteractor()
    }

    @Test
    fun setListener() {
    }

    @Test
    fun handleSignInResultNull() {
//        googleLoginInteractor.setListener(mockListener)
        googleLoginInteractor.handleSignInResult(null, mockListener)

        verify(mockListener).logInFail(anyString())
    }

    @Test
    fun handleSignInResultListenerNotSet() {
        googleLoginInteractor.handleSignInResult(null, mockListener)

        val mock = UserViewModel()
        verify(mockListener, never()).logInFail(anyString())
        verify(mockListener, never()).logInSuccess(mock)
    }

    @Test
    fun handleSignInResultSuccessAccountValid() {
//        googleLoginInteractor.setListener(mockListener)

        `when`(mockGoogleSignInWrapper.signInAccount).thenReturn(mockAccount)
        `when`(mockGoogleSignInWrapper.signInAccount.displayName).thenReturn("name")
        `when`(mockGoogleSignInWrapper.signInAccount.email).thenReturn("email")
        `when`(mockGoogleSignInWrapper.signInAccount.photoUrl).thenReturn("url")
        `when`(mockGoogleSignInWrapper.isSuccess).thenReturn(true)

        googleLoginInteractor.handleSignInResult(mockGoogleSignInWrapper, mockListener)

        verify(mockListener).logInSuccess(any())
        verify(mockListener, never()).logInFail(ArgumentMatchers.anyString())
    }

    @Test
    fun handleSignInResultFails() {
//        googleLoginInteractor.setListener(mockListener)

        `when`(mockGoogleSignInWrapper.signInAccount).thenReturn(mockAccount)
        `when`(mockGoogleSignInWrapper.isSuccess).thenReturn(false)

        googleLoginInteractor.handleSignInResult(mockGoogleSignInWrapper,mockListener)

        verify(mockListener, never()).logInSuccess(any())
        verify(mockListener).logInFail(anyString())
    }

}