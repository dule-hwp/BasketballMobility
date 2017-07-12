package hwp.basketball.mobility.account.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.google.android.gms.auth.api.Auth
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.SignInButton
import com.google.android.gms.common.api.GoogleApiClient
import com.google.firebase.auth.FirebaseAuth
import hwp.basketball.mobility.HomeActivity
import hwp.basketball.mobility.R
import hwp.basketball.mobility.account.create.SignupActivity
import hwp.basketball.mobility.account.login.google.signin.SignInResultWrapper
import hwp.basketball.mobility.device.sensor.sensortile.sensortilescan.SensorTileScanActivity
import hwp.basketball.mobility.entitiy.user.UserFirebaseDataStore
import hwp.basketball.mobility.util.TestUtil
import hwp.basketball.mobility.util.toast
import kotlinx.android.synthetic.main.activity_login.*
import timber.log.Timber

class LoginActivity : AppCompatActivity(), GoogleApiClient.OnConnectionFailedListener, LoginContract.View {

    private var mAuth: FirebaseAuth? = null
    private var mAuthListener: FirebaseAuth.AuthStateListener? = null

//    override fun onBMUserLoaded(coachModel: CoachViewModel?) {}

    private var loginPresenter: LoginContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        mAuth = FirebaseAuth.getInstance()
        mAuthListener = FirebaseAuth.AuthStateListener {
            FirebaseAuth.AuthStateListener { firebaseAuth ->
                val user = firebaseAuth.currentUser
                if (user != null) {
                    // User is signed in
                    Timber.d("onAuthStateChanged:signed_in:" + user.uid)
                } else {
                    // User is signed out
                    Timber.d("onAuthStateChanged:signed_out")
                }
                // ...
            }

        }

        val userRepository = UserFirebaseDataStore()
        loginPresenter = LoginPresenter(this, userRepository)

        btn_google_login.setSize(SignInButton.SIZE_STANDARD)
        btn_google_login.setOnClickListener { onGooglLoginClicked() }

        btn_login.setOnClickListener { onUserPassLogin() }

        link_signup.setOnClickListener {
            val startIntent = SignupActivity.getStartIntent(this)
            startActivityForResult(startIntent, REQUEST_SIGNUP)
            finish()
            overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
        }
        animation_view.setImageAssetsFolder("images")
    }

    private fun onUserPassLogin() {
        loginPresenter?.loginWithUserPass(input_email.text.toString(), input_password.text.toString())
    }

    private var googleApiClient: GoogleApiClient? = null

    fun onGooglLoginClicked() {
        loginViaGoogle()
    }

    private fun loginViaGoogle() {
        if (googleApiClient == null) {
            val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                    .requestIdToken(getString(R.string.default_web_client_id))
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

    override fun onConnectionFailed(connectionResult: ConnectionResult) {
        connectionResult.errorMessage?.let {
            displayError(it)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GOOGLE_SIGN_IN && resultCode == Activity.RESULT_OK) {
            val result = Auth.GoogleSignInApi.getSignInResultFromIntent(data)
            loginPresenter?.handleGoogleSignInResult(SignInResultWrapper(result))
        } else if (requestCode == SensorTileScanActivity.REQUEST_SCAN) {
            if (resultCode == Activity.RESULT_OK) {
                Timber.d("onActivityResult() called with: requestCode = [$requestCode], resultCode = [$resultCode], data = [$data]")
                if (data != null && data.hasExtra(SensorTileScanActivity.NODE_TAG)) {
                    val nodeTag = data.getStringExtra(SensorTileScanActivity.NODE_TAG)
                    startDrillActivity(nodeTag)
                } else {
                    Timber.e("unsuccessful return tag")
                }
            }
        } else {
            Timber.e("onActivityResult: result from scan context not OK")
        }
    }

    companion object {
        //        private val TAG = "LoginActivity"
        val GOOGLE_SIGN_IN = 9001
        val REQUEST_SIGNUP = 9002

        fun getStartIntent(context: Context): Intent {
            val intent = Intent(context, LoginActivity::class.java)
            return intent
        }
    }

    override fun displayLoggedUserName(name: String) {
        Timber.d("displayLoggedUserName: " + name)
//        toast(name)
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

    override fun onStart() {
        super.onStart()
        val currentUser = mAuth?.currentUser
//        toast(currentUser.toString())
        currentUser?.email?.let { startHomeActivity("") }
        mAuthListener?.let { mAuth?.addAuthStateListener(it) }
    }

    override fun onStop() {
        super.onStop()
        mAuthListener?.let { mAuth?.removeAuthStateListener(it) }
    }

    fun onStraightToDrawClick(view: View) {
        startScanActivity()
    }

    private fun startDrillActivity(tag: String? = null) {
        val startIntent = TestUtil.getSkipToDrawIntent(tag, this)
        startActivity(startIntent)
    }

    fun startScanActivity() {
        val connect = Intent(this, SensorTileScanActivity::class.java)
        startActivityForResult(connect, SensorTileScanActivity.REQUEST_SCAN)
    }
}


