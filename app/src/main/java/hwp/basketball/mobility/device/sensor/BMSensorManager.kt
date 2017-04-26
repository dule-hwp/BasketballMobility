package hwp.basketball.mobility.device.sensor

import android.content.Context
import android.content.SharedPreferences
import hwp.basketball.mobility.device.sensor.android.AndroidSensor
import hwp.basketball.mobility.device.sensor.sensortile.SensorTileSensor
import io.reactivex.Observable
import javax.inject.Inject


/**
 * Created by dusan_cvetkovic on 4/7/17.
 *
 */
class BMSensorManager(val sensorStateCallback: BaseSensor.SensorStateChangedCallback) {

    @Inject
    lateinit var context: Context

    @Inject
    lateinit var prefs: SharedPreferences

    private var sensor: BaseSensor? = null

    fun setupSensor(type: BaseSensor.Type) {
        when (type) {
            BaseSensor.Type.SENSOR_TILE -> {
                sensor = SensorTileSensor(sensorStateCallback, context, prefs)
            }
            BaseSensor.Type.ANDROID_DEVICE -> {
                sensor = AndroidSensor(context, prefs)
            }
        }
    }

    fun observeAccSensorChanged(): Observable<FloatArray> {
        return Observable.create { emitter ->
            sensor?.accelerometerListener = object : BaseSensor.AccelerometerDataChangedCallback {
                override fun onAccelerometerDataUpdate(data: FloatArray) {
                    emitter.onNext(data)
                }
            }
            if (sensor==null)
                emitter.onError(IllegalStateException("sensor is null"))
        }
    }

    fun observeMagSensorChanged(): Observable<FloatArray> {
        return Observable.create { emitter ->
            sensor?.magnetometerListener = object : BaseSensor.MagnetometerDataChangedCallback {
                override fun onMagnetometerDataUpdate(data: FloatArray) {
                    emitter.onNext(data)
                }
            }
            if (sensor==null)
                emitter.onError(IllegalStateException("sensor is null"))
        }
    }

    fun observeGyroSensorChanged(): Observable<FloatArray> {
        return Observable.create { emitter ->
            sensor?.gyroListener = object : BaseSensor.GyroDataChangedCallback {
                override fun onGyroDataUpdate(data: FloatArray) {
                    emitter.onNext(data)
                }
            }
            if (sensor==null)
                emitter.onError(IllegalStateException("sensor is null"))
        }
    }

    fun connectTo(nodeTag: String) {
        sensor?.connectTo(nodeTag)
    }

    fun startSensorUpdates() {
        sensor?.subscribeToAccChange()
        sensor?.subscribeToMagnetometerChange()
        sensor?.subscribeToGyroChange()
    }

    fun stopSensorUpdates() {
        sensor?.unSubscribeFromAccChange()
        sensor?.unSubscribeFromMagnetometerChange()
        sensor?.unSubscribeFromGyroChange()
    }

    override fun toString(): String {
        return sensor?.getName() ?: "Unknown device"
    }

}