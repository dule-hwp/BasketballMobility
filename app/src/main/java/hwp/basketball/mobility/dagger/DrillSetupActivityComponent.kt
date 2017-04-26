package hwp.basketball.mobility.dagger

import dagger.Component
import hwp.basketball.mobility.drillpreparation.step.connectplayers.ConnectPlayersFragment
import hwp.basketball.mobility.drillpreparation.step.selectdrill.DrillsFragment
import hwp.basketball.mobility.drillpreparation.step.selectplayers.PlayersFragment

/**
 * Created by dusan_cvetkovic on 3/31/17.
 */
@DrillSetupActivityScope
@Component(modules = arrayOf(DrillSetupActivityModule::class,
        StepsModule::class,
        FragmentsContractsBindModule::class))
interface DrillSetupActivityComponent {
    fun inject(fragment: PlayersFragment)
    fun inject(fragment: DrillsFragment)
    fun inject(fragment: ConnectPlayersFragment)
}