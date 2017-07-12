package hwp.basketball.mobility.device.sensor.test

import android.content.Context
import android.os.Environment
import com.google.common.base.Charsets
import com.google.common.io.Files
import com.google.gson.Gson
import hwp.basketball.mobility.device.sensor.BaseSensor
import java.io.File
import java.io.IOException
import java.util.*

/**
 * Sensor implementation intended to be used in instrumented tests.
 *
 */
class MockedSensor(context: Context)
    : BaseSensor() {
    override fun subscribeForUpdates() {

    }

    override fun disconnect() {

    }


    fun getFile(clazz: Class<*>, filename: String): File {
        return File(Environment.getExternalStorageDirectory(), filename)
    }

    @Throws(IOException::class)
    private fun getSamplesFromFile(filename: String): List<TestData> {
        val file = getFile(this.javaClass, filename)
        val jsonLine = Files.readFirstLine(file, Charsets.UTF_8)
        val samples = Gson().fromJson<Array<TestData>>(jsonLine, Array<TestData>::class.java)
        return Arrays.asList<TestData>(*samples)
    }

    init {
        val samplesArray = getSamplesFromFile("test_data_1495344772294")
        println(samplesArray.size)
//        samplesArray.stream()
//                .forEach({ (f, sample) ->
//                    when (f) {
//                        "Acceleration" -> {
//                            for (i in mAccelerometerReading.indices) {
//                                mAccelerometerReading[i] = SensorManager.STANDARD_GRAVITY * sample.data[i].toFloat() / 1000
//                            }
//                            accelerometerListener?.onAccelerometerDataUpdate(mAccelerometerReading, sample.timestamp)
//                        }
//                        "Pedometer" -> {
//                            stepListener?.onStepDataUpdate(StepData(FeaturePedometer.getSteps(sample).toInt(),
//                                    FeaturePedometer.getFrequency(sample)))
//                            //                stepListener?.onStepDataUpdate(FeaturePedometer.getFrequency(sample))
//                        }
//                        "Compass" -> {
//                            angleListener?.onAngleDataUpdate(FeatureCompass.getCompass(sample))
//                        }
//                    }
//                })

    }


    override fun connectTo(deviceID: String) {

    }

    override fun getName(): String {
        return "TestSensor"
    }

    override val isConnectable: Boolean
        get() {
            return false
        }
}