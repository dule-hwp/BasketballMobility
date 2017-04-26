package hwp.basketball.mobility.pathrecorder

import hugo.weaving.DebugLog
import hwp.basketball.mobility.device.sensor.BMSensorManager
import hwp.basketball.mobility.device.sensor.BaseSensor
import javax.inject.Inject

/**
 * Created by dusan_cvetkovic on 3/5/17.
 */

class PathRecorderPresenter(val view: PathRecorderContract.View?) :
        PathRecorderContract.Presenter,
        BaseSensor.SensorStateChangedCallback {
    override fun attach() {

    }

    override fun detach() {

    }

    private var sensorManager: BMSensorManager? = null

    fun addSensorManager(manager: BMSensorManager) {
        sensorManager = manager
    }

    override fun onStateConnected(name: String) {
        sensorManager?.let {
            view?.onSensorConnected(it)
        }
    }

    override fun onStateDisconnected() {
        view?.onSensorDisconnected()
    }

    override fun connectToTag(nodeTag: String) {
        sensorManager?.connectTo(nodeTag)
    }
}
