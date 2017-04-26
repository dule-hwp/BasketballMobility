package hwp.basketball.mobility.dagger

import dagger.Binds
import dagger.Module
import hwp.basketball.mobility.drillpreparation.step.connectplayers.ConnectPlayersContract
import hwp.basketball.mobility.drillpreparation.step.connectplayers.ConnectPlayersPresenter
import hwp.basketball.mobility.drillpreparation.step.selectdrill.DrillsContract
import hwp.basketball.mobility.drillpreparation.step.selectdrill.DrillsPresenter
import hwp.basketball.mobility.drillpreparation.step.selectplayers.PlayersContract
import hwp.basketball.mobility.drillpreparation.step.selectplayers.PlayersPresenter

/**
 * Created by dusan_cvetkovic on 4/2/17.
 */
@Module
abstract class FragmentsContractsBindModule {
    @Binds
    abstract fun bindPlayersPresenter(playersPresenter: PlayersPresenter): PlayersContract.Presenter

    @Binds
    abstract fun bindDrillsPresenter(drillsPresenter: DrillsPresenter): DrillsContract.Presenter

    @Binds
    abstract fun bindConnectPlayersPresenter(connectPlayersPresenter: ConnectPlayersPresenter)
            : ConnectPlayersContract.Presenter
}