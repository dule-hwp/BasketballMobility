package hwp.basketball.mobility.util

/**
 * Created by dusan_cvetkovic on 6/8/17.
 */
data class PointF(var x: Float = 0f, var y: Float = 0f) {
    fun toFloatArray() = floatArrayOf(x, y)
    /** Returns angle betwen current point and target point
     *
     * @param target Point to calculate angle between.
     * @return angle in degrees 0-360 degrees
     * */
    fun getAngle(target: PointF): Double {
        return Math.toDegrees(getAngleRad(target))
//        if (angleDeg < 0) {
//            angleDeg += 360
//        }
//        return 360-angleDeg
    }

    fun getAngleRad(target: PointF): Double {
        return Math.atan2((target.y - y).toDouble(), (target.x - x).toDouble())
    }

    fun distanceTo(endPoint: PointF): Float {
        return Vector2D.distance(this, endPoint)
    }
}

data class Point(var x: Int = 0, var y: Int = 0) {
    fun toFloatArray() = floatArrayOf(x.toFloat(), y.toFloat())
}