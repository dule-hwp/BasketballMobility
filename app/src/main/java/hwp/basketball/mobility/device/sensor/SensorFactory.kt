package hwp.basketball.mobility.device.sensor

import android.content.Context
import hwp.basketball.mobility.device.sensor.BaseSensor.*
import hwp.basketball.mobility.device.sensor.android.AndroidSensor
import hwp.basketball.mobility.device.sensor.sensortile.SensorTileSensor
import hwp.basketball.mobility.device.sensor.test.MockedSensor
import hwp.basketball.mobility.device.sensor.wicedsense.WicedSenseSensor
import timber.log.Timber

/**
 *
 * Created by dusan_cvetkovic on 5/28/17.
 */
class SensorFactory private constructor() {
    companion object{
        fun getSensor(type: Type, context: Context): BaseSensor {
            Timber.d("type: $type")
            return when (type) {
                Type.SENSOR_TILE -> SensorTileSensor(context)
                Type.ANDROID_DEVICE -> AndroidSensor(context)
                Type.MOCKED_SENSOR -> MockedSensor(context)
                Type.WICED_SENSE_SENSOR -> WicedSenseSensor(context)
            }
        }
    }

    enum class Type {
        MOCKED_SENSOR,
        SENSOR_TILE,
        ANDROID_DEVICE,
        WICED_SENSE_SENSOR
    }

}