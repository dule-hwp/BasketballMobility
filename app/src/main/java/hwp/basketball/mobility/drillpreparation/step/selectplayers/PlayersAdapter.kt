package hwp.basketball.mobility.drillpreparation.step.selectplayers

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import hwp.basketball.mobility.R
import hwp.basketball.mobility.entitiy.player.PlayerViewModel
import kotlinx.android.synthetic.main.list_item_player.view.*

/**
 * Created by dusan_cvetkovic on 3/28/17.
 */
class PlayersAdapter : RecyclerView.Adapter<PlayersAdapter.PlayerViewHolder>(),
        PlayersContract.AdapterView {

    lateinit var listener: PlayersContract.Presenter
    private var currentItem: PlayerViewModel? = null
    private var currentItemPosition: Int = -1

    var players: MutableList<PlayerViewModel> = mutableListOf()

    class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var ivPlayer: ImageView = itemView.findViewById(R.id.ivPlayerImage) as ImageView
        private var tvName: TextView = itemView.findViewById(R.id.tvFullName) as TextView
        private var tvPosition: TextView = itemView.findViewById(R.id.tvPosition) as TextView
        private var tvHeight: TextView = itemView.findViewById(R.id.tvHeight) as TextView

        fun bind(playerModel: PlayerViewModel?) {
            tvName.text = "${playerModel?.firstName} ${playerModel?.lastName}"
            tvPosition.text = playerModel?.position
            tvHeight.text = playerModel?.height
        }

    }

    override fun getCurrentEditingItem(): PlayerViewModel? {
        return currentItem
    }

    override fun getItem(index: Int): PlayerViewModel? {
        return players[index]
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): PlayersAdapter.PlayerViewHolder {
        return PlayersAdapter.PlayerViewHolder(LayoutInflater.from(parent?.context)
                .inflate(R.layout.list_item_player, parent, false))
    }


    override fun onBindViewHolder(holder: PlayersAdapter.PlayerViewHolder?, position: Int) {
        val player = getItem(position)
        player?.let {
            holder?.bind(player)
            holder?.itemView?.btnEdit?.setOnClickListener {
                listener.onEditPlayerClicked(position)
                currentItem = player
                currentItemPosition = position
            }
            holder?.itemView?.btnDelete?.setOnClickListener {
                listener.deletePlayer(position)
            }

            val btnCheck = holder?.itemView?.btnCheck as CheckBox
            btnCheck.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked)
                    listener.playerChecked(player)
                else
                    listener.playerUnChecked(player)
            }
        }
    }

    override fun getItemCount(): Int = players.size

    override fun swapData(data: List<PlayerViewModel>?) {
        players.clear()
        data?.let { newPlayers ->
            players.addAll(newPlayers)
        }
        notifyDataSetChanged()
    }

    override fun addPlayer(player: PlayerViewModel) {
        players.add(player)
        players
    }

    override fun notifyPlayerUpdated(player: PlayerViewModel?) {
        player?.let {
            players[currentItemPosition] = player
            this.notifyItemChanged(currentItemPosition)
            currentItemPosition = -1
            currentItem = null
        }
    }

    override fun notifyPlayerDeleted(playerPosition: Int) {
        players.removeAt(playerPosition)
        this.notifyItemRemoved(playerPosition)

    }

    override fun listener(listener: PlayersContract.Presenter) {
        this.listener = listener
    }

    override fun getCount(): Int = players.size

    override fun notifyInsertedAt(position: Int) {
        this.notifyItemInserted(position)
    }

}


