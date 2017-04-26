package hwp.basketball.mobility.drillpreparation.step

import hwp.basketball.mobility.device.sensor.BaseSensor
import hwp.basketball.mobility.entitiy.drills.DrillViewModel
import hwp.basketball.mobility.entitiy.player.PlayerViewModel

/**
 * Created by dusan_cvetkovic on 4/9/17.
 * This singleton instance will be used for each time we go through setup.
 *
 * It should be used to pass data between setup and actual drill mode.
 *
 * Make sure you call reset method before starting setup activity.
 */
object DrillSetupOutput {
    val players: MutableList<PlayerViewModel> = mutableListOf()
    var drill: DrillViewModel? = null
    var connectMap: HashMap<PlayerViewModel, SensorConnectionData> = hashMapOf()

    override fun toString(): String {
//        connectMap.put(players[0],"tile")
        var output = ""
        for (player in players)
            output += "${player.firstName} ${player.lastName} is connected via ${connectMap[player]}\n"
        output+="Drill selected: ${drill?.name}"
        return output
    }

    fun reset() {
        players.clear()
        drill= null
        connectMap.clear()
    }

    data class SensorConnectionData(val type:BaseSensor.Type, val name:String = "")
}