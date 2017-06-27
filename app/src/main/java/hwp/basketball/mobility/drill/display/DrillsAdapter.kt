package hwp.basketball.mobility.drill.display

import android.view.LayoutInflater
import android.view.View
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import android.view.ViewGroup
import android.widget.TextView
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder
import hwp.basketball.mobility.R
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder
import hwp.basketball.mobility.entitiy.drills.DrillViewModel
import hwp.basketball.mobility.entitiy.drills.outcomes.DrillOutcome
import android.view.animation.Animation.RELATIVE_TO_SELF
import android.view.animation.RotateAnimation
import android.widget.ImageView
import com.squareup.picasso.Picasso
import hwp.basketball.mobility.util.bindView


/**
 * Created by dusan_cvetkovic on 6/26/17.
 */
class DrillsAdapter(val drills: MutableList<ExpandableGroup<DrillOutcome>>)
    : ExpandableRecyclerViewAdapter<DrillsAdapter.DrillViewHolder, DrillsAdapter.DrillOutcomeViewHolder>(drills) {

    override fun onCreateGroupViewHolder(parent: ViewGroup, viewType: Int): DrillViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item_genre, parent, false)
        return DrillViewHolder(view)
    }

    override fun onCreateChildViewHolder(parent: ViewGroup, viewType: Int): DrillOutcomeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.list_item_artist, parent, false)
        return DrillOutcomeViewHolder(view)
    }

    override fun onBindChildViewHolder(holder: DrillOutcomeViewHolder, flatPosition: Int,
                                       group: ExpandableGroup<*>,
                                       childIndex: Int) {
        val drillOutcome = (group as DrillViewModel).items[childIndex]
        holder.onBind(drillOutcome)
    }

    override fun onBindGroupViewHolder(holder: DrillViewHolder, flatPosition: Int, group: ExpandableGroup<*>) {
        holder.onBind(group as DrillViewModel)
    }

    inner class DrillViewHolder(itemView: View) : GroupViewHolder(itemView) {
        private val drillTitle by itemView.bindView<TextView>(R.id.list_item_drill_name)
        private val drillCount by itemView.bindView<TextView>(R.id.list_item_drill_performed_count)
        private val drillHighScore by itemView.bindView<TextView>(R.id.list_item_drill_high_score)
        private val ivArrow by itemView.bindView<ImageView>(R.id.list_item_drill_arrow)
        private val ivDrillImage by itemView.bindView<ImageView>(R.id.list_item_drill_icon)

        fun onBind(drill: DrillViewModel) {
            drillTitle.text = drill.name;
            Picasso.with(itemView.context)
                    .load(drill.drillImage)
                    .into(ivDrillImage)
            drillCount.text = String.format(itemView.resources.getString(R.string.times_performed),
                    drill.itemCount)
            val entry = drill.outcomes.maxBy { it.value.score }
            drillHighScore.text = String.format(itemView.resources.getString(R.string.high_score),
                    entry?.value?.score, entry?.value?.playerName)
        }

        override fun expand() {
            animateExpand()
        }

        override fun collapse() {
            animateCollapse()
        }

        private fun animateExpand() {
            val rotate = RotateAnimation(360f, 180f, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f)
            rotate.duration = 300
            rotate.fillAfter = true
            ivArrow.animation = rotate
        }

        private fun animateCollapse() {
            val rotate = RotateAnimation(180f, 360f, RELATIVE_TO_SELF, 0.5f, RELATIVE_TO_SELF, 0.5f)
            rotate.duration = 300
            rotate.fillAfter = true
            ivArrow.animation = rotate
        }
    }

    inner class DrillOutcomeViewHolder(itemView: View) : ChildViewHolder(itemView) {

        val playerName by itemView.bindView<TextView>(R.id.list_item_player_name)
        val date by itemView.bindView<TextView>(R.id.outcome_date)
        val score by itemView.bindView<TextView>(R.id.outcome_score)
        val ivSensorOutput by itemView.bindView<ImageView>(R.id.iv_sensor_output)

        fun onBind(drillOutcome: DrillOutcome) {
            playerName.text = drillOutcome.playerName
            date.text = drillOutcome.date
            score.text = String.format(itemView.resources.getString(R.string.outcome_score),
                    drillOutcome.score)
            Picasso.with(itemView.context)
                    .load(drillOutcome.drillOutcomeImage)
                    .into(ivSensorOutput)
        }
    }
}