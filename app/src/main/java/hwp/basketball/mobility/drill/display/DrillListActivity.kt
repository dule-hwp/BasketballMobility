package hwp.basketball.mobility.drill.display

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import hwp.basketball.mobility.R
import hwp.basketball.mobility.entitiy.drills.DrillViewModel
import hwp.basketball.mobility.entitiy.drills.outcomes.DrillOutcome
import hwp.basketball.mobility.util.toast
import kotlinx.android.synthetic.main.drill_list.*

/**
 * An activity representing a list of Drills. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a [DrillDetailActivity] representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
class DrillListActivity : AppCompatActivity(), DrillListActivityContract.View {

    companion object {
        fun getStartIntent(context: Context): Intent {
            return Intent(context, DrillListActivity::class.java)
        }
    }

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private var mTwoPane: Boolean = false

    private val presenter: DrillListActivityContract.Presenter by lazy {
        DrillListActivityPresenter(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drill_list)

        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        toolbar.title = title

        expendable_drill_list.layoutManager = LinearLayoutManager(this)

        val dividerItemDecoration = DividerItemDecoration(expendable_drill_list.context,
                DividerItemDecoration.VERTICAL)
        expendable_drill_list.addItemDecoration(dividerItemDecoration)
        presenter.fetchDrills()

        if (findViewById(R.id.drill_detail_container) != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            mTwoPane = true
        }
    }

    override fun onDrillsFetched(drills: MutableList<DrillViewModel>) {
        val toMutableList = drills
                .map {
                    it.populateItems()
                    it as ExpandableGroup<DrillOutcome>
                }
                .toMutableList()
        val adapter = DrillsAdapter(toMutableList, presenter)
        expendable_drill_list.adapter = adapter
    }

    override fun showDrillDetailedView(drillOutcome: DrillOutcome) {
        val startIntent = DrillDetailActivity.getStartIntent(this, drillOutcome)
        startActivity(startIntent)
    }

    private var progressDialog: ProgressDialog? = null

    override fun showProgressDialog(message: String) {
        progressDialog?.dismiss()
        progressDialog = ProgressDialog.show(this, "Loading...", message)
    }

    override fun hideProgressDialog() {
        progressDialog?.dismiss()
    }

    override fun showErrorMessage(message: String) {
        toast(message)
    }

}
