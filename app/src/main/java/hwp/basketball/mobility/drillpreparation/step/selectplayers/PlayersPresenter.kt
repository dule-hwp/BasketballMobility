package hwp.basketball.mobility.drillpreparation.step.selectplayers

import hwp.basketball.mobility.drillpreparation.step.DrillSetupOutput
import hwp.basketball.mobility.entitiy.player.PlayerFirebaseRepository
import hwp.basketball.mobility.entitiy.player.PlayerViewModel
import hwp.basketball.mobility.entitiy.player.PlayersDataStore
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 *
 * Created by dusan_cvetkovic on 3/28/17.
 */
class PlayersPresenter constructor(val view: PlayersContract.View) : PlayersContract.Presenter {
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
            playersDataStore.remove(it)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        playersAdapterView?.notifyPlayerDeleted(position)
                    },{
                        Timber.e(it)
                        view.displayError(it.localizedMessage)
                    })

        }
    }

    var playersAdapterView: PlayersContract.AdapterView? = null

    private val playersDataStore: PlayersDataStore by lazy {
        PlayerFirebaseRepository()
    }

    private lateinit var compositeDisposable: CompositeDisposable

    override fun attach() {
        playersAdapterView?.listener(this)
        compositeDisposable = CompositeDisposable()

        val players = playersDataStore.findAll()
        val disposable = players
                .subscribe({
                    playersAdapterView?.swapData(it)
                    Timber.d("data swap:" + it.size)
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
            playersDataStore.update(player)
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        Timber.d("updated player $player")
                        playersAdapterView?.notifyPlayerUpdated(player)
                    },{
                        Timber.e("failed to update player $player")
                        Timber.e(it)
                    })

        }
    }

    override fun onAddPlayerButtonClicked(first: String, last: String, position: String, height: String) {
        val player = PlayerViewModel(
                firstName = first,
                lastName = last,
                position = position,
                height = height)
        compositeDisposable.add(playersDataStore.add(player)
                .subscribe({
                    playersAdapterView?.let { adapter ->
                        adapter.addPlayer(player)
                        adapter.notifyInsertedAt(adapter.getCount())
                        Timber.d("adding player" + player)
                    }
                }, {
                    view.displayError("error while inserting player: ${it.localizedMessage}")
                }))
    }
}

