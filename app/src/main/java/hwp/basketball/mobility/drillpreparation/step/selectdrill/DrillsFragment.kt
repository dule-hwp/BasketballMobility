package hwp.basketball.mobility.drillpreparation.step.selectdrill

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stepstone.stepper.VerificationError
import hwp.basketball.mobility.R
import hwp.basketball.mobility.drill.create.DrillActivity
import hwp.basketball.mobility.drillpreparation.step.BaseStepFragment
import hwp.basketball.mobility.util.toast
import kotlinx.android.synthetic.main.fragment_drills.*
import timber.log.Timber

/**
 * Drill select step.
 * View being shown in preparation drill process when coach selects drill.
 */
class DrillsFragment : BaseStepFragment(), DrillsContract.View {

    lateinit var drillsPresenter: DrillsContract.Presenter

    lateinit var drillsAdapter: DrillsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        drillsPresenter = DrillsPresenter(this)
        drillsAdapter = DrillsAdapter()
        drillsPresenter.setDrillAdapterView(drillsAdapter)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_drills, container, false)
        return view
    }

    private var drillsRecyclerView: RecyclerView? = null

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        drillsPresenter.attach()
        drillsRecyclerView = view?.findViewById(R.id.drills_list) as RecyclerView
        btnAdd.setOnClickListener { onAddClickListener() }
        setupDrillsRecyclerView()
        setupHideAddButtonBehaviour(btnAdd, drillsRecyclerView)
    }

    private fun onAddClickListener() {
        startActivityForResult(DrillActivity.getStartIntent(activity), REQUEST_CREATE_DRILL)
    }

    override fun stepTitle(): String {
        return "Select drill"
    }

    override fun verifyStep(): VerificationError? {
        return drillsPresenter.verifyStep()
    }

    override fun displayError(errorMessage: String) {
        Timber.e("error " + errorMessage)
        toast(errorMessage)
    }

    override fun onStepVisible() {

    }

    private var progress: ProgressDialog? = null

    override fun hideProgressDialog() {
        progress?.dismiss()
    }

    override fun showProgressDialog(message: String) {
        progress?.dismiss()
        progress = ProgressDialog.show(context, "Loading...", message, true)
    }

    fun setupDrillsRecyclerView() {
        drillsRecyclerView?.layoutManager = LinearLayoutManager(activity)
        drillsRecyclerView?.adapter = drillsAdapter
    }

    override fun onDestroy() {
        super.onDestroy()
        drillsRecyclerView?.adapter = null
        drillsPresenter.detach()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CREATE_DRILL) {
            if (resultCode == Activity.RESULT_OK) {
                drillsPresenter.refreshData()
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    companion object {
        fun newInstance(): DrillsFragment {
            return DrillsFragment()
        }

        val REQUEST_CREATE_DRILL: Int = 100
    }
}




