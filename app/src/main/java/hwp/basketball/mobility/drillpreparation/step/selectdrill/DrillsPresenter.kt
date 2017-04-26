package hwp.basketball.mobility.drillpreparation.step.selectdrill

import android.graphics.Bitmap
import com.rm.freedrawview.Point
import com.stepstone.stepper.VerificationError
import hwp.basketball.mobility.dagger.DrillSetupActivityScope
import hwp.basketball.mobility.drillpreparation.step.DrillSetupOutput
import hwp.basketball.mobility.entitiy.drills.DrillViewModel
import hwp.basketball.mobility.entitiy.drills.DrillsDataStore
import hwp.basketball.mobility.entitiy.drills.DrillsRealmRepository
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by dusan_cvetkovic on 4/4/17.
 */
@DrillSetupActivityScope
class DrillsPresenter @Inject constructor(val view: DrillsContract.View) : DrillsContract.Presenter {
    private var drillsAdapter: DrillsContract.AdapterView? = null
    private var selectedDrill: DrillViewModel? = null
    val drillsDataStore: DrillsRealmRepository = DrillsRealmRepository
    private lateinit var compositeDisposable: CompositeDisposable

    override fun setDrillAdapterView(drillsAdapter: DrillsContract.AdapterView) {
        this.drillsAdapter = drillsAdapter
//        playersAdapter.addListener(this)
    }

    override fun attach() {
        drillsAdapter?.addListener(this)
        compositeDisposable = CompositeDisposable()
        refreshData()
    }

    override fun refreshData() {
        val players = drillsDataStore?.findAll()
        val disposable = players
                ?.subscribe({
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
        drillsAdapter?.notifyDrillDeleted(drill)
        drill.id?.let { id -> drillsDataStore?.remove(id) }
    }

    override fun drillSelected(drill: DrillViewModel) {
        selectedDrill = drill
        DrillSetupOutput.drill = selectedDrill
    }

    override fun verifyStep(): VerificationError? {
        return if (selectedDrill == null) VerificationError("select at least one") else null
    }

    override fun handleNewDrillCreated(pathPoints: Array<Point>?, drillImage: Bitmap?, drillname: String) {
//        val drillViewModel = DrillViewModel(drillname, null, 1, drillImage, pathPoints)
//        drillsDataStore.add(drillViewModel)
    }
}