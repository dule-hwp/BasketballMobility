package hwp.basketball.mobility.drillpreparation.step

import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.View
import com.stepstone.stepper.Step
import com.stepstone.stepper.VerificationError
import hwp.basketball.mobility.dagger.DrillSetupActivityComponent
import hwp.basketball.mobility.drillpreparation.DrillSetupActivity
import hwp.basketball.mobility.drillpreparation.OnNavigationBarListener
import timber.log.Timber

/**
 * Created by dusan_cvetkovic on 4/10/17.
 */
abstract class BaseStepFragment : Fragment(), Step {
    lateinit var drillSetupComponent: DrillSetupActivityComponent
    private var onNavigationBarListener: OnNavigationBarListener? = null

    private fun updateNavigationBar() {
        onNavigationBarListener?.onChangeEndButtonsEnabled(true)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        drillSetupComponent = (activity as DrillSetupActivity).drillSetupActivityComponent
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is OnNavigationBarListener) {
            onNavigationBarListener = context
        }
    }

    override fun onSelected() {
        updateNavigationBar()
        onStepVisible()
    }

    abstract fun onStepVisible()

    override fun onError(error: VerificationError) {
        Timber.d("verification stepper error" + error)
    }

    abstract fun stepTitle(): String

    protected fun setupHideAddButtonBehaviour(btnAdd: FloatingActionButton, recyclerView: RecyclerView?) {
        recyclerView?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (btnAdd.visibility == View.VISIBLE && dy > 0) {
                    btnAdd.hide()
                } else if (btnAdd.visibility == View.GONE && dy < 0) {
                    btnAdd.show()
                }
            }
        })
    }
}