package hwp.basketball.mobility.drill.create

import android.graphics.Bitmap
import hwp.basketball.mobility.BasePresenter
import hwp.basketball.mobility.entitiy.drills.ViewDimens
import hwp.basketball.mobility.util.PointF

/**
 * Created by dusan_cvetkovic on 4/19/17.
 */
interface DrillActivityContract {
    interface View {
        fun promptForDrillNameDialog(draw: Bitmap?)
        fun takeADrillScreenshot()
        fun finishActivity()
        fun hideProgressDialog()
        fun showProgressDialog(message: String)
        fun displayError(message: String)
    }

    interface Presenter : BasePresenter {
        fun onDoneTap()
        fun onDrillDataFilled(pathPoints: List<PointF>, drillName: String, numOfPlayers: Int, bitmap: Bitmap, viewDimens: ViewDimens)
    }
}
