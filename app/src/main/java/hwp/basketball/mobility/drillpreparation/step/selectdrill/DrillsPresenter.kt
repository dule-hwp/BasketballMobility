package hwp.basketball.mobility.drillpreparation.step.selectdrill

import android.graphics.Bitmap
import com.stepstone.stepper.VerificationError
import hwp.basketball.mobility.drillpreparation.step.DrillSetupOutput
import hwp.basketball.mobility.entitiy.drills.DrillViewModel
import hwp.basketball.mobility.entitiy.drills.DrillsFirebaseRepository
import hwp.basketball.mobility.util.PointF
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 *
 * Created by dusan_cvetkovic on 4/4/17.
 */
class DrillsPresenter constructor(val view: DrillsContract.View) : DrillsContract.Presenter {
    private var drillsAdapter: DrillsContract.AdapterView? = null
    private var selectedDrill: DrillViewModel? = null
    val drillsDataStore: DrillsFirebaseRepository = DrillsFirebaseRepository()
    private lateinit var compositeDisposable: CompositeDisposable

    override fun setDrillAdapterView(drillsAdapter: DrillsContract.AdapterView) {
        this.drillsAdapter = drillsAdapter
    }

    override fun attach() {
        drillsAdapter?.addListener(this)
        compositeDisposable = CompositeDisposable()
        refreshData()
    }

    override fun refreshData() {
        val drills = drillsDataStore.findAll()
        val disposable = drills
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    drillsAdapter?.swapData(it)
                    Timber.d("data swap:" + it.size)
                }, {
                    view.displayError("something went wrong " + it.message)
                })
        compositeDisposable.add(disposable)
    }

    override fun detach() {
        compositeDisposable.clear()
        selectedDrill = null
        drillsAdapter = null
    }

    override fun deleteDrill(drill: DrillViewModel) {
        view.showProgressDialog("Deleting drill ${drill.name}")
        drillsDataStore.delete(drill)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    Timber.d("drill deleted")
                    view.hideProgressDialog()
                    drillsAdapter?.notifyDrillDeleted(drill)
                }, {
                    view.displayError("drill deletion error: " + it.message)
                })
    }

    override fun drillSelected(drill: DrillViewModel) {
        selectedDrill = drill
        DrillSetupOutput.drill = drill
    }

    override fun verifyStep(): VerificationError? {
        return if (selectedDrill == null) VerificationError("select at least one") else null
    }

    override fun handleNewDrillCreated(pathPoints: Array<PointF>?, drillImage: Bitmap?, drillname: String) {
//        val drillViewModel = DrillViewModel(drillname, null, 1, drillImage, pathPoints)
//        drillsDataStore.addDrillToDatabase(drillViewModel)
    }
}