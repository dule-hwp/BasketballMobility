package hwp.basketball.mobility

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import hwp.basketball.mobility.drill.display.DrillDetailActivity
import hwp.basketball.mobility.drill.display.DrillListActivity
import hwp.basketball.mobility.drillpreparation.DrillSetupActivity
import hwp.basketball.mobility.login.LoginActivity
import hwp.basketball.mobility.sensortilescan.ScanActivity
import hwp.basketball.mobility.util.TestUtil
import kotlinx.android.synthetic.main.activity_home.*
import timber.log.Timber


/**
 *
 * Created by dusan_cvetkovic on 3/27/17.
 */
class HomeActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        title = "Home"
        btnPlayers.setOnClickListener({ startPlayersListActivity() })
        logOut.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            startActivity(LoginActivity.getStartIntent(this))
            finish()
        }
    }

    private fun startPlayersListActivity() {
        val intent = DrillSetupActivity.getStartIntent(this)
        startActivity(intent)
    }

    fun startScanActivity() {
        val connect = Intent(this, ScanActivity::class.java)
        startActivityForResult(connect, ScanActivity.REQUEST_SCAN)
    }

    fun onHomeStraightToDrawClick(view: View) {
        startScanActivity()
    }

    fun onPastDrillsClick(view: View) {
        val startIntent = DrillListActivity.getStartIntent(this)
        startActivity(startIntent)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == ScanActivity.REQUEST_SCAN) {
            if (resultCode == Activity.RESULT_OK) {
                Timber.d("onActivityResult() called with: requestCode = [$requestCode], resultCode = [$resultCode], data = [$data]")
                if (data != null && data.hasExtra(ScanActivity.NODE_TAG)) {
                    val nodeTag = data.getStringExtra(ScanActivity.NODE_TAG)
                    startDrillActivity(nodeTag)
                } else {
                    Timber.e("unsuccessful return tag")
                }
            }
        } else {
            Timber.e("onActivityResult: result from scan context not OK")
        }
    }

    private fun startDrillActivity(tag: String? = null) {
        val startIntent = TestUtil.getSkipToDrawIntent(tag, this)
        startActivity(startIntent)
    }


}