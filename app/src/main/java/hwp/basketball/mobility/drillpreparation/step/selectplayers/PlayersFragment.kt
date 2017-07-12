package hwp.basketball.mobility.drillpreparation.step.selectplayers

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stepstone.stepper.VerificationError
import hwp.basketball.mobility.R
import hwp.basketball.mobility.drillpreparation.step.BaseStepFragment
import hwp.basketball.mobility.drillpreparation.step.DrillSetupOutput
import hwp.basketball.mobility.entitiy.player.PlayerViewModel
import kotlinx.android.synthetic.main.fragment_players.*
import timber.log.Timber


/**
 * Player select step.
 * View being shown in preparation drill process when coach selects player.
 */
class PlayersFragment : BaseStepFragment(), PlayersContract.View {

    lateinit var playersPresenter: PlayersContract.Presenter

    lateinit var playersDialog: PlayerDialog

    lateinit var playersAdapter: PlayersAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        playersPresenter = PlayersPresenter(this)
        playersDialog = PlayerDialog(context, playersPresenter)
        playersAdapter = PlayersAdapter()
        playersPresenter.setPlayerAdapterView(playersAdapter)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_players, container, false)
        return view
    }

    private var playersRecyclerView: RecyclerView? = null

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        playersPresenter.attach()
        btnAdd.setOnClickListener { onAddButtonClicked() }
        playersRecyclerView = view?.findViewById(R.id.players_list) as RecyclerView
        setupPlayersRecyclerView()
        setupHideAddButtonBehaviour(btnAdd, playersRecyclerView)
    }

    override fun showEditPlayerDialog(player: PlayerViewModel) {
        playersDialog.showEditPlayerDialog(player)
    }

    override fun showAddPlayerDialog() {
        playersDialog.showAddPlayerDialog()
    }

    override fun stepTitle(): String {
        return "Select player(s)"
    }

    override fun verifyStep(): VerificationError? {
        playersPresenter.let { presenter ->
            if (presenter.selectedCount() > 0) return null
        }
        val numOfPlayers = DrillSetupOutput.drill?.numberOfPlayers ?:
                throw IllegalStateException("drill canot be null at this point!")
        return VerificationError("select " +
                "${numOfPlayers - DrillSetupOutput.players.size} " +
                "more player(s)")
    }

    override fun displayError(errorMessage: String) {
        Timber.d("error " + errorMessage)
    }

    private fun onAddButtonClicked() {
        playersDialog.showAddPlayerDialog()
    }

    fun setupPlayersRecyclerView() {
        playersRecyclerView?.layoutManager = LinearLayoutManager(activity)
        playersRecyclerView?.adapter = playersAdapter
    }

    override fun onStepVisible() {

    }

    override fun onDestroy() {
        super.onDestroy()
        playersRecyclerView?.adapter = null
        playersPresenter.detach()
    }

    companion object {
        fun newInstance(): PlayersFragment {
            return PlayersFragment()
        }
    }

}




