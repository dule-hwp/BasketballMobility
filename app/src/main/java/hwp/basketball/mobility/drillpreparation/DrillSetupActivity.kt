package hwp.basketball.mobility.drillpreparation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.stepstone.stepper.StepperLayout
import com.stepstone.stepper.VerificationError
import hwp.basketball.mobility.R
import hwp.basketball.mobility.drillpreparation.step.DrillSetupOutput
import hwp.basketball.mobility.drillpreparation.step.connectplayers.ConnectPlayersFragment
import hwp.basketball.mobility.drillpreparation.step.review.ReviewFragment
import hwp.basketball.mobility.drillpreparation.step.selectdrill.DrillsFragment
import hwp.basketball.mobility.drillpreparation.step.selectplayers.PlayersFragment
import hwp.basketball.mobility.drill.perform.PathRecorderActivity
import hwp.basketball.mobility.util.toast
import kotlinx.android.synthetic.main.activity_drill_setup.*
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper
/**
 * Activity in charge of drill setup.
 *
 * Responsible for navigating through underlying step fragments:
 * 1. select player,
 * 2. select drill,
 * 3. connect player,
 * 4. review.
* */
open class DrillSetupActivity : AppCompatActivity(),
        StepperLayout.StepperListener, OnNavigationBarListener {

    companion object {
        fun getStartIntent(context: Context): Intent {
//          resetting "drill setup output" singleton before new setup is started
            DrillSetupOutput.reset()
            return Intent(context, DrillSetupActivity::class.java)
        }

        private val CURRENT_STEP_POSITION_KEY = "position"
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val playersFragment = PlayersFragment.newInstance()
        val connectPlayersFragment = ConnectPlayersFragment.newInstance()
        val drillsFragment = DrillsFragment.newInstance()
        val reviewFragment = ReviewFragment.newInstance()

        title = "Prepare Drill"

        setContentView(R.layout.activity_drill_setup)

        val startingStepPosition = savedInstanceState?.getInt(CURRENT_STEP_POSITION_KEY) ?: 0
        val listOfSteps = arrayListOf(drillsFragment,
                playersFragment,
                connectPlayersFragment,
                reviewFragment)

        stepperLayout.setAdapter(DrillSetupAdapter(supportFragmentManager, this, listOfSteps), startingStepPosition)
        stepperLayout.setListener(this)
        stepperLayout.setOffscreenPageLimit(listOfSteps.size - 1)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt(CURRENT_STEP_POSITION_KEY, stepperLayout.currentStepPosition)
        super.onSaveInstanceState(outState)
    }

    override fun onBackPressed() {
        val currentStepPosition = stepperLayout.currentStepPosition
        if (currentStepPosition > 0) {
            stepperLayout.onBackClicked()
        } else {
            finish()
        }
    }

    /**Used to handle BLE scan for devices and */
    override fun onCompleted(completeButton: View) {
//        toast("onCompleted!")
        val startIntent = PathRecorderActivity.getStartIntent(this, "test")
        startActivity(startIntent)
        finish()
    }

    override fun onError(verificationError: VerificationError) {
        toast("onError! -> ${verificationError.errorMessage}")
    }

    override fun onStepSelected(newStepPosition: Int) {
//        toast("onStepSelected! -> " + newStepPosition)
    }

    override fun onReturn() {
        finish()
    }

    override fun onChangeEndButtonsEnabled(enabled: Boolean) {
        stepperLayout.setNextButtonVerificationFailed(!enabled)
        stepperLayout.setCompleteButtonVerificationFailed(!enabled)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
}



