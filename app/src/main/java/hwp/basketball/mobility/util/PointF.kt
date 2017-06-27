package hwp.basketball.mobility.util

/**
 * Created by dusan_cvetkovic on 6/8/17.
 */
data class PointF(var x: Float = 0f, var y: Float = 0f) {
    fun toFloatArray() = floatArrayOf(x, y)
    fun getAngle(target: PointF): Double {
        return Math.toDegrees(Math.atan2((target.y - y).toDouble(), (target.x - x).toDouble()))
    }

    fun getAngleRad(target: PointF): Double {
        return Math.atan2((target.y - y).toDouble(), (target.x - x).toDouble())
    }
}

data class Point(var x: Int = 0, var y: Int = 0) {
    fun toFloatArray() = floatArrayOf(x.toFloat(), y.toFloat())
}