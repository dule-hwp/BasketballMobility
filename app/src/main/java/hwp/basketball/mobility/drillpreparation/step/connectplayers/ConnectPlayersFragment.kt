package hwp.basketball.mobility.drillpreparation.step.connectplayers

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stepstone.stepper.VerificationError
import hwp.basketball.mobility.R
import hwp.basketball.mobility.device.sensor.SensorFactory
import hwp.basketball.mobility.device.sensor.wicedsense.WicedSenseSensor
import hwp.basketball.mobility.device.sensor.wicedsense.ws_bs.BluetoothEnabler
import hwp.basketball.mobility.drillpreparation.step.BaseStepFragment
import hwp.basketball.mobility.device.sensor.sensortile.sensortilescan.SensorTileScanActivity
import hwp.basketball.mobility.device.sensor.sensortile.sensortilescan.SensorsDialog
import timber.log.Timber


/**
 * Player connect step.
 * View being shown in preparation drill process when coach connects all the selected players.
 */
class ConnectPlayersFragment : BaseStepFragment(), ConnectPlayersContract.View {
    override fun startWicedActivityScan() {
        val sensor = SensorFactory.getSensor(SensorFactory.Type.WICED_SENSE_SENSOR, this.activity) as WicedSenseSensor
        sensor.connectTo("")
    }

    lateinit var connectPlayersPresenter: ConnectPlayersContract.Presenter
    lateinit var playersAdapter: ConnectPlayersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        playersAdapter = ConnectPlayersAdapter()
        connectPlayersPresenter = ConnectPlayersPresenter(this)
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

    override fun stepTitle(): String {
        return "Connect player"
    }

    override fun verifyStep(): VerificationError? {
        return connectPlayersPresenter.verifyStep()
    }

    override fun displayError(errorMessage: String) {
        Timber.d("error " + errorMessage)
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

    override fun startSensorTileScanActivity() {
        val connect = Intent(activity, SensorTileScanActivity::class.java)
        startActivityForResult(connect, SensorTileScanActivity.REQUEST_SCAN)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == SensorTileScanActivity.REQUEST_SCAN) {
            if (resultCode == Activity.RESULT_OK) {
                Timber.d("onActivityResult() called with: requestCode = [$requestCode], resultCode = [$resultCode], data = [$data]")
                data?.let {
                    if (data.hasExtra(SensorTileScanActivity.NODE_TAG)) {
                        val nodeTag = data.getStringExtra(SensorTileScanActivity.NODE_TAG)
                        connectPlayersPresenter.onScanSuccessfulReturnTag(nodeTag)
                    } else {
                        connectPlayersPresenter.onScanSuccessfulReturnTag(null)
                    }
                }
            } else {
                Timber.d("onActivityResult: result from scan context not OK")
                connectPlayersPresenter.onScanSuccessfulReturnTag(null)
            }
        } else if (requestCode == BluetoothEnabler.REQUEST_ENABLE_BT) {
            if (!BluetoothAdapter.getDefaultAdapter().isEnabled) {
                Timber.e("exitApp()")
                return;
            }
//            initResourcesAndResume();
        }
    }

    override fun showSensorTypeChooser(firstName: String) {
        SensorsDialog(activity, connectPlayersPresenter, firstName).show()
    }

}




