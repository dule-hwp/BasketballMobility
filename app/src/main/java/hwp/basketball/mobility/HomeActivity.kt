package hwp.basketball.mobility

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import hwp.basketball.mobility.drillpreparation.DrillSetupActivity
import hwp.basketball.mobility.drillpreparation.step.selectplayers.PlayersFragment
import kotlinx.android.synthetic.main.activity_home.*

/**
 * Created by dusan_cvetkovic on 3/27/17.
 */
class HomeActivity : AppCompatActivity() {

    companion object{
        fun getStartIntent(context: Context) : Intent {
            return Intent(context, HomeActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        title = "Home"
        btnPlayers.setOnClickListener({ startPlayersListActivity() })
    }

    private fun startPlayersListActivity() {
        val intent = DrillSetupActivity.getStartIntent(this)
        startActivity(intent)
    }
}