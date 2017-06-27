package hwp.basketball.mobility.drillpreparation.step.selectdrill

import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.squareup.picasso.Picasso
import hwp.basketball.mobility.R
import hwp.basketball.mobility.entitiy.drills.DrillViewModel

/**
 *
 * Created by dusan_cvetkovic on 3/28/17.
 */
class DrillsAdapter : RecyclerView.Adapter<DrillsAdapter.DrillViewHolder>(),
        DrillsContract.AdapterView {
    override fun notifyDrillDeleted(drill: DrillViewModel) {
        val indexOfDeletedDrill = drills.indexOf(drill)
        drills.remove(drill)
        this.notifyItemRemoved(indexOfDeletedDrill)
    }

    var listener: DrillsContract.Presenter? = null
    private var selectedDrill: DrillViewModel? = null

    var drills: MutableList<DrillViewModel> = mutableListOf()

    class DrillViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var ivDrill: ImageView = itemView.findViewById(R.id.ivDrill) as ImageView
        var tvName: TextView = itemView.findViewById(R.id.tvDrillName) as TextView
        var tvNumberOfPlayers: TextView = itemView.findViewById(R.id.tvNumberOfPlayers) as TextView
        var rbtnSelect: RadioButton = itemView.findViewById(R.id.rbtnSelect) as RadioButton
        var btnDelete: ImageButton = itemView.findViewById(R.id.btnDelete) as ImageButton

        fun bind(drillModel: DrillViewModel?) {
            tvName.text = "${drillModel?.name}"
            tvNumberOfPlayers.text = "Number of players: ${drillModel?.numberOfPlayers}"
            drillModel?.drillImage?.let {
                Picasso.with(itemView.context)
                        .load(it)
                        .into(ivDrill)
            }
        }

    }

    override fun getItem(index: Int): DrillViewModel? {
        return drills[index]
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): DrillViewHolder {
        return DrillViewHolder(LayoutInflater.from(parent?.context)
                .inflate(R.layout.list_item_drill, parent, false))
    }


    override fun onBindViewHolder(holder: DrillViewHolder?, position: Int) {
        val drill = getItem(position)
        drill?.let {
            holder?.bind(drill)
            holder?.rbtnSelect?.isChecked = selectedDrill == drill
            holder?.btnDelete?.setOnClickListener {
                listener?.deleteDrill(drill)
            }

            holder?.rbtnSelect?.setOnClickListener {
                val oldSelectedIndex = selectedDrill?.let { drills.indexOf(it) } ?: -1
                if (oldSelectedIndex != -1)
                    notifyItemChanged(oldSelectedIndex)
                listener?.drillSelected(drill)
                selectedDrill = drill
            }
        }
    }

    override fun getItemCount(): Int = drills.size

    override fun swapData(data: List<DrillViewModel>) {
        drills.clear()
        drills.addAll(data)
        notifyDataSetChanged()
    }

    override fun addDrill(drill: DrillViewModel) {
        drills.add(drill)
        notifyItemInserted(drills.size - 1)
    }

    override fun addListener(listener: DrillsContract.Presenter) {
        this.listener = listener
    }

//    override fun getCount(): Int = drills.size

}


