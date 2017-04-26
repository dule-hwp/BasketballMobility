package hwp.basketball.mobility.drillpreparation.step.selectplayers

import hwp.basketball.mobility.dagger.DrillSetupActivityScope
import hwp.basketball.mobility.drillpreparation.step.DrillSetupOutput
import hwp.basketball.mobility.entitiy.player.PlayerRealmRepository
import hwp.basketball.mobility.entitiy.player.PlayerViewModel
import hwp.basketball.mobility.entitiy.player.PlayersDataStore
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by dusan_cvetkovic on 3/28/17.
 */
@DrillSetupActivityScope
class PlayersPresenter @Inject constructor(val view: PlayersContract.View) : PlayersContract.Presenter
{
    override fun setPlayerAdapterView(playersAdapter: PlayersContract.AdapterView) {
        playersAdapterView = playersAdapter
    }

    private val checkedPlayers = DrillSetupOutput.players

    override fun playerChecked(player: PlayerViewModel) {
        checkedPlayers.add(player)
    }

    override fun playerUnChecked(player: PlayerViewModel) {
        checkedPlayers.remove(player)
    }

    override fun selectedCount(): Int {
        return checkedPlayers.size
    }

    override fun showEditPlayerDialog(position: Int) {
        val playerRealmModel = playersAdapterView?.getItem(position)
        playerRealmModel?.let {
            view.showEditPlayerDialog(playerRealmModel)
        }
    }

    override fun deletePlayer(position: Int) {
        val player = playersAdapterView?.getItem(position)

        player?.let {
            playersDataStore?.remove((it.id))
            playersAdapterView?.notifyPlayerDeleted(position)
        }
    }

    var playersAdapterView: PlayersContract.AdapterView? = null

    private var playersDataStore: PlayersDataStore? = null

    private lateinit var compositeDisposable: CompositeDisposable

    override fun attach() {
        playersAdapterView?.listener(this)
        compositeDisposable = CompositeDisposable()
        playersDataStore = PlayerRealmRepository()

        val players = playersDataStore?.findAll()
        val disposable = players?.
                //                subscribeOn(Schedulers.io())?.
//                observeOn(AndroidSchedulers.mainThread())?.
                subscribe({
                    playersAdapterView?.swapData(it)
                    Timber.d("data swap:"+it.size)
                }, {
                    view.displayError("something went wrong " + it.message)
                })
        compositeDisposable.add(disposable)
    }

    override fun detach() {
        compositeDisposable.clear()
    }

    override fun onEditPlayerButtonClicked(first: String, last: String, position: String, height: String) {
        val player = playersAdapterView?.getCurrentEditingItem()
        player?.let {
            player.height = height
            player.firstName = first
            player.lastName = last
            player.position = position
            playersDataStore?.update(player)
            Timber.d("updating player $player")
            playersAdapterView?.notifyPlayerUpdated(player)
        }
    }

    override fun onAddPlayerButtonClicked(first: String, last: String, position: String, height: String) {
        playersDataStore?.let {
            compositeDisposable.add(it.add(PlayerViewModel(
                    firstName = first,
                    lastName = last,
                    position = position,
                    height = height)).subscribe({ player ->
                playersAdapterView?.let { adapter ->
                    adapter.addPlayer(player)
                    adapter.notifyInsertedAt(adapter.getCount())
                    Timber.d("adding player"+player)
                }
            }, {
                view.displayError("error while inserting player")
            }))
        }
    }

}