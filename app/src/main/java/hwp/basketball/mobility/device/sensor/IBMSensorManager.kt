package hwp.basketball.mobility.device.sensor

import android.content.Context
import io.reactivex.Observable

/**
 *
 * Created by dusan_cvetkovic on 5/21/17.
 */
interface IBMSensorManager {
    fun observeAccSensorChanged(): Observable<BMSensorManager.AccData>
    fun observeAngleChanged(): Observable<Float>
    fun observeIsMoving(): Observable<Boolean>
    fun connectTo(nodeTag: String)
    fun startSensorUpdates()
    fun stopSensorUpdates()

    interface Callback{
        fun onSensorConnected(name: IBMSensorManager)
        fun onSensorDisconnected(bmSensorManager: IBMSensorManager)
    }
}