package hwp.basketball.mobility.util

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import hwp.basketball.mobility.entitiy.drills.outcomes.DrillTempOutcome
import hwp.basketball.mobility.pathrecorder.sketchview.SensorDrawingView
import hwp.basketball.mobility.pathrecorder.sketchview.SensorDrawingView.Companion.DESIRED_PATH_COLOR
import hwp.basketball.mobility.pathrecorder.sketchview.SensorDrawingView.Companion.PATH_WIDTH_IN_PIXELS
import hwp.basketball.mobility.pathrecorder.sketchview.SensorDrawingView.Companion.SENSOR_PATH_COLOR
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import org.joda.time.LocalTime
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

            var sum = 0;
            for (y in 0..bitmap.height - 1) {
                val progress = (y.toFloat() / bitmap.height * 100).toInt()
                emitter.onNext(Pair(progress, sum))
                (0..bitmap.width - 1)
                        .map { bitmap.getPixel(Point(it, y)) }
                        .forEach { sum += if (it == Color.RED) 1 else 0 }
            }

            emitter.onNext(Pair(100, sum))
            emitter.onComplete()
        })
    }

    private fun getErrorIncrease(pathPoint: Point?, pixelDistanceToNextPoint: Int, canvas: Canvas, currentPoint: Point, paint: Paint): Int {
        var sum1 = 0
        if (pathPoint != null) {
            if (pixelDistanceToNextPoint > SensorDrawingView.CURRENT_LOCATION_RADIUS_PIXELS) {
                canvas.drawLine(currentPoint, pathPoint, paint)
                sum1 += pixelDistanceToNextPoint
//                Timber.d("row$x: $pixelDistanceToNextPoint, sum=$sum1")
            }
        }
        return sum1
    }

    private fun findNextPathPointInColumn(bitmap: Bitmap, row: Int, column: Int, pixelColor: Int): Pair<Point?, Int> {
        var col = column + PATH_WIDTH_IN_PIXELS
        var pixel = bitmap.getPixel(row, col)
        while (col < bitmap.height - 1) {
            if (isEndOfAreaPixelColor(pixelColor, pixel)) {
                val point = Point(row, col)
                return Pair(point, col - column + PATH_WIDTH_IN_PIXELS + 3)
            }
            pixel = bitmap.getPixel(row, ++col)
        }
        return Pair(null, 0)
    }

    private fun findNextPathPointInRow(bitmap: Bitmap, row: Int, column: Int, pixelColor: Int): Pair<Point?, Int> {
        var r = row + PATH_WIDTH_IN_PIXELS
        var pixel = bitmap.getPixel(r, column)
        while (r < bitmap.width - 1) {
            if (isEndOfAreaPixelColor(pixelColor, pixel)) {
                val point = Point(r, column)
                return Pair(point, r - row + PATH_WIDTH_IN_PIXELS + 3)
            }
            pixel = bitmap.getPixel(++r, column)
        }
        return Pair(null, 0)
    }

    /**
     * Depending on what is considered area return true here
     *
     * Is it only opposite from pixelToStartArea or any path pixel (blue, green)??
     * */
    private fun isEndOfAreaPixelColor(pixelToStartArea: Int, pixelToCompare: Int): Boolean {
        return oppositePixelImpl(pixelToStartArea, pixelToCompare)
//        return pixelToCompare == SENSOR_PATH_COLOR || pixelToCompare == DESIRED_PATH_COLOR
    }

    private fun oppositePixelImpl(pixelToStartArea: Int, pixelToCompare: Int): Boolean {
        if (pixelToStartArea == DESIRED_PATH_COLOR) {
            return pixelToCompare == SENSOR_PATH_COLOR
        } else if (pixelToStartArea == SENSOR_PATH_COLOR) {
            return pixelToCompare == DESIRED_PATH_COLOR
        }
        return false
    }

    fun distance(points: List<PointF>, actualEndPoint: PointF, segmentIndex: Int): Double {

        if (segmentIndex > points.size - 2) {
            return 0.0
        }
        var minDistance = distance(points[segmentIndex], points[segmentIndex + 1], actualEndPoint)
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