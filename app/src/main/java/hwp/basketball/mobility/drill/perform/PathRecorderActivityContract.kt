package hwp.basketball.mobility.drill.perform

import hwp.basketball.mobility.BasePresenter
import hwp.basketball.mobility.entitiy.drills.outcomes.DrillOutcome

/**
 * Created by dusan_cvetkovic on 3/5/17.
 */

interface PathRecorderActivityContract {
    interface View {
        fun onDrillFinished()
        fun displayStats(statistics: String)
        fun displayOutcome(outcome: DrillOutcome)
        fun showScoreProgress(message: String)
        fun hideProgress()
        fun showError(message: String)
        fun updateScoreProgress(progress: Int)
        fun showProgress(message: String)
        fun showMessage(message: String)
        fun onRecordingModeChange(isInRecordingMode: Boolean)
    }

    interface Presenter: BasePresenter {

    }
}
