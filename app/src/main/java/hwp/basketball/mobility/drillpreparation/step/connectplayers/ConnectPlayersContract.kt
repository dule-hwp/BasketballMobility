package hwp.basketball.mobility.drillpreparation.step.connectplayers

import com.stepstone.stepper.VerificationError
import hwp.basketball.mobility.BasePresenter
import hwp.basketball.mobility.entitiy.player.PlayerViewModel
import hwp.basketball.mobility.device.sensor.sensortile.sensortilescan.SensorsDialog

/**
 * Contract that needs to be fulfilled for connect players step to work properly.
 */
interface ConnectPlayersContract {
    interface View {
        /**
         * When some error has happened this method is triggered.
         * View should display the error message.
         * @param errorMessage Error message
         * */
        fun displayError(errorMessage: String)
        /**
         * Show SensorTile scan for BLE devices
         * */
        fun startSensorTileScanActivity()
        /**
         * Show dialog for chosing sensor type player with 'firstName' is using.
         * @param firstName name of the player being connected
         * */
        fun showSensorTypeChooser(firstName: String)
        /**
         * Show Wiced sense scan for BLE devices
         * */
        fun startWicedActivityScan()
    }

    interface AdapterView {
        /**
         * Return player sitting on index.
         * @param index Index of the player in the list
         * @return Player object
         **/
        fun getItem(index: Int): PlayerViewModel?

        /**
         * Replace the data displayed with new data.
         * @param data new List of players to be displayed
         * */
        fun swapData(data: List<PlayerViewModel>?)
        /**
         * Set listener for tap events on the list items.
         * @param listener Object to receive update events.
         **/
        fun addListener(listener: AdapterViewCallback)

        /**
         * Update switch UI for given position and state.
         *
         * @param position index of the list item to be updated
         * @param checked true for connected, false for disconnected player
         * */
        fun setConnected(position: Int, checked: Boolean)
    }

    interface AdapterViewCallback {
        /**
         * On switch player connection clicked.
         * @param position index of the player whose connection is being toggled.
         **/
        fun onConnectSwitch(position: Int)
    }

    interface Presenter : BasePresenter, SensorsDialog.SensorChooserCallback {
        fun setConnectPlayersAdapterView(view: AdapterView)
        fun verifyStep(): VerificationError?
        fun refreshData()
        fun onScanSuccessfulReturnTag(nodeTag: String?)
    }
}