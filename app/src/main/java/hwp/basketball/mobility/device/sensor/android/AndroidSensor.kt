package hwp.basketball.mobility.device.sensor.android

import android.content.Context
import android.content.SharedPreferences
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import hwp.basketball.mobility.device.sensor.BaseSensor

/**
 * Created by dusan_cvetkovic on 3/4/17.
 */

class AndroidSensor(context: Context, val prefs: SharedPreferences) : BaseSensor(), SensorEventListener {
    override fun unSubscribeFromAccChange() {
        val sensor =
                sm.getDefaultSensor(android.hardware.Sensor.TYPE_ACCELEROMETER)
                        ?: throw RuntimeException("No acc available !")
        sm.unregisterListener(this, sensor)
    }

    override fun unSubscribeFromMagnetometerChange() {
        val magnetometerSensor =
                sm.getDefaultSensor(android.hardware.Sensor.TYPE_MAGNETIC_FIELD)
                        ?: throw RuntimeException("No magnetometer available !")
        sm.unregisterListener(this, magnetometerSensor)
    }

    override fun unSubscribeFromGyroChange() {
        val magnetometerSensor =
                sm.getDefaultSensor(android.hardware.Sensor.TYPE_GYROSCOPE)
                        ?: throw RuntimeException("No gyro available !")
        sm.unregisterListener(this, magnetometerSensor)
    }

    override fun getSharedPrefs(): SharedPreferences {
        return prefs
    }

    override fun subscribeToMagnetometerChange() {
        val sensor =
                sm.getDefaultSensor(android.hardware.Sensor.TYPE_MAGNETIC_FIELD)
                        ?: throw RuntimeException("No magnetometer available !")
        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST)
    }

    override fun subscribeToAccChange() {
        val sensor =
                sm.getDefaultSensor(android.hardware.Sensor.TYPE_ACCELEROMETER)
                        ?: throw RuntimeException("No acc available !")
        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST)
    }

    override fun subscribeToGyroChange() {
        val sensor =
                sm.getDefaultSensor(android.hardware.Sensor.TYPE_GYROSCOPE)
                        ?: throw RuntimeException("No gyro available !")
        sm.registerListener(this, sensor, SensorManager.SENSOR_DELAY_FASTEST)
    }

    override fun getName(): String {
        return AndroidSensor::class.java.simpleName
    }

    override fun connectTo(deviceID: String) {

    }

    override fun disconnect() {
        sm.unregisterListener(this)
    }

    override fun onAccuracyChanged(sensor: android.hardware.Sensor?, accuracy: Int) {

    }

    override fun onSensorChanged(event: SensorEvent?) {
        event?.let { e ->
            if (e.sensor.type == Sensor.TYPE_MAGNETIC_FIELD) {
                for (i in mMagnetometerReading.indices) {
                    mMagnetometerReading[i] = event.values[i]
                }
                magnetometerListener?.onMagnetometerDataUpdate(mMagnetometerReading)
            } else if (e.sensor.type == Sensor.TYPE_ACCELEROMETER) {
                for (i in mAccelerometerReading.indices) {
                    mAccelerometerReading[i] = event.values[i]
                }
                accelerometerListener?.onAccelerometerDataUpdate(mAccelerometerReading)
            } else if (e.sensor.type == Sensor.TYPE_GYROSCOPE) {
                for (i in mGyroReading.indices) {
                    mGyroReading[i] = event.values[i]
                }
                gyroListener?.onGyroDataUpdate(mGyroReading)
            } else {

            }
        }

    }

    private var sm: SensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager

    override fun isConnectable(): Boolean {
        return false
    }

}