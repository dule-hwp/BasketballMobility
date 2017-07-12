package hwp.basketball.mobility.drill.display

import durdinapps.rxfirebase2.RxFirebaseDatabase
import hwp.basketball.mobility.entitiy.drills.DrillsDataStore
import hwp.basketball.mobility.entitiy.drills.DrillsFirebaseRepository
import hwp.basketball.mobility.entitiy.drills.outcomes.DrillOutcome
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by dusan_cvetkovic on 6/26/17.
 */
class DrillListActivityPresenter(val view: DrillListActivityContract.View) : DrillListActivityContract.Presenter {
    val drillsDataStore: DrillsDataStore by lazy {
        DrillsFirebaseRepository()
    }

    override fun onClick(drillOutcome: DrillOutcome) {
        view.showDrillDetailedView(drillOutcome)
    }

    override fun fetchDrills() {
        view.showProgressDialog("Fetching drills")
        drillsDataStore.findAll()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doAfterTerminate { view.hideProgressDialog() }
                .map({ listDrills ->
                    listDrills.filter {
                        it.outcomes.size > 0 && it.drillImage != null
                    }.toMutableList()
                })
                .subscribe({
                    Timber.d(it.toString())
                    view.onDrillsFetched(it)
                }, {
                    Timber.e(it)
                    view.showErrorMessage(it.localizedMessage)
                })
    }
}