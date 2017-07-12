package hwp.basketball.mobility.util

import android.graphics.Bitmap
import android.graphics.Color
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import timber.log.Timber


/**
 *
 * Created by dusan_cvetkovic on 6/8/17.
 */
object Geometry2D {
    /**
     * https://en.wikipedia.org/wiki/Distance_from_a_point_to_a_line
     * Line defined by two points
     * */
    //    companion object {
    fun distance(linePoint1: PointF, linePoint2: PointF, point: PointF): Double {
        val numerator = Math.abs((linePoint2.y - linePoint1.y) * point.x -
                (linePoint2.x - linePoint1.x) * point.y +
                linePoint2.x * linePoint1.y -
                linePoint2.y * linePoint1.x)
        val denominator = Math.sqrt(Math.pow((linePoint2.y - linePoint1.y).toDouble(), 2.0) +
                Math.pow((linePoint2.x - linePoint1.x).toDouble(), 2.0))
        return numerator / denominator
    }

    /**
     * Via line equation
     * y=mx+k
     * */
    fun distance2(linePoint1: PointF, linePoint2: PointF, point: PointF): Double {
        val m = (linePoint2.y - linePoint1.y) / (linePoint2.x - linePoint1.x)
        val k = linePoint2.y - m * linePoint2.x
        return Math.abs(k + m * point.x - point.y) / Math.sqrt((1 + m * m).toDouble())
    }

    fun distance(linePoint1: FloatArray, linePoint2: FloatArray, point: FloatArray): Double {
        return distance(PointF(linePoint1[0], linePoint1[1]), PointF(linePoint2[0], linePoint2[1]),
                PointF(point[0], point[1]))
    }

    fun getAreaForBitmap(bitmap: Bitmap): Observable<Pair<Int, Int>> {
        return Observable.create({ emitter: ObservableEmitter<Pair<Int, Int>> ->
            Timber.d("getAreaForBitmap entered")

            var sum = 0
            for (y in 0..bitmap.height - 1) {
                val progress = (y.toFloat() / bitmap.height * 100).toInt()
                emitter.onNext(Pair(progress, sum))
                (0..bitmap.width - 1)
                        .map { x -> bitmap.getPixel(x, y) }
                        .forEach { color -> sum += if (color == Color.RED) 1 else 0 }
            }

            emitter.onNext(Pair(100, sum))
            emitter.onComplete()
        })
    }

    fun distance(points: List<PointF>, actualEndPoint: PointF, segmentIndex: Int): Double {

        if (segmentIndex > points.size - 2) {
            return 0.0
        }
        val minDistance = distance(points[segmentIndex], points[segmentIndex + 1], actualEndPoint)
        return minDistance
//        for (index in 1..points.size - 2) {
//            val startPoint = points[index]
//            val endPoint = points[index + 1]
//            val distance = distance(startPoint, endPoint, actualEndPoint)
//            if (distance < minDistance) {
//                minDistance = distance
//            }
//        }
//        return 0.0
    }

}