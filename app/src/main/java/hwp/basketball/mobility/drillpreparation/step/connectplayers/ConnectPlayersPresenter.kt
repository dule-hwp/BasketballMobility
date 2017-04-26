package hwp.basketball.mobility.drillpreparation.step.connectplayers

import com.stepstone.stepper.VerificationError
import hwp.basketball.mobility.dagger.DrillSetupActivityScope
import hwp.basketball.mobility.device.sensor.BaseSensor
import hwp.basketball.mobility.drillpreparation.step.DrillSetupOutput
import hwp.basketball.mobility.entitiy.player.PlayerViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

/**
 * Created by dusan_cvetkovic on 4/4/17.
 *
 */
@DrillSetupActivityScope
class ConnectPlayersPresenter @Inject constructor(val view: ConnectPlayersContract.View)
    : ConnectPlayersContract.Presenter, ConnectPlayersContract.AdapterViewCallback{

    private var connectPlayersAdapterView: ConnectPlayersContract.AdapterView? = null
    private var selectedDrill: PlayerViewModel? = null
    private lateinit var compositeDisposable: CompositeDisposable
    private var connectingPlayerViewModel: PlayerViewModel? = null
    private var connectingPlayerViewModelPosition: Int = -1

    override fun setConnectPlayersAdapterView(view: ConnectPlayersContract.AdapterView) {
        this.connectPlayersAdapterView = view
    }

    override fun attach() {
        connectPlayersAdapterView?.addListener(this)
        compositeDisposable = CompositeDisposable()
        connectPlayersAdapterView?.swapData(DrillSetupOutput.players)
    }

    override fun refreshData() {
        connectPlayersAdapterView?.swapData(DrillSetupOutput.players)
    }

    override fun onConnectSwitch(position: Int) {
        connectingPlayerViewModelPosition = position
        connectingPlayerViewModel = connectPlayersAdapterView?.getItem(position)
        val connected = DrillSetupOutput.connectMap.contains(connectingPlayerViewModel)
        connectingPlayerViewModel?.let {
            if (!connected) {
//                here we should connect via BLE
                view.showSensorTypeChooser(it.firstName)
            } else {
                connectingPlayerViewModel?.let { player ->
                    DrillSetupOutput.connectMap.remove(player)
                    connectPlayersAdapterView?.setConnected(position, !connected)
                }
            }
        }
    }

    override fun onSensorTileSelected() {
        view.startScanActivity()
    }

    override fun onAndroidSensorSelected() {
        if (connectingPlayerViewModel != null) {
            DrillSetupOutput.connectMap.put(connectingPlayerViewModel!!,
                    DrillSetupOutput.SensorConnectionData(BaseSensor.Type.ANDROID_DEVICE))
            connectPlayersAdapterView?.setConnected(connectingPlayerViewModelPosition, true)
            removeCurrentConnectorValues()
        }
    }

    override fun onNothingSelected() {
        connectPlayersAdapterView?.setConnected(connectingPlayerViewModelPosition, false)
        removeCurrentConnectorValues()
    }

    override fun onScanSuccessfulReturnTag(nodeTag: String?) {
        if (connectingPlayerViewModel != null && nodeTag != null) {
            DrillSetupOutput.connectMap.put(connectingPlayerViewModel!!,
                    DrillSetupOutput.SensorConnectionData(BaseSensor.Type.SENSOR_TILE, nodeTag))
            connectPlayersAdapterView?.setConnected(connectingPlayerViewModelPosition, true)
        } else
            connectPlayersAdapterView?.setConnected(connectingPlayerViewModelPosition, false)
        removeCurrentConnectorValues()
    }

    private fun removeCurrentConnectorValues() {
        connectingPlayerViewModel = null
        connectingPlayerViewModelPosition = -1
    }

    override fun detach() {
        compositeDisposable.clear()
        selectedDrill = null
        connectPlayersAdapterView = null
    }

    override fun verifyStep(): VerificationError? {
        return if (DrillSetupOutput.connectMap.size >= DrillSetupOutput.players.size) null else
            VerificationError("Connect more players")
    }
}