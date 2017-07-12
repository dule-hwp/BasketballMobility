package hwp.basketball.mobility.drill.create

import android.graphics.Bitmap
import hwp.basketball.mobility.entitiy.drills.*
import hwp.basketball.mobility.util.PointF
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import kotlin.streams.toList

/**
 *
 * Created by dusan_cvetkovic on 4/19/17.
 */
class DrillActivityPresenter(val view: DrillActivityContract.View) :
        DrillActivityContract.Presenter {
    override fun attach() {
    }

    override fun detach() {
        compositeDisposable.clear()
        drillsDataStore.cleanup()
    }

    val drillsDataStore: DrillsDataStore by lazy {
        DrillsFirebaseRepository()
    }

    val compositeDisposable = CompositeDisposable()

    /**
     * Method in charge of adding drill to the database.
     *
     * Converts points to percent point to take care of different views display.
     * Communicates to drills repository interface.
     * */
    override fun onDrillDataFilled(pathPoints: List<PointF>, drillName: String, numOfPlayers: Int, bitmap: Bitmap, viewDimens: ViewDimens) {

        val lstPoints = pathPoints
                .map { PercentPoint.fromViewPoint(it, viewDimens) }
                .toList()
        val drill = DrillViewModel(drillName, numberOfPlayers = numOfPlayers, pathPoints = lstPoints)
        view.showProgressDialog("Adding drill to database")

        val disposable = drillsDataStore.addDrillToDatabase(drill, bitmap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Timber.i("Drill added to database!")
                    view.hideProgressDialog()
                    view.finishActivity()
                }, { error ->
                    Timber.e(error)
                    view.hideProgressDialog()
                    view.displayError(error.localizedMessage)
                })
        compositeDisposable.add(disposable)
    }

    override fun onDoneTap() {
        view.takeADrillScreenshot()
    }
}
