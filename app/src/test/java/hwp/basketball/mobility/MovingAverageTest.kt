package hwp.basketball.mobility

import hwp.basketball.mobility.util.MovingAverage
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 *
 * Created by dusan_cvetkovic on 5/4/17.
 */
class MovingAverageTest {

    private lateinit var movingAverage: MovingAverage

    @Before
    @Throws(Exception::class)
    fun setUp() {
        movingAverage = MovingAverage(5)
    }

    @Test
    @Throws(Exception::class)
    fun getAvg() {
        assertEquals(movingAverage.avg, 0.0, 0.0)
    }

    @Test
    @Throws(Exception::class)
    operator fun next() {
        assertEquals(movingAverage.next(10), 10.0, 0.1)
        assertEquals(movingAverage.next(5), 7.5, 0.1)
        assertEquals(movingAverage.next(6), 7.0, 0.1)
        assertEquals(movingAverage.next(7), 7.0, 0.1)
        assertEquals(movingAverage.next(12), 8.0, 0.1)

        assertEquals(movingAverage.next(0), 6.0, 0.1)
        assertEquals(movingAverage.next(10), 7.0, 0.1)
        assertEquals(movingAverage.avg, 7.0, 0.1)
    }

    @Test
    @Throws(Exception::class)
    fun nextWithSkipShouldSkipValues() {
        val movingAverageWithSkipSet = MovingAverage(5, 4)

        assertEquals(movingAverageWithSkipSet.next(1012), 0.0, 0.1)
        assertEquals(movingAverageWithSkipSet.next(5123), 0.0, 0.1)
        assertEquals(movingAverageWithSkipSet.next(6123), 0.0, 0.1)
        assertEquals(movingAverageWithSkipSet.next(7123), 0.0, 0.1)
        assertEquals(movingAverageWithSkipSet.next(12), 12.0, 0.1)

        assertEquals(movingAverageWithSkipSet.next(0), 6.0, 0.1)
        assertEquals(movingAverageWithSkipSet.next(9), 7.0, 0.1)
        assertEquals(movingAverageWithSkipSet.avg, 7.0, 0.1)

        movingAverageWithSkipSet.next(1)
        movingAverageWithSkipSet.next(2)
        movingAverageWithSkipSet.next(3)
        movingAverageWithSkipSet.next(4)
        movingAverageWithSkipSet.next(5)
        assertEquals(movingAverageWithSkipSet.avg, 3.0, 0.1)
    }

    @Test
    @Throws(Exception::class)
    fun roundingShouldRoundNegativesProperly() {
        val movingAverage = MovingAverage(3)
        movingAverage.next(-2)
        movingAverage.next(-9)
        movingAverage.next(6)

        assertEquals(movingAverage.avg, -1.66, 0.1)
        assertEquals(movingAverage.avg.toInt(), -1)

        val movingAverage1 = MovingAverage(2)
        movingAverage1.next(3)
        movingAverage1.next(3)
        movingAverage1.next(2)
        assertEquals(movingAverage1.avg.toInt(), 2)
    }

    @Test
    @Throws(Exception::class)
    fun testIntCast() {
        assertEquals(-1, -1.66.toInt())

    }
}