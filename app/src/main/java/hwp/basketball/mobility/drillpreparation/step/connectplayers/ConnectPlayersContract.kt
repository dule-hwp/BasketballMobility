package hwp.basketball.mobility.drillpreparation.step.connectplayers

import com.stepstone.stepper.VerificationError
import hwp.basketball.mobility.BasePresenter
import hwp.basketball.mobility.entitiy.player.PlayerViewModel
import hwp.basketball.mobility.sensortilescan.SensorsDialog

/**
 * Created by dusan_cvetkovic on 3/28/17.
 */
interface ConnectPlayersContract {
    interface View {
        fun showConnectDialog()
        fun displayError(s: String)
        fun startScanActivity()
        fun showSensorTypeChooser(firstName: String)
    }

    interface AdapterView {
        fun getItem(index: Int): PlayerViewModel?
        fun swapData(data: List<PlayerViewModel>?)
        fun addListener(listener: AdapterViewCallback)
        fun setConnected(position: Int, checked: Boolean)
    }

    interface AdapterViewCallback {
        fun onConnectSwitch(position: Int)
    }

    interface Presenter : BasePresenter, SensorsDialog.SensorChooserCallback {
        fun setConnectPlayersAdapterView(view: AdapterView)
        fun verifyStep(): VerificationError?
        fun refreshData()
        fun onScanSuccessfulReturnTag(nodeTag: String?)
    }
}