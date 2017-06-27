package hwp.basketball.mobility.util

import android.support.test.filters.SmallTest
import android.support.test.runner.AndroidJUnit4
import io.reactivex.disposables.CompositeDisposable
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import timber.log.Timber

/**
 * Created by dusan_cvetkovic on 6/19/17.
 */
@SmallTest
@RunWith(AndroidJUnit4::class)
class Geometry2DAndroidTest {

    private lateinit var compositeDisposable: CompositeDisposable

    @Before
    fun setUp() {
        compositeDisposable = CompositeDisposable()
    }

    @Test
    fun getAreaForBitmap() {
        val bitmap = PhoneStorage.getBitmap("15:47:03.243-PerformedDrill.png")
        bitmap?.let {
            val disposable = Geometry2D.getAreaForBitmap(bitmap)
                    .subscribe({ (progress, score) ->
                        println("prog: $progress area: $score")
                        if (progress==100){
                            assertEquals(7500, score)
                        }
                    }, {
                        println(it)
                    })
            compositeDisposable.add(disposable)
        }
    }

    @Test
    fun getAreaForNoErrorBitmap() {
        val bitmap = PhoneStorage.getBitmap("drillPath-noerr.png")
        bitmap?.let {
            val disposable = Geometry2D.getAreaForBitmap(bitmap)
                    .subscribe({ (progress, score) ->
                        println("prog: $progress area: $score")
                        if (progress==100){
                            assertEquals(7500, score)
                        }
                    }, {
                        println(it)
                    })
            compositeDisposable.add(disposable)
        }
    }


    @After
    fun tearDown() {
        compositeDisposable.clear()
    }

    //    @Test
//    fun pathArea() {
//        val path = Path()
//        path.moveTo(PointF(1f, 1f))
//        path.lineTo(PointF(5f, 0f))
//        path.lineTo(PointF(5f, 5f))
//        path.lineTo(PointF(1f, 1f))
////        path.close()
//
//        val region = Region()
//        region.setPath(path, Region(0, 7, 7, 0))
//        val area = Geometry2D.calculateArea(region)
//        assertEquals(25f, area, 0.1f)
//    }


}