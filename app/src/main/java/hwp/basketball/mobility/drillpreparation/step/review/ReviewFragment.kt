package hwp.basketball.mobility.drillpreparation.step.review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stepstone.stepper.VerificationError
import hwp.basketball.mobility.R
import hwp.basketball.mobility.drillpreparation.step.BaseStepFragment
import hwp.basketball.mobility.drillpreparation.step.DrillSetupOutput
import kotlinx.android.synthetic.main.fragment_review.*

/**
 * Review step.
 * View being shown in preparation drill process when coach reviews the data he selected
 * in previous steps.
 */
class ReviewFragment :BaseStepFragment() {

    companion object{
        fun newInstance(): ReviewFragment {
            return ReviewFragment()
        }
    }

    override fun verifyStep(): VerificationError? {
        return null
    }

    override fun stepTitle(): String {
        return "Review"
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater?.inflate(R.layout.fragment_review, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onStepVisible()
    }

    override fun onStepVisible() {
        tvReview.text = DrillSetupOutput.toString()
    }
}