package hwp.basketball.mobility.util

import android.content.Context
import android.content.Intent
import hwp.basketball.mobility.device.sensor.BaseSensor
import hwp.basketball.mobility.drillpreparation.step.DrillSetupOutput
import hwp.basketball.mobility.entitiy.drills.DrillViewModel
import hwp.basketball.mobility.entitiy.player.PlayerViewModel
import hwp.basketball.mobility.pathrecorder.PathRecorderActivity

/**
 * Created by dusan_cvetkovic on 6/24/17.
 */
object TestUtil {
    fun getSkipToDrawIntent(tag: String?, context: Context): Intent {
        val startIntent = PathRecorderActivity.getStartIntent(context, "test")
        val playerViewModel = PlayerViewModel(height = "180")
        DrillSetupOutput.players.add(playerViewModel)
        DrillSetupOutput.drill = DrillViewModel.getComplexTestDrill("test")
        if (tag == null)
            DrillSetupOutput.connectMap.put(playerViewModel,
                    DrillSetupOutput.SensorConnectionData(BaseSensor.Type.ANDROID_DEVICE))
        else
            DrillSetupOutput.connectMap.put(playerViewModel,
                    DrillSetupOutput.SensorConnectionData(BaseSensor.Type.SENSOR_TILE, tag))
        return startIntent
    }

}