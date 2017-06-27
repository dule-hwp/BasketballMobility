package hwp.basketball.mobility.drill.display

import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup

import hwp.basketball.mobility.R

import hwp.basketball.mobility.drill.display.dummy.DummyContent
import hwp.basketball.mobility.entitiy.drills.DrillViewModel
import hwp.basketball.mobility.entitiy.drills.outcomes.DrillOutcome
import hwp.basketball.mobility.util.toast
import kotlinx.android.synthetic.main.activity_drill_list.*
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

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        expendable_drill_list.layoutManager = LinearLayoutManager(this)
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
                    it as ExpandableGroup<DrillOutcome> }
                .toMutableList()
        val adapter = DrillsAdapter(toMutableList)
        expendable_drill_list.adapter = adapter
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

    inner class SimpleItemRecyclerViewAdapter(private val mValues: List<DummyContent.DummyItem>) : RecyclerView.Adapter<SimpleItemRecyclerViewAdapter.ViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.drill_list_content, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.mItem = mValues[position]
            holder.mIdView.text = mValues[position].id
            holder.mContentView.text = mValues[position].content

            holder.mView.setOnClickListener { v ->
                if (mTwoPane) {
                    val arguments = Bundle()
                    arguments.putString(DrillDetailFragment.ARG_ITEM_ID, holder.mItem?.id)
                    val fragment = DrillDetailFragment()
                    fragment.arguments = arguments
                    supportFragmentManager.beginTransaction()
                            .replace(R.id.drill_detail_container, fragment)
                            .commit()
                } else {
                    val context = v.context
                    val intent = Intent(context, DrillDetailActivity::class.java)
                    intent.putExtra(DrillDetailFragment.ARG_ITEM_ID, holder.mItem?.id)

                    context.startActivity(intent)
                }
            }
        }

        override fun getItemCount(): Int {
            return mValues.size
        }

        inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
            val mIdView: TextView
            val mContentView: TextView
            var mItem: DummyContent.DummyItem? = null

            init {
                mIdView = mView.findViewById(R.id.id) as TextView
                mContentView = mView.findViewById(R.id.content) as TextView
            }

            override fun toString(): String {
                return super.toString() + " '" + mContentView.text + "'"
            }
        }
    }
}
