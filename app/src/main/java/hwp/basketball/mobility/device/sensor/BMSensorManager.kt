package hwp.basketball.mobility.device.sensor

import hwp.basketball.mobility.device.sensor.BaseSensor.SensorStateChangedCallback
import io.reactivex.Observable


/**
 * Created by dusan_cvetkovic on 4/7/17.
 *
 */
class BMSensorManager(val sensor: BaseSensor, val callback: IBMSensorManager.Callback?) : IBMSensorManager, SensorStateChangedCallback {

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
        return Observable.create { emitter ->
            sensor.accelerometerListener = object : BaseSensor.AccelerometerDataChangedCallback {
                override fun onAccelerometerDataUpdate(data: FloatArray, timestamp: Long) {
                    emitter.onNext(AccData(data, timestamp))
                }
            }
        }
    }

    fun observeMagSensorChanged(): Observable<FloatArray> {
        return Observable.create { emitter ->
            sensor.magnetometerListener = object : BaseSensor.MagnetometerDataChangedCallback {
                override fun onMagnetometerDataUpdate(data: FloatArray) {
                    emitter.onNext(data)
                }
            }
        }
    }

    fun observeGyroSensorChanged(): Observable<FloatArray> {
        return Observable.create { emitter ->
            sensor.gyroListener = object : BaseSensor.GyroDataChangedCallback {
                override fun onGyroDataUpdate(data: FloatArray) {
                    emitter.onNext(data)
                }
            }
        }
    }

    override fun observeStepsChanged(): Observable<BaseSensor.StepData> {
        return Observable.create { emitter ->
            sensor.stepListener = object : BaseSensor.StepDataChangedCallback {
                override fun onStepDataUpdate(data: BaseSensor.StepData) {
                    emitter.onNext(data)
                }
            }
        }
    }

    override fun observeAngleChanged(): Observable<Float> {
        return Observable.create { emitter ->
            sensor.angleListener = object : BaseSensor.AngleDataChangedCallback {
                override fun onAngleDataUpdate(data: Float) {
                    emitter.onNext(data)
                }
            }
        }
    }

    override fun observeMotionIntensityChanged(): Observable<Int> {
        return Observable.create { emitter ->
            sensor.motionListener = object : BaseSensor.MotionDataChangedCallback{
                override fun onMotionDataUpdate(data: Int) {
                    emitter.onNext(data)
                }
            }
        }
    }

    override fun connectTo(nodeTag: String) {
        sensor.connectTo(nodeTag)
    }

    override fun startSensorUpdates() {
        sensor.subscribeToAccChange()
        sensor.subscribeToMagnetometerChange()
        sensor.subscribeToGyroChange()
        sensor.subscribeToMotionChange()
        sensor.subscribeToAngleChangeChange()
        sensor.subscribeToSpeedChange()
    }

    override fun stopSensorUpdates() {
        sensor.unSubscribe()

    }

    override fun toString(): String {
        return sensor.getName()
    }

    override fun saveTestData(suffix: String): String? {
        return sensor.saveSensorData(suffix)

    }

    data class AccData(val data: FloatArray, val timestamp: Long)
}
