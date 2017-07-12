package hwp.basketball.mobility.drillpreparation.step.selectplayers

import hwp.basketball.mobility.BasePresenter
import hwp.basketball.mobility.entitiy.player.PlayerViewModel

/**
 * Contract that needs to be fulfilled for players step to work properly.
 */
interface PlayersContract {
    interface View {
        /**
         * This method is triggered when edit player was clicked.
         * View responsibility is to show edit dialog.
         * @param player Player object to edit
         **/
        fun showEditPlayerDialog(player: PlayerViewModel)

        /**
         * This method is triggered when add player button is clicked.
         * View responsibility is to show add dialog.
         * */
        fun showAddPlayerDialog()

        /**
         * When some error has happened this method is triggered.
         * View should display the error message.
         * @param errorMessage Error message
         * */
        fun displayError(errorMessage: String)
    }

    interface AdapterView {
        /**
         * Return item currently being edited.
         * @return Player object
         **/
        fun getCurrentEditingItem(): PlayerViewModel?

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
         * Return number of players in the list.
         * @return number of players
         * */
        fun getCount(): Int

        /**
         * Notify that the player has be inserted at position.
         * @param position Position of insertion
         * */
        fun notifyInsertedAt(position: Int)

        /**
         * Set listener for tap events on the list items.
         * @param listener Object to receive update events.
         **/
        fun listener(listener: Presenter)

        /**
         * Update UI after player data has been changed. This will be triggered
         * after user has updated the player data.
         * @param player updated Player data
         * */
        fun notifyPlayerUpdated(player: PlayerViewModel?)

        /**
         * Update UI after player has been deleted from list.
         * @param playerPosition Position of the player in the list.
         * */
        fun notifyPlayerDeleted(playerPosition: Int)

        /**
         * Update UI after player was added to the list of players
         * @param player new Player's data
         * */
        fun addPlayer(player: PlayerViewModel)
    }

    interface Presenter : BasePresenter {

        /**
         * Data needed for player creation.
         * @param first player's first name
         * @param last player's last name
         * @param position player's playing position name
         * @param height player's height
         * */
        fun onAddPlayerButtonClicked(first: String, last: String, position: String, height: String)

        /**
         * Data needed for player update.
         * @param playerFullName Player who is being edited name
         * @param first edited first name
         * @param last edited last name
         * @param position edited playing position name
         * @param height edited height
         * */
        fun onEditPlayerButtonClicked(playerFullName: String,
                                      first: String, last: String, position: String, height: String)

        /**
         * Get number of players selected to perform the drill
         * @return Number of players selected to perform the drill
         * */
        fun selectedCount(): Int

        /**
         * Player edit button clicked.
         * @param position Index of the player in the list
         **/
        fun onEditPlayerClicked(position: Int)

        /**
         * Player delete button clicked.
         * @param position Index of the player in the list
         **/
        fun deletePlayer(position: Int)

        /**
         * Player checkbox checked
         * @param player Player checked
         * */
        fun playerChecked(player: PlayerViewModel)

        /**
         * Player checkbox unchecked
         * @param player Player unchecked
         * */
        fun playerUnChecked(player: PlayerViewModel)

        /**
         * Passing adapterView reference to presenter so that presenter can handle logic for it
         * @param playersAdapter Interface representing list adapter view
         * */
        fun setPlayerAdapterView(playersAdapter: AdapterView)
    }
}