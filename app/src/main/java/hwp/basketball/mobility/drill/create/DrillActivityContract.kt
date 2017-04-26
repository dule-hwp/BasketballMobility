package hwp.basketball.mobility.drill.create

import android.graphics.Bitmap
import com.rm.freedrawview.FreeDrawView
import com.rm.freedrawview.PathDrawnListener
import com.rm.freedrawview.PathRedoUndoCountChangeListener

/**
 * Created by dusan_cvetkovic on 4/19/17.
 */
interface DrillActivityContract{
    interface View {
        fun promptForDrillNameDialog(draw: Bitmap?)
        fun takeADrillScreenshot()
        fun finishActivity()
    }

    interface Presenter : PathRedoUndoCountChangeListener, PathDrawnListener, FreeDrawView.DrawCreatorListener {
        fun onDoneTap()
        fun onDrillDataFilled(numOfPlayers: Int, drillName: String?)
    }
}
