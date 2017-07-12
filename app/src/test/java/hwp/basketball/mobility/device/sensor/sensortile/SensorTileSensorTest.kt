package hwp.basketball.mobility.device.sensor.sensortile

import com.google.common.base.Charsets
import com.google.common.io.Files
import com.google.gson.Gson
import com.st.BlueSTSDK.Features.FeaturePedometer
import hwp.basketball.mobility.device.sensor.test.TestData
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import java.io.File
import java.io.IOException
import java.util.*

/**
 *
 * Created by dusan_cvetkovic on 5/20/17.
 */
class SensorTileSensorTest {
    private lateinit var samplesArray: List<TestData>

    @Before
    fun setUp() {
        samplesArray = getSamplesFromFile("test_data_1495344772294")
    }

    @Test
    fun onUpdate() {

    }

    @Throws(IOException::class)
    private fun getSamplesFromFile(filename: String): List<TestData> {
        val file = getFile(this.javaClass, filename)
        val jsonLine = Files.readFirstLine(file, Charsets.UTF_8)
        val samples = Gson().fromJson<Array<TestData>>(jsonLine, Array<TestData>::class.java)
        return Arrays.asList<TestData>(*samples)
    }

    @Test
    @Throws(Exception::class)
    fun confirmThatSampleDataIsLoaded() {
        assertTrue(samplesArray[0].sample.data[0].toShort() == (-66).toShort())
        assertTrue(samplesArray[0].sample.data[1].toShort() == 36.toShort())
        assertTrue(samplesArray[0].sample.data[2].toShort() == 1010.toShort())
    }

    @Test
    fun confirmDataLength() {

        val lengthMilis = samplesArray.last().sample.timestamp - samplesArray.first().sample.timestamp
        val lengthSec = lengthMilis / 1000
        println(lengthMilis)
        println(lengthSec)
    }

    @Test
    fun testLastStep() {
        samplesArray.stream()
                .filter { (featureName) ->
                    featureName == "Pedometer"
                }
                .map { (_, sample) ->
                    val frequency = FeaturePedometer.getFrequency(sample)
                    val steps = FeaturePedometer.getSteps(sample)
                    Pair(frequency, steps)
                }
                .forEach({ (f, s) ->
                    println("Frequency: $f Steps: $s")
                })
//        println(count)

    }

    fun getFile(clazz: Class<*>, filename: String): File {
        return File(clazz.classLoader.getResource(filename).path)
    }

}