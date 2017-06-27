package hwp.basketball.mobility

//import de.jodamob.kotlin.testrunner.KotlinTestRunner
//import de.jodamob.kotlin.testrunner.OpenedPackages
import hwp.basketball.mobility.device.sensor.BaseSensor
import hwp.basketball.mobility.pathrecorder.PathRecorderActivityContract
import hwp.basketball.mobility.pathrecorder.sketchview.SensorDrawingView
import hwp.basketball.mobility.pathrecorder.sketchview.SensorDrawingViewPresenter
import org.junit.Assert.assertEquals
import org.junit.Test
import org.mockito.Mockito.mock


/**
 * Example local unit test, which will execute on the development machine (host).

 * @see [Testing documentation](http://d.android.com/tools/testing)
 */
//@RunWith(KotlinTestRunner::class)
//@OpenedPackages("hwp.sensordrawpath")
class SKetchPresenterTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, (2 + 2).toLong())
    }
    @Test
    fun presenter_isCorrect() {
        val view = mock<SensorDrawingView>(SensorDrawingView::class.java)
        val prv = mock<PathRecorderActivityContract.View>(PathRecorderActivityContract.View::class.java)

        val sensor = mock<BaseSensor>(BaseSensor::class.java)
//        Mockito.`when`(sensor.loadCalibrationData()).thenReturn(null)

//        val sketchViewPresenter = SensorDrawingViewPresenter(view, sensor, this)
//        assertEquals(sketchViewPresenter.isSensorSet(), false)
//        sketchViewPresenter.addAngleChangeListener(sensor)
//        sketchViewPresenter.calibrationComplete(floatArrayOf(200f,2f,202f,3f))
//        assertEquals(sketchViewPresenter.isSensorSet(), true)
    }
}