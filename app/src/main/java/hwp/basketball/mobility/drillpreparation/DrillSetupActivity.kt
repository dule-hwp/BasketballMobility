package hwp.basketball.mobility.drillpreparation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.stepstone.stepper.StepperLayout
import com.stepstone.stepper.VerificationError
import hwp.basketball.mobility.R
import hwp.basketball.mobility.dagger.DaggerDrillSetupActivityComponent
import hwp.basketball.mobility.dagger.DrillSetupActivityComponent
import hwp.basketball.mobility.dagger.DrillSetupActivityModule
import hwp.basketball.mobility.dagger.StepsModule
import hwp.basketball.mobility.drillpreparation.step.DrillSetupOutput
import hwp.basketball.mobility.drillpreparation.step.connectplayers.ConnectPlayersFragment
import hwp.basketball.mobility.drillpreparation.step.review.ReviewFragment
import hwp.basketball.mobility.drillpreparation.step.selectdrill.DrillsFragment
import hwp.basketball.mobility.drillpreparation.step.selectplayers.PlayersFragment
import hwp.basketball.mobility.pathrecorder.PathRecorderActivity
import kotlinx.android.synthetic.main.activity_drill_setup.*
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

open class DrillSetupActivity : AppCompatActivity(),
        StepperLayout.StepperListener, OnNavigationBarListener {



    companion object {
        fun getStartIntent(context: Context): Intent {
            DrillSetupOutput.reset()
            return Intent(context, DrillSetupActivity::class.java)
        }

        private val CURRENT_STEP_POSITION_KEY = "position"
        val TAG: String = "DrillSetupActivity"
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    lateinit var drillSetupActivityComponent: DrillSetupActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val playersFragment = PlayersFragment.newInstance()
        val connectPlayersFragment = ConnectPlayersFragment.newInstance()
        val drillsFragment = DrillsFragment.newInstance()
        val reviewFragment = ReviewFragment.newInstance()

        drillSetupActivityComponent = DaggerDrillSetupActivityComponent.builder()
                .drillSetupActivityModule(DrillSetupActivityModule(this))
                .stepsModule(StepsModule(playersFragment, drillsFragment, connectPlayersFragment))
                .build()

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

    override fun onCompleted(completeButton: View) {
        Toast.makeText(this, "onCompleted!", Toast.LENGTH_SHORT).show()
        val startIntent = PathRecorderActivity.getStartIntent(this, "test")
        startActivity(startIntent)
        finish()
    }

    override fun onError(verificationError: VerificationError) {
        Toast.makeText(this, "onError! -> " + verificationError.errorMessage, Toast.LENGTH_SHORT).show()
    }

    override fun onStepSelected(newStepPosition: Int) {
        Toast.makeText(this, "onStepSelected! -> " + newStepPosition, Toast.LENGTH_SHORT).show()
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



