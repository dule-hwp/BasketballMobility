package hwp.basketball.mobility.drillpreparation.step.connectplayers

import com.stepstone.stepper.VerificationError
import hwp.basketball.mobility.device.sensor.SensorFactory.Type
import hwp.basketball.mobility.drillpreparation.step.DrillSetupOutput
import hwp.basketball.mobility.entitiy.player.PlayerViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by dusan_cvetkovic on 4/4/17.
 *
 */
class ConnectPlayersPresenter constructor(val view: ConnectPlayersContract.View)
    : ConnectPlayersContract.Presenter, ConnectPlayersContract.AdapterViewCallback {

    private var connectPlayersAdapterView: ConnectPlayersContract.AdapterView? = null
    private var selectedPlayer: PlayerViewModel? = null
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

    override fun onSensorTypeSelected(sensorType: Type) {
        when (sensorType){
            Type.SENSOR_TILE -> onSensorTileSelected()
            Type.ANDROID_DEVICE -> onAndroidSensorSelected()
            Type.WICED_SENSE_SENSOR -> onWicedSenseSelected()
        }
    }

    private fun onWicedSenseSelected() {
        connectingPlayerViewModel?.let {
            DrillSetupOutput.connectMap.put(it,
                    DrillSetupOutput.SensorConnectionData(Type.WICED_SENSE_SENSOR))
            connectPlayersAdapterView?.setConnected(connectingPlayerViewModelPosition, true)
            removeCurrentConnectorValues()
        }

        view.startWicedActivityScan()

    }

    fun onSensorTileSelected() {
        view.startSensorTileScanActivity()
    }

    fun onAndroidSensorSelected() {
        connectingPlayerViewModel?.let {
            DrillSetupOutput.connectMap.put(it,
                    DrillSetupOutput.SensorConnectionData(Type.ANDROID_DEVICE))
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
                    DrillSetupOutput.SensorConnectionData(Type.SENSOR_TILE, nodeTag))
            connectPlayersAdapterView?.setConnected(connectingPlayerViewModelPosition, true)
        } else {
            connectPlayersAdapterView?.setConnected(connectingPlayerViewModelPosition, false)
        }
        removeCurrentConnectorValues()
    }

    private fun removeCurrentConnectorValues() {
        connectingPlayerViewModel = null
        connectingPlayerViewModelPosition = -1
    }

    override fun detach() {
        compositeDisposable.clear()
        selectedPlayer = null
        connectPlayersAdapterView = null
    }

    override fun verifyStep(): VerificationError? {
        return if (DrillSetupOutput.connectMap.size >= DrillSetupOutput.players.size) null else
            VerificationError("Connect more players")
    }
}