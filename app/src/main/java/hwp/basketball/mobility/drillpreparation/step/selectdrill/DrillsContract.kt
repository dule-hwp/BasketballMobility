package hwp.basketball.mobility.drillpreparation.step.selectdrill

import android.graphics.Bitmap
import com.stepstone.stepper.VerificationError
import hwp.basketball.mobility.BasePresenter
import hwp.basketball.mobility.entitiy.drills.DrillViewModel
import hwp.basketball.mobility.util.PointF

/**
 * Created by dusan_cvetkovic on 3/28/17.
 */
interface DrillsContract {
    interface View {
        fun displayError(s: String)
        fun showProgressDialog(message: String)
        fun hideProgressDialog()
    }

    interface AdapterView {
        fun getItem(index: Int): DrillViewModel?
        fun swapData(data: List<DrillViewModel>)
        fun addDrill(drill: DrillViewModel)
        fun notifyDrillDeleted(drill: DrillViewModel)
        fun addListener(listener: Presenter)
    }

    interface Presenter : BasePresenter {
        fun drillSelected(drill: DrillViewModel)
        fun verifyStep(): VerificationError?
        fun setDrillAdapterView(drillsAdapter: AdapterView)
        fun deleteDrill(drill: DrillViewModel)
        fun handleNewDrillCreated(pathPoints: Array<PointF>?, drillImage: Bitmap?, drillname: String)
        fun refreshData()
    }
}