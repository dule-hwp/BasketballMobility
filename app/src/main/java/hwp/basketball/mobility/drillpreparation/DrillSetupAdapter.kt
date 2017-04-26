package hwp.basketball.mobility.drillpreparation

import android.content.Context
import android.support.annotation.IntRange
import android.support.v4.app.FragmentManager
import com.stepstone.stepper.Step
import com.stepstone.stepper.adapter.AbstractFragmentStepAdapter
import com.stepstone.stepper.viewmodel.StepViewModel
import hwp.basketball.mobility.drillpreparation.step.BaseStepFragment
import hwp.basketball.mobility.drillpreparation.step.selectplayers.PlayersFragment
import java.util.*

/**
 * Created by dusan_cvetkovic on 4/2/17.
 */

class DrillSetupAdapter(fm: FragmentManager, context: Context,
                        val steps: ArrayList<BaseStepFragment>)
    : AbstractFragmentStepAdapter(fm, context) {

    override fun getViewModel(@IntRange(from = 0) position: Int): StepViewModel {
        return StepViewModel.Builder(context)
                .setTitle(steps[position].stepTitle())
                .create()
    }

    override fun createStep(position: Int): Step {
        return steps[position]
    }

    override fun getCount(): Int {
        return steps.size
    }
}