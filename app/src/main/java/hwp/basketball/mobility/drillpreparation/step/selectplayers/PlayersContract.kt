package hwp.basketball.mobility.drillpreparation.step.selectplayers

import hwp.basketball.mobility.BasePresenter
import hwp.basketball.mobility.entitiy.player.PlayerViewModel

/**
 * Created by dusan_cvetkovic on 3/28/17.
 */
interface PlayersContract {
    interface View {
        fun showEditPlayerDialog(player: PlayerViewModel)
        fun showAddPlayerDialog()
        fun displayError(s: String)
    }

    interface AdapterView {
        fun getCurrentEditingItem(): PlayerViewModel?
        fun getItem(index: Int): PlayerViewModel?
        fun swapData(data: List<PlayerViewModel>?)
        fun getCount(): Int
        fun notifyInsertedAt(position: Int)
        fun listener(listener: Presenter)
        fun notifyPlayerUpdated(player: PlayerViewModel?)
        fun notifyPlayerDeleted(playerPosition: Int)
        fun addPlayer(player: PlayerViewModel)
    }

    interface Presenter : BasePresenter {
        fun onAddPlayerButtonClicked(first: String, last: String, position: String, height: String)
        fun onEditPlayerButtonClicked(first: String, last: String, position: String, height: String)
        fun selectedCount(): Int

        fun showEditPlayerDialog(position: Int)
        fun deletePlayer(position: Int)
        fun playerChecked(player: PlayerViewModel)
        fun playerUnChecked(player: PlayerViewModel)
        fun setPlayerAdapterView(playersAdapter: AdapterView)
    }
}