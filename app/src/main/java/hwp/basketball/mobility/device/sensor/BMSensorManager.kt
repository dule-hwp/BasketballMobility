package hwp.basketball.mobility.device.sensor

import hwp.basketball.mobility.device.sensor.BaseSensor.SensorStateChangedCallback
import io.reactivex.Observable


/**
 * Created by dusan_cvetkovic on 4/7/17.
 *
 */
class BMSensorManager(val sensor: BaseSensor, val callback: IBMSensorManager.Callback?)
    : IBMSensorManager, SensorStateChangedCallback {

    init {
        sensor.addStateListener(this)
    }

    override fun onStateConnected(name: String) {
        callback?.onSensorConnected(this)
    }

    override fun onStateDisconnected() {
        callback?.onSensorDisconnected(this)
    }

    override fun observeAccSensorChanged(): Observable<AccData> {
        return sensor.accelerometerObservable
    }

    override fun observeAngleChanged(): Observable<Float> {
        return sensor.angleObservable
    }

    override fun observeIsMoving(): Observable<Boolean> {
        return sensor.motionObservable
    }

    override fun connectTo(nodeTag: String) {
        sensor.connectTo(nodeTag)
    }

    override fun startSensorUpdates() {
        sensor.subscribeForUpdates()
    }

    override fun stopSensorUpdates() {
        sensor.disconnect()
    }

    override fun toString(): String {
        return sensor.getName()
    }

    data class AccData(val data: FloatArray, val timestamp: Long)
}
