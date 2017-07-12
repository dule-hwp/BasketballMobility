package hwp.basketball.mobility.drill.display

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup
import hwp.basketball.mobility.entitiy.drills.DrillViewModel
import hwp.basketball.mobility.entitiy.drills.outcomes.DrillOutcome

/**
 * Created by dusan_cvetkovic on 6/26/17.
 */
interface DrillListActivityContract {
    interface Presenter : DrillOutcomeCallback{
        fun fetchDrills()
    }

    interface View {
        fun onDrillsFetched(drills: MutableList<DrillViewModel>)
        fun showProgressDialog(message: String)
        fun hideProgressDialog()
        fun showErrorMessage(message: String)
        fun showDrillDetailedView(drillOutcome: DrillOutcome)

    }

    interface DrillOutcomeCallback{
        fun onClick(drillOutcome: DrillOutcome)
    }

}