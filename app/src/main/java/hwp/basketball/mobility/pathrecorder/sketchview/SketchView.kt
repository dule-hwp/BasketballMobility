package hwp.basketball.mobility.pathrecorder.sketchview

import android.content.Context
import android.graphics.*
import android.graphics.Paint.Style
import android.util.AttributeSet
import android.view.View
import hwp.basketball.mobility.util.Vector2D
import hwp.basketball.mobility.pathrecorder.sketchview.Movement
import java.util.*


open class SketchView : View, SketchViewContract.View {
    private var presenter: SketchViewContract.Presenter? = null

    override fun setPresenter(sketchViewPresenter: SketchViewContract.Presenter) {
        this.presenter = sketchViewPresenter
    }

    private var beginDrawing = false
    private val TOTAL_MESSAGES = 2
    private val TIMEOUT_FOR_MESSAGES_MS: Long = 1000
    private val backGroundColor = 0xffffffff.toInt()
    private val drawColor = 0xffff0000.toInt()
    private val compassTextColor = 0xff0000ff.toInt()
    private val compassBorderColor = 0xff7f7f7f.toInt()
    private val compassOvalColor = 0xffC8C8C8.toInt()
    private val strokeWidth = 3
    private val strokeWidthCompassText = 2
    private val compassCenterPadding = 7.0f
    private val compassRadius = 20.0f
    private var viewYlimit = -1.0f

    private var lastTimeForMessageInit: Long = 0
    private val messages = arrayOfNulls<String>(TOTAL_MESSAGES)
    private val messagesWithTimeout = arrayOfNulls<String>(TOTAL_MESSAGES)
    private var degreesToNorth = -1000
    private var screenAspectRatio = -1.0f
    private var bitmapArrow: Bitmap? = null
    private var paint: Paint = Paint()
    private var paintCompassText: Paint = Paint()
    private var ovalPaint: Paint = Paint()
    private var ovalCenterPaint: Paint = Paint()
    private var ovalBorderPaint: Paint = Paint()
    private var ovalLinesPaint: Paint = Paint()
    private var menuTextPaint: Paint = Paint()

    var exportBitmap: Bitmap? = null
        private set
    private var exportToBitmap: Boolean = false
    var bitmapIsExported: Boolean = false
        private set
    private var exportCanvas: Canvas? = null

    private fun InitSketch() {

        paint.color = drawColor
        paint.strokeWidth = 1f
        paint.style = Style.STROKE
        paint.isAntiAlias = true

        paintCompassText.color = compassTextColor
        paintCompassText.strokeWidth = strokeWidthCompassText.toFloat()
        paintCompassText.style = Style.FILL
        paintCompassText.isAntiAlias = true
        paintCompassText.textSize = 48f

        ovalPaint.color = compassOvalColor
        ovalPaint.style = Style.FILL
        ovalPaint.isAntiAlias = true


        ovalCenterPaint.color = compassBorderColor
        ovalCenterPaint.style = Style.FILL
        ovalCenterPaint.isAntiAlias = true

        ovalLinesPaint.color = drawColor
        ovalLinesPaint.strokeWidth = strokeWidthCompassText.toFloat()
        ovalLinesPaint.isAntiAlias = true

        ovalBorderPaint.strokeWidth = strokeWidth.toFloat()
        ovalBorderPaint.color = compassBorderColor
        ovalBorderPaint.style = Style.STROKE
        ovalBorderPaint.isAntiAlias = true

        menuTextPaint.strokeWidth = strokeWidthCompassText.toFloat()
        menuTextPaint.color = backGroundColor
        menuTextPaint.style = Style.FILL
        menuTextPaint.textSize = 30.0f
        menuTextPaint.isAntiAlias = true

    }

    fun exportPathToBitmap(export: Boolean) {
        this.exportToBitmap = export
        this.bitmapIsExported = false

        if (export) {
            val conf = Bitmap.Config.RGB_565
            val bHeight = 800
            val bWidth = 600
            this.exportBitmap = Bitmap.createBitmap(bWidth, bHeight, conf)
            this.exportCanvas = Canvas(this.exportBitmap!!)
        }
    }

    constructor(context: Context) : super(context) {
        InitSketch()
        exportPathToBitmap(false)
    }

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        InitSketch()
        exportPathToBitmap(false)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        InitSketch()
        exportPathToBitmap(false)
    }

    fun setBeginDrawing(draw: Boolean) {
        this.beginDrawing = draw
    }

    fun setBitmapArrow(bitmapArrow: Bitmap?) {
        this.bitmapArrow = bitmapArrow
    }

    override fun setMessages(message1: String, message2: String) {
        messages[0] = message1
        messages[1] = message2
    }

    override fun setMessagesWithTimeout(message1: String, message2: String) {
        lastTimeForMessageInit = System.currentTimeMillis()
        messagesWithTimeout[0] = message1
        messagesWithTimeout[1] = message2
    }

    override fun setDegreesToNorth(degreesToNorth: Int) {
        this.degreesToNorth = degreesToNorth
    }

    override fun invalidateView() {
        this.post {
            invalidate()
        }
    }

    fun setAspectRatio(aspectRatio: Float) {
        this.screenAspectRatio = aspectRatio
    }

    private fun drawCompass(canvas: Canvas?, degreesToNorth: Int) {

        if (canvas == null || degreesToNorth == -1000)
            return

        val insideCircleRadius = 3.0f
        val center = floatArrayOf(compassRadius + compassCenterPadding, canvas.height.toFloat() - screenAspectRatio * (compassRadius + compassCenterPadding))

        // calculate direction line part
        val startVec = floatArrayOf(0.0f, -1.0f)
        val rotated = Vector2D.RotateVector(startVec, degreesToNorth)
        val normalizedVec = Vector2D.Normalize(rotated)
        val scaledVec = Vector2D.MultiplyScalar(normalizedVec, compassRadius)
        val drawEnd = Vector2D.Add(scaledVec, center)

        // calculate arrow coordinates part
        val rotatedArrow = Vector2D.RotateBitmap(bitmapArrow!!, -degreesToNorth.toFloat())
        val shiftToCompassCenter = 3.0f
        val shiftToOrigin = floatArrayOf((rotatedArrow.width / 2).toFloat(), (rotatedArrow.height / 2).toFloat())
        val drawEndRelativeToCenter = Vector2D.Subtract(drawEnd, center)
        var arrowCoordsRelativeToCenter: FloatArray
        arrowCoordsRelativeToCenter = Vector2D.Subtract(drawEndRelativeToCenter, shiftToOrigin)
        arrowCoordsRelativeToCenter = Vector2D.Subtract(arrowCoordsRelativeToCenter, Vector2D.MultiplyScalar(normalizedVec, shiftToCompassCenter))
        val arrowCoords = Vector2D.Add(center, arrowCoordsRelativeToCenter)

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
        canvas.drawBitmap(rotatedArrow, arrowCoords[0], arrowCoords[1], ovalLinesPaint)

        // compass center
        canvas.drawCircle(center[0], center[1], insideCircleRadius, ovalCenterPaint)

    }

    private fun drawStatusBar(canvas: Canvas) {

        // bar lines
        canvas.drawLine(0f, viewYlimit, canvas.width.toFloat(), viewYlimit, ovalBorderPaint)

        val drawXvert = 2.0f * compassRadius + 2.0f * compassCenterPadding
        canvas.drawLine(drawXvert, viewYlimit, drawXvert, canvas.height.toFloat(), ovalBorderPaint)

        // draw messages
        val testMessage = " !"
        paintCompassText.getTextBounds(testMessage, 0, testMessage.length, textBounds)
        val textHeightPadding = 4.0f

        var messagesForStatusBar = messagesWithTimeout
        if (System.currentTimeMillis() - lastTimeForMessageInit > TIMEOUT_FOR_MESSAGES_MS ||
                messagesForStatusBar[0] == null || messagesForStatusBar[1] == null ||
                messagesForStatusBar[0]!!.isEmpty() || messagesForStatusBar[1]!!.isEmpty())
            messagesForStatusBar = messages

        for (i in messagesForStatusBar.indices) {
            if (messagesForStatusBar[i] != null && messagesForStatusBar[i]!!.isNotEmpty()) {
                val textY = viewYlimit +
                        screenAspectRatio * compassCenterPadding +
                        screenAspectRatio * textHeightPadding +
                        i * (textBounds.height() + textHeightPadding)

                canvas.drawText(messagesForStatusBar[i], drawXvert + 2.0f * compassCenterPadding, textY, paintCompassText)
            }
        }

    }

    private fun drawMovementStatistics(stats: List<String>, canvas: Canvas) {

        // draw messages
        val testMessage = " !"
        paintCompassText.getTextBounds(testMessage, 0, testMessage.length, textBounds)
        val textHeightPadding = 4.0f

        val messagesOfMovementStats = stats

        val xPadd = 10.0f
        val yPadd = 10.0f

        for (i in messagesOfMovementStats.indices) {
            if (messagesOfMovementStats[i].isNotEmpty()) {
                val textY = yPadd +
                        screenAspectRatio * textHeightPadding +
                        i * (textBounds.height() + textHeightPadding)

                canvas.drawText(messagesOfMovementStats[i], xPadd, textY, paintCompassText)
            }
        }
    }

    private fun convertPointsToPath(points: LinkedList<Array<Float>>?): Path {
        val path = Path()

        if (points == null)
            return path

        for (i in points.indices) {
            val coords = points[i]
            if (i == 0)
                path.moveTo(coords[0], coords[1])
            else
                path.lineTo(coords[0], coords[1])
        }

        return path
    }

//    private var stats: List<String>? = null

    private var movementData: Movement.MovementData? = null

    private fun drawMovement(canvas: Canvas?) {

        if (canvas == null)
            return

        val startPoint = floatArrayOf((canvas.width / 2).toFloat(), viewYlimit / 2)

        movementData = presenter?.getMovementDataForDraw(startPoint)
        movementData?.let { (points, stats) ->

            val pathPointRadius = 2

            val path = convertPointsToPath(points)
            canvas.drawPath(path, paint)

            val lastPoint = points?.last
            lastPoint?.let {
                canvas.drawCircle(lastPoint[0], lastPoint[1], pathPointRadius.toFloat(), ovalCenterPaint)
            }
//            stats?.let {
                drawMovementStatistics(stats, canvas)
//            }
        }

    }

    private fun initDrawing(canvas: Canvas) {
        if (viewYlimit == -1.0f)
            viewYlimit = canvas.height.toFloat() - screenAspectRatio * compassRadius * 2.0f
    }

    private fun drawBackground(canvas: Canvas?) {
        canvas?.drawColor(backGroundColor)
    }

    private fun drawToBitmap() {
        if (exportToBitmap) {
            drawBackground(exportCanvas)
            drawMovement(exportCanvas)
            exportToBitmap = false
            bitmapIsExported = true
        }
    }

    override fun onDraw(canvas: Canvas) {
        if (!beginDrawing)
            return

        super.onDraw(canvas)

        initDrawing(canvas)

        drawBackground(canvas)

        drawMovement(canvas)

        drawToBitmap()

        drawStatusBar(canvas)

        drawCompass(canvas, degreesToNorth)

//        drawMenu(canvas)
    }

    companion object {
        private val textBounds = Rect()
    }

}
