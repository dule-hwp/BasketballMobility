package hwp.basketball.mobility.drill.display

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.widget.Toolbar
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.squareup.picasso.Picasso

import hwp.basketball.mobility.R
import hwp.basketball.mobility.entitiy.drills.outcomes.DrillOutcome
import kotlinx.android.synthetic.main.activity_drill_detail.*

/**
 * An activity representing a single Drill detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a [DrillListActivity].
 */
class DrillDetailActivity : AppCompatActivity() {

    companion object {
        fun getStartIntent(context: Context, drillOutcome: DrillOutcome): Intent {
            val intent = Intent(context, DrillDetailActivity::class.java)
            intent.putExtra(DRILL_EXTRA, drillOutcome)
            return intent
        }

        val DRILL_EXTRA = "drill"
    }

    private var drillOutcome: DrillOutcome? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drill_detail)
        drillOutcome = intent.getParcelableExtra<DrillOutcome>(DRILL_EXTRA)
        initViews()

    }

    private fun initViews() {
        drillOutcome?.let { drillOutcome ->
            tv_area.text = drillOutcome.pathArea.toString()
            tv_date_value.text = drillOutcome.getDateWithoutZone()
            tv_length.text = drillOutcome.pathLength.toString()
            tv_name_value.text = drillOutcome.playerName
            tv_score_value.text = drillOutcome.score.toString()

            title = "Drill: ${drillOutcome.drillName}"

            Picasso.with(this).load(drillOutcome.drillOutcomeImage).into(iv_drill_outcome)
            Picasso.with(this).load(drillOutcome.drillOutcomeImageArea).into(iv_drill_outcome_error)
        }

    }

    override fun onResume() {
        super.onResume()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        if (id == android.R.id.home) {
            // This ID represents the Home or Up button. In the case of this
            // activity, the Up button is shown. For
            // more details, see the Navigation pattern on Android Design:
            //
            // http://developer.android.com/design/patterns/navigation.html#up-vs-back
            //
            navigateUpTo(Intent(this, DrillListActivity::class.java))
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
