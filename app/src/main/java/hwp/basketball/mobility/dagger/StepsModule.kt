package hwp.basketball.mobility.dagger

import dagger.Module
import dagger.Provides
import hwp.basketball.mobility.drillpreparation.step.connectplayers.ConnectPlayersContract
import hwp.basketball.mobility.drillpreparation.step.connectplayers.ConnectPlayersFragment
import hwp.basketball.mobility.drillpreparation.step.selectdrill.DrillsContract
import hwp.basketball.mobility.drillpreparation.step.selectplayers.PlayersContract

/**
 * Created by dusan_cvetkovic on 4/3/17.
 */
@Module
class StepsModule(val playerView: PlayersContract.View,
                  val drillView: DrillsContract.View,
                  val connectPlayersView: ConnectPlayersContract.View) {
    @Provides
    @DrillSetupActivityScope
    fun providePlayersView(): PlayersContract.View {
        return playerView
    }

    @Provides
    @DrillSetupActivityScope
    fun provideDrillView(): DrillsContract.View {
        return drillView
    }

    @Provides
    @DrillSetupActivityScope
    fun provideConnectPlayerView(): ConnectPlayersContract.View {
        return connectPlayersView
    }
}