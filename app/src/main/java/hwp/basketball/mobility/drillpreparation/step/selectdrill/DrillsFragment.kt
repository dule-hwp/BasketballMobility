package hwp.basketball.mobility.drillpreparation.step.selectdrill

//import android.graphics.Point
import android.app.Activity
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
import hwp.basketball.mobility.drillpreparation.step.selectplayers.DrillsAdapter
import kotlinx.android.synthetic.main.fragment_drills.*
import timber.log.Timber
import javax.inject.Inject


/**
 * Created by dusan_cvetkovic on 3/23/17.
 */
class DrillsFragment : BaseStepFragment(), DrillsContract.View {

    @Inject
    lateinit var drillsPresenter: DrillsContract.Presenter

    @Inject
    lateinit var drillsAdapter: DrillsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        drillSetupComponent.inject(this)
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

    override fun displayError(s: String) {
        Timber.d("error " + s)
    }

    override fun onStepVisible() {

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
//                val pathPoints = data?.getParcelableArrayExtra(DrillActivity.EXTRA_PATH)
//                val drillImage = data?.getParcelableExtra<Bitmap>(DrillActivity.EXTRA_IMAGE)
//                val drillname = data?.getStringExtra(DrillActivity.EXTRA_NAME) ?: ""
                drillsPresenter.refreshData()


            }
        } else
            super.onActivityResult(requestCode, resultCode, data)

    }

    companion object {
        fun newInstance(): DrillsFragment {
            return DrillsFragment()
        }

        val REQUEST_CREATE_DRILL: Int = 100;
    }


}




