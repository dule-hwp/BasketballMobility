package hwp.basketball.mobility.dagger

import dagger.Component
import hwp.basketball.mobility.device.sensor.BMSensorManager
import hwp.basketball.mobility.drill.create.DrillActivityPresenter
import hwp.basketball.mobility.drillpreparation.step.selectdrill.DrillsPresenter
import hwp.basketball.mobility.pathrecorder.PathRecorderPresenter

/**
 * Created by dusan_cvetkovic on 3/31/17.
 */
@BasketballMobilityAppScope
@Component(modules = arrayOf(ContextModule::class, SensorPrefsModule::class))
interface BasketballMobilityAppComponent {
    fun inject(pathRecorderPresenter: BMSensorManager)
}