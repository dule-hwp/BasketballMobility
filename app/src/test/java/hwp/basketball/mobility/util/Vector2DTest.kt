package hwp.basketball.mobility.util

import org.junit.Test

import org.junit.Assert.*
import timber.log.Timber

/**
 * Created by dusan_cvetkovic on 6/9/17.
 */
class Vector2DTest {
    @Test
    fun angleBetweenTwoPoints() {
        assertEquals(90, Vector2D.angleBetweenTwoPoints(PointF(2f, 3f), PointF(2f, 10f)))
    }

    @Test
    fun angleBetweenTwoPoints2() {
        assertEquals(90, Vector2D.angleBetweenTwoVectors(PointF(2f, 3f), PointF(2f, 10f)))
        assertEquals(45, Vector2D.angleBetweenTwoVectors(PointF(3f, 3f), PointF(10f, 10f)))
        assertEquals(-135, Vector2D.angleBetweenTwoVectors(PointF(10f, 10f), PointF(3f, 3f)))
        assertEquals(-45, Vector2D.angleBetweenTwoVectors(PointF(10f, 10f), PointF(15f, 5f)))
        assertNotEquals(45, Vector2D.angleBetweenTwoVectors(PointF(3f, 3f), PointF(11f, 10f)))
    }

    @Test
    fun distance() {
        val distance = Vector2D.distance(floatArrayOf(0f, 0f), floatArrayOf(1f, 1f))
        assertEquals(1.41f, distance, 0.1f)
    }

    @Test
    fun distanceCheck() {
        val start = PointF(1f,1f)
        val end = PointF(5f,5f)
        val angle = start.getAngle(end)
//        assertEquals(1.41, angle, 0.1)
        println("angle: $angle")
        val dist = Math.cos(angle) * Vector2D.distance(start, end)
        println("distance: $dist")
        assertEquals(1.41, dist, 0.1)
    }
}