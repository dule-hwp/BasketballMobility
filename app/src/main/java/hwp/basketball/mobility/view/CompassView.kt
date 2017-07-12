package hwp.basketball.mobility.view

import android.content.Context
import android.graphics.*
import hwp.basketball.mobility.R
import hwp.basketball.mobility.drill.perform.sketchview.SensorDrawingView
import hwp.basketball.mobility.util.MovingAverage
import hwp.basketball.mobility.util.Vector2D
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlin.properties.Delegates

/**
 * Created by dusan_cvetkovic on 6/20/17.
 */
class CompassView(context: Context) {

    private val compassTextColor = 0xff0000ff.toInt()
    private val compassBorderColor = 0xff7f7f7f.toInt()
    private val compassOvalColor = 0xffC8C8C8.toInt()
    private val strokeWidth = 3
    private val strokeWidthCompassText = 2

    private val compassCenterPadding = 7.0f
    private val compassRadius = 60.0f

    //compass paint
    private var paintCompassText: Paint = Paint()
    private var ovalPaint: Paint = Paint()
    private var ovalCenterPaint: Paint = Paint()
    private var ovalBorderPaint: Paint = Paint()
    private var ovalLinesPaint: Paint = Paint()
    private var paint: Paint = Paint()

    internal var degreesToNorth = -1000f

//    var correction: Float = 0F

    /**@suppress*/
    internal var screenAspectRatio = -1.0f
    /**@suppress*/
    internal val bitmapArrow: Bitmap by lazy {
        BitmapFactory.decodeResource(context.resources, R.drawable.arrow)
    }

    var movingAverageAngleDiff: MovingAverage = MovingAverage(30)

    init {
        paintCompassText.color = compassTextColor
        paintCompassText.strokeWidth = strokeWidthCompassText.toFloat()
        paintCompassText.style = Paint.Style.FILL
        paintCompassText.isAntiAlias = true
        paintCompassText.textSize = 48f

        ovalPaint.color = compassOvalColor
        ovalPaint.style = Paint.Style.FILL
        ovalPaint.isAntiAlias = true


        ovalCenterPaint.color = compassBorderColor
        ovalCenterPaint.style = Paint.Style.FILL
        ovalCenterPaint.isAntiAlias = true

        ovalLinesPaint.color = Color.RED
        ovalLinesPaint.strokeWidth = strokeWidthCompassText.toFloat()
        ovalLinesPaint.isAntiAlias = true

        ovalBorderPaint.strokeWidth = strokeWidth.toFloat()
        ovalBorderPaint.color = compassBorderColor
        ovalBorderPaint.style = Paint.Style.STROKE
        ovalBorderPaint.isAntiAlias = true

        paint.color = Color.RED
        paint.strokeWidth = 2f
        paint.style = Paint.Style.STROKE
        paint.isAntiAlias = true
        paint.textSize = 35f
    }

    fun drawCompass(canvas: Canvas?) {

        if (canvas == null || degreesToNorth == -1000f)
            return

        val insideCircleRadius = 3.0f
        val center = floatArrayOf(compassRadius + compassCenterPadding,
                canvas.height.toFloat() - screenAspectRatio * (compassRadius + compassCenterPadding))

        val startVec = floatArrayOf(0.0f, -1.0f)
        // calculate direction line part
        val rotated = Vector2D.RotateVector(startVec, degreesToNorth)
        val normalizedVec = Vector2D.Normalize(rotated)
        val scaledVec = Vector2D.MultiplyScalar(normalizedVec, compassRadius)
        val drawEnd = Vector2D.Add(scaledVec, center)

        // calculate arrow coordinates part
        val rotatedArrow = Vector2D.RotateBitmap(bitmapArrow, degreesToNorth)
        val shiftToCompassCenter = 3.0f
        val shiftToOrigin = floatArrayOf((rotatedArrow.width / 2).toFloat(), (rotatedArrow.height / 2).toFloat())
        val drawEndRelativeToCenter = Vector2D.Subtract(drawEnd, center)

        var arrowCoordinatesRelativeToCenter: FloatArray
        arrowCoordinatesRelativeToCenter = Vector2D.Subtract(drawEndRelativeToCenter, shiftToOrigin)
        arrowCoordinatesRelativeToCenter = Vector2D.Subtract(arrowCoordinatesRelativeToCenter,
                Vector2D.MultiplyScalar(normalizedVec, shiftToCompassCenter))
        val arrowCoordinates = Vector2D.Add(center, arrowCoordinatesRelativeToCenter)

        // compass background
        canvas.drawCircle(center[0], center[1], compassRadius, ovalPaint)

        // compass border
        canvas.drawCircle(center[0], center[1], compassRadius, ovalBorderPaint)

        // some graduation lines
        val lineLength = 6
        canvas.drawLine(center[0] + compassRadius, center[1], center[0] + compassRadius - lineLength, center[1], ovalBorderPaint)
        canvas.drawLine(center[0] - compassRadius, center[1], center[0] - compassRadius + lineLength, center[1], ovalBorderPaint)
        canvas.drawLine(center[0], center[1] + compassRadius, center[0], center[1] + compassRadius - lineLength, ovalBorderPaint)
        canvas.drawLine(center[0], center[1] - compassRadius, center[0], center[1] - compassRadius + lineLength, ovalBorderPaint)

        // compass arrow
        canvas.drawLine(center[0], center[1], drawEnd[0], drawEnd[1], ovalLinesPaint)
        canvas.drawBitmap(rotatedArrow, arrowCoordinates[0], arrowCoordinates[1], ovalLinesPaint)

        // compass center
        canvas.drawCircle(center[0], center[1], insideCircleRadius, ovalCenterPaint)

        canvas.drawText("Deg: $degreesToNorth",
                center[0] - compassRadius, center[1] - compassRadius - paint.textSize / 2, paint)
    }


    val isRotatingObservable = PublishSubject.create<Boolean>()

    var isRotating: Boolean by Delegates.observable(false, { _, old, new ->
        if (old != new){
            isRotatingObservable.onNext(new)
        }
    })

    fun subscribeToRotatingChange() : Observable<Boolean> {
        return isRotatingObservable
    }

    fun updateAngle(degreesToTrueNorth: Float) {
        movingAverageAngleDiff.next((degreesToTrueNorth - this.degreesToNorth).toInt())
        this.degreesToNorth = degreesToTrueNorth
        isRotating = Math.abs(movingAverageAngleDiff.avg) > SensorDrawingView.ANGLE_DIFF_CUTOFF
    }

}