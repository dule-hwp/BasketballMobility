package hwp.basketball.mobility.dagger

import dagger.Module
import dagger.Provides
import hwp.basketball.mobility.drillpreparation.step.selectplayers.PlayerDialog
import hwp.basketball.mobility.drillpreparation.DrillSetupActivity
import hwp.basketball.mobility.drillpreparation.step.selectplayers.PlayersContract

/**
 * Created by dusan_cvetkovic on 4/2/17.
 */
@Module
class DrillSetupActivityModule(val activityContext: DrillSetupActivity) {

    @Provides
    @DrillSetupActivityScope
    fun provideContext(): DrillSetupActivity {
        return activityContext
    }

    @Provides
    @DrillSetupActivityScope
    fun providePlayersDialog(presenter: PlayersContract.Presenter): PlayerDialog {
        return PlayerDialog(activityContext, presenter)
    }
}