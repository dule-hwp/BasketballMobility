package hwp.basketball.mobility.util

import org.junit.Test

import org.junit.Assert.assertEquals

/**
 *
 * Created by dusan_cvetkovic on 6/8/17.
 */
open class Geometry2DTest {
    @Test
    open fun distance() {
        val distance = Geometry2D.distance(PointF(3f, 2f), PointF(7f, 2f), PointF(5f, 6f))
        assertEquals(4.0, distance, 0.1)
    }

    @Test
    fun distance2() {
        val distance = Geometry2D.distance2(PointF(3f, 2f), PointF(7f, 2f), PointF(5f, 6f))
        assertEquals(4.0, distance, 0.1)
    }


}