package hwp.basketball.mobility.drillpreparation.step.connectplayers

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stepstone.stepper.VerificationError
import hwp.basketball.mobility.R
import hwp.basketball.mobility.drillpreparation.DrillSetupActivity
import hwp.basketball.mobility.drillpreparation.step.BaseStepFragment
import hwp.basketball.mobility.sensortilescan.ScanActivity
import hwp.basketball.mobility.sensortilescan.SensorsDialog
import timber.log.Timber
import javax.inject.Inject


/**
 * Created by dusan_cvetkovic on 3/23/17.
 */
class ConnectPlayersFragment : BaseStepFragment(), ConnectPlayersContract.View {

    @Inject
    lateinit var connectPlayersPresenter: ConnectPlayersContract.Presenter

    @Inject
    lateinit var playersAdapter: ConnectPlayersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        drillSetupComponent.inject(this)
        connectPlayersPresenter.setConnectPlayersAdapterView(playersAdapter)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_connect, container, false)
        return view
    }

    private var playersRecyclerView: RecyclerView? = null

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        connectPlayersPresenter.attach()
        playersRecyclerView = view?.findViewById(R.id.players_list) as RecyclerView
        setupRecyclerView()
    }

    override fun showConnectDialog() {
//        drillsDialog.showAddDrillDialog()
//        val snack = Snackbar.make(btnAdd, "opening add drill view", Snackbar.LENGTH_INDEFINITE)
//        snack.setAction("Dismiss") { snack.dismiss() }
//        snack.show()
    }

    override fun stepTitle(): String {
        return "Connect player"
    }

    override fun verifyStep(): VerificationError? {
        return connectPlayersPresenter.verifyStep()
    }

    override fun displayError(s: String) {
        Timber.d("error " + s)
    }

    fun setupRecyclerView() {
        playersRecyclerView?.layoutManager = LinearLayoutManager(activity)
        playersRecyclerView?.adapter = playersAdapter
    }

    override fun onStepVisible() {
        connectPlayersPresenter.refreshData()
    }

    override fun onDestroy() {
        super.onDestroy()
        playersRecyclerView?.adapter = null
        connectPlayersPresenter.detach()
    }

    companion object {
        fun newInstance(): ConnectPlayersFragment {
            return ConnectPlayersFragment()
        }
    }

    override fun startScanActivity() {
        val connect = Intent(activity, ScanActivity::class.java)
        startActivityForResult(connect, ScanActivity.REQUEST_SCAN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ScanActivity.REQUEST_SCAN) {
            if (resultCode == Activity.RESULT_OK) {
                Timber.d("onActivityResult() called with: requestCode = [$requestCode], resultCode = [$resultCode], data = [$data]")
                data?.let {
                    if (data.hasExtra(ScanActivity.NODE_TAG)) {
                        val nodeTag = data.getStringExtra(ScanActivity.NODE_TAG)
                        connectPlayersPresenter.onScanSuccessfulReturnTag(nodeTag)
                    } else {
                        connectPlayersPresenter.onScanSuccessfulReturnTag(null)
                    }
                }
            } else {
                Timber.d("onActivityResult: result from scan activity not OK")
                connectPlayersPresenter.onScanSuccessfulReturnTag(null)
            }
        }
    }

    override fun showSensorTypeChooser(firstName: String) {
        SensorsDialog(activity, connectPlayersPresenter, firstName).show()
    }

}




