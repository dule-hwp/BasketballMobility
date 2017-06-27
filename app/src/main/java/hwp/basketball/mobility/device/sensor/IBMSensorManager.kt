package hwp.basketball.mobility.device.sensor

import io.reactivex.Observable

/**
 *
 * Created by dusan_cvetkovic on 5/21/17.
 */
interface IBMSensorManager {
    fun observeAccSensorChanged(): Observable<BMSensorManager.AccData>
    fun observeStepsChanged(): Observable<BaseSensor.StepData>
    fun observeAngleChanged(): Observable<Float>
    fun observeMotionIntensityChanged(): Observable<Int>
    fun connectTo(nodeTag: String)
    fun startSensorUpdates()
    fun stopSensorUpdates()
    fun saveTestData(suffix: String): String?
//    fun setSensor(type: BaseSensor)

    interface Callback{
        fun onSensorConnected(name: IBMSensorManager)
        fun onSensorDisconnected(bmSensorManager: IBMSensorManager)
    }
}