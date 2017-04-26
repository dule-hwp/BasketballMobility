package hwp.basketball.mobility.drill.create

import android.graphics.Bitmap
import com.rm.freedrawview.Point
import hwp.basketball.mobility.entitiy.drills.DrillViewModel
import hwp.basketball.mobility.entitiy.drills.DrillsRealmRepository
import java.util.*
import javax.inject.Inject

/**
 * Created by dusan_cvetkovic on 4/19/17.
 */
class DrillActivityPresenter(val view: DrillActivityContract.View) :
        DrillActivityContract.Presenter {

    val drillsDataStore: DrillsRealmRepository = DrillsRealmRepository

    override fun onDrillDataFilled(numOfPlayers: Int, drillName: String?) {
        val drillViewModel = DrillViewModel(drillName!!, null, numOfPlayers, drawImage, mCurrentPathPoints)
//        val drillsDataStore = DrillsRealmRepository()
        drillsDataStore.add(drillViewModel)
        view.finishActivity()
    }

    private var drawImage: Bitmap? = null

    override fun onDrawCreated(draw: Bitmap?) {
        drawImage = draw
        view.promptForDrillNameDialog(draw)
    }

    override fun onDrawCreationError() {
        view.promptForDrillNameDialog(null)
    }

    override fun onDoneTap() {
        view.takeADrillScreenshot()
    }

    private var mCurrentPathPoints: ArrayList<Point>? = null

    override fun onNewPathDrawn(currentPathPoints: ArrayList<Point>?) {
        mCurrentPathPoints = currentPathPoints?.clone() as ArrayList<Point>?
    }

    override fun onPathStart() {

    }

    override fun onUndoCountChanged(undoCount: Int) {

    }

    override fun onRedoCountChanged(redoCount: Int) {

    }

}
