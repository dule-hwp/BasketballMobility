package hwp.basketball.mobility.util

import java.util.LinkedList

class MovingAverage
/**
 * Initialize your data structure here.
 */
@JvmOverloads constructor(internal var size: Int, private var skip: Int = 0) {
    internal var queue: LinkedList<Int> = LinkedList()
    var avg: Double = 0.0

    fun next(value: Int): Double {
        if (skip-- > 0)
            return 0.0
        if (queue.size < this.size) {
            queue.offer(value)
            var sum = 0
            for (i in queue) {
                sum += i
            }
            avg = sum.toDouble() / queue.size
        } else {
            val head = queue.poll()
            val minus = head.toDouble() / this.size
            queue.offer(value)
            val add = value.toDouble() / this.size
            avg = avg + add - minus
        }
        return avg
    }

    fun reset() {
        queue.forEach { it }
        avg = 0.0
    }
}