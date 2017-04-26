package hwp.basketball.mobility

//import de.jodamob.kotlin.testrunner.KotlinTestRunner
//import de.jodamob.kotlin.testrunner.OpenedPackages
import hwp.basketball.mobility.device.sensor.BaseSensor
import hwp.basketball.mobility.pathrecorder.PathRecorderContract
import hwp.basketball.mobility.pathrecorder.PathRecorderPresenter
import hwp.basketball.mobility.pathrecorder.sketchview.SketchView
import hwp.basketball.mobility.pathrecorder.sketchview.SketchViewPresenter
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.`when`
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
        val view = mock<SketchView>(SketchView::class.java)
        val prv = mock<PathRecorderContract.View>(PathRecorderContract.View::class.java)

        val sensor = mock<BaseSensor>(BaseSensor::class.java)
        Mockito.`when`(sensor.loadCalibrationData()).thenReturn(null)

        val sketchViewPresenter = SketchViewPresenter(view)
        val pathRecorderPresenter = PathRecorderPresenter(prv)
//        assertEquals(sketchViewPresenter.isSensorSet(), false)
//        sketchViewPresenter.addAngleChangeListener(sensor)
//        sketchViewPresenter.calibrationComplete(floatArrayOf(200f,2f,202f,3f))
//        assertEquals(sketchViewPresenter.isSensorSet(), true)
    }
}