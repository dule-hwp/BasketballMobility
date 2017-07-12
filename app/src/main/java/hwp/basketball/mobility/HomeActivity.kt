package hwp.basketball.mobility

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import com.google.firebase.auth.FirebaseAuth
import hwp.basketball.mobility.drill.display.DrillListActivity
import hwp.basketball.mobility.drillpreparation.DrillSetupActivity
import hwp.basketball.mobility.account.login.LoginActivity
import hwp.basketball.mobility.device.sensor.sensortile.sensortilescan.SensorTileScanActivity
import hwp.basketball.mobility.util.TestUtil
import kotlinx.android.synthetic.main.activity_home.*
import timber.log.Timber


/**
 *
 * Created by dusan_cvetkovic on 3/27/17.
 */
class HomeActivity : AppCompatActivity() {

    companion object {
        /**
         * Static method for creating start activity intent.
         *
         * @param context Context used for starting intent.
         * @return Intent needed for starting [HomeActivity]
         * */
        fun getStartIntent(context: Context): Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }

    /**Initialize and attach listeners to views. */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        title = "Home"
        btn_start_drill.setOnClickListener({ startPrepareDrillActivity() })
    }

    /**The process of running the drill starts with drill setup.
     * Herew we start the drill.*/
    private fun startPrepareDrillActivity() {
        val intent = DrillSetupActivity.getStartIntent(this)
        startActivity(intent)
    }

    /** Starting the BLE scan for SensorTile activity.
     * The reason why we put this here and not in SensorTileSensor implementation is because
     * we want to be able to check activity result and see what user selected.*/
    fun startScanForSTActivity() {
        val connect = Intent(this, SensorTileScanActivity::class.java)
        startActivityForResult(connect, SensorTileScanActivity.REQUEST_SCAN)
    }

    /**@suppress*/
    fun onHomeStraightToDrawClick(view: View) {
        startScanForSTActivity()
    }

    /**
     * Starts the activity where you can see all the past performed drills with results and images.
     * This method is linked via .xml code.
     * */
    fun onPastDrillsClick(view: View) {
        val startIntent = DrillListActivity.getStartIntent(this)
        startActivity(startIntent)
    }

    /**@suppress
     *
     * Used only for testing when skip to draw btn visible.
     * */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == SensorTileScanActivity.REQUEST_SCAN) {
            if (resultCode == Activity.RESULT_OK) {
                Timber.d("onActivityResult() called with: " +
                        "requestCode = [$requestCode], resultCode = [$resultCode], data = [$data]")
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

    /**@suppress
     *
     * Used only for testing when skip to draw btn visible.
     * */
    private fun startDrillActivity(tag: String? = null) {
        val startIntent = TestUtil.getSkipToDrawIntent(tag, this)
        startActivity(startIntent)
    }

    /**
     * Populating the options menu with logout button.
     * */
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    /**
     * Handling logout functionality.
     *
     * Calling Firebase Auth logout and finishing activity
     * */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        if (id == R.id.action_logout) {
            //should call presenter logout and logout depending on used back end
            FirebaseAuth.getInstance().signOut()
            startActivity(LoginActivity.getStartIntent(this))
            finish()
            return true
        }

        return super.onOptionsItemSelected(item)
    }

}