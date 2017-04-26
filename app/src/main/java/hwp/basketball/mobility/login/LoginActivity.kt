package hwp.basketball.mobility.login

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.GoogleApiClient
import hugo.weaving.DebugLog
import hwp.basketball.mobility.HomeActivity
import hwp.basketball.mobility.R
import hwp.basketball.mobility.entitiy.user.UserRealmUserDataStore
import hwp.basketball.mobility.entitiy.user.UserViewModel
import hwp.basketball.mobility.login.GoogleLoginInteractor
import hwp.basketball.mobility.login.LoginContract
import hwp.basketball.mobility.login.LoginPresenter
import hwp.basketball.mobility.login.google.signin.SignInResultWrapper
import hwp.basketball.mobility.pathrecorder.PathRecorderActivity
import kotlinx.android.synthetic.main.activity_login.*
import timber.log.Timber

class LoginActivity : AppCompatActivity(), GoogleApiClient.OnConnectionFailedListener, LoginContract.View {

    override fun onBMUserLoaded(userModel: UserViewModel?) {
//        toast(userModel.toString())
    }

    private var loginPresenter: LoginContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val userRepository = UserRealmUserDataStore()
        loginPresenter = LoginPresenter(this, userRepository)

        btn_login.setSize(SignInButton.SIZE_STANDARD)
        btn_login.setOnClickListener { onGooglLoginClicked() }
    }

    private var googleApiClient: GoogleApiClient? = null

    fun onGooglLoginClicked() {

        loginViaGoogle()
    }

    private fun loginViaGoogle() {
        if (googleApiClient == null) {
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestEmail()
                    .build()

            googleApiClient = GoogleApiClient.Builder(this)
                    .enableAutoManage(this, this)
                    .addApi(Auth.GOOGLE_SIGN_IN_API, gso)
                    .build()
        }

        val signInIntent = Auth.GoogleSignInApi.getSignInIntent(googleApiClient)
        startActivityForResult(signInIntent, GOOGLE_SIGN_IN)
    }

    @DebugLog
    override fun onConnectionFailed(connectionResult: ConnectionResult) {
        connectionResult.errorMessage?.let {
            displayError(it)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GOOGLE_SIGN_IN && resultCode == Activity.RESULT_OK) {
            val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
            loginPresenter?.handleGoogleSignInResult(SignInResultWrapper(result))
        }
    }

    companion object {
//        private val TAG = "LoginActivity"
        val GOOGLE_SIGN_IN = 9001
    }

    override fun displayLoggedUserName(name: String) {
        Timber.d("displayLoggedUserName: " + name)
        toast(name)
    }

    override fun displayError(error: String) {
        Timber.d("displayError: " + error)
        toast(error)
    }

    override fun startHomeActivity(user: String) {
        val startIntent = HomeActivity.getStartIntent(this)
        startActivity(startIntent)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        loginPresenter?.detach()
    }

    private fun AppCompatActivity.toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    fun onStraightToDrawClick(view: View){
        val startIntent = PathRecorderActivity.getStartIntent(this, "test")
        startActivity(startIntent)
    }
}



