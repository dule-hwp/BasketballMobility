package hwp.basketball.mobility.drillpreparation.step.connectplayers

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SwitchCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import hwp.basketball.mobility.R
import hwp.basketball.mobility.drillpreparation.step.DrillSetupOutput
import hwp.basketball.mobility.entitiy.player.PlayerViewModel

/**
 * Created by dusan_cvetkovic on 3/28/17.
 */
class ConnectPlayersAdapter :
        RecyclerView.Adapter<ConnectPlayersAdapter.ConnectPlayerViewHolder>(), ConnectPlayersContract.AdapterView {

    var listener: ConnectPlayersContract.AdapterViewCallback? = null

    private var selectedDrill: PlayerViewModel? = null

    var players: MutableList<PlayerViewModel> = mutableListOf()

    class ConnectPlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var ivPlayer: ImageView = itemView.findViewById(R.id.ivPlayerImage) as ImageView
        private var tvName: TextView = itemView.findViewById(R.id.tvFullName) as TextView
        private var tvConnect: TextView = itemView.findViewById(R.id.tvConnect) as TextView
        var switchConnect: SwitchCompat = itemView.findViewById(R.id.switchConnect) as SwitchCompat

        fun bind(playerModel: PlayerViewModel?) {
            tvName.text = "${playerModel?.firstName} ${playerModel?.lastName}"
            if (DrillSetupOutput.connectMap.contains(playerModel)) {
                val connectString = String.format(itemView.context.getString(R.string.connected),
                        DrillSetupOutput.connectMap[playerModel])
                tvConnect.text = connectString
                tvConnect.setTextColor(R.color.connect_green)
                switchConnect.isChecked = true
            } else {
                tvConnect.setText(R.string.disconnected)
                tvConnect.setTextColor(R.color.connect_red)
                switchConnect.isChecked = false
            }

        }

    }

    override fun getItem(index: Int): PlayerViewModel? {
        return players[index]
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ConnectPlayersAdapter.ConnectPlayerViewHolder {
        return ConnectPlayersAdapter.ConnectPlayerViewHolder(LayoutInflater.from(parent?.context)
                .inflate(R.layout.list_item_connect, parent, false))
    }


    override fun onBindViewHolder(holder: ConnectPlayersAdapter.ConnectPlayerViewHolder?, position: Int) {
        val player = getItem(position)
        player?.let {
            holder?.bind(player)
            holder?.switchConnect?.setOnClickListener {
                listener?.onConnectSwitch(position)
            }
        }
    }

    override fun getItemCount(): Int = players.size

    override fun swapData(data: List<PlayerViewModel>?) {
        players.clear()
        data?.let { newConnectPlayers ->
            players.addAll(newConnectPlayers)
        }
        notifyDataSetChanged()
    }

    override fun addListener(listener: ConnectPlayersContract.AdapterViewCallback) {
        this.listener = listener
    }

    override fun setConnected(position: Int, checked: Boolean) {
        if (position >= 0 && position < this.itemCount)
            notifyItemChanged(position)
    }
}


