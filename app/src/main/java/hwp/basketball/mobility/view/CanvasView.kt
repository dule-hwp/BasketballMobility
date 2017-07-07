/**
 * Credit for this class goes to:
 * https://github.com/Korilakkuma/CanvasView

 * CanvasView.java
 *
 *
 * Copyright (c) 2014 Tomohiro IKEDA (Korilakkuma)
 * Released under the MIT license
 */

package hwp.basketball.mobility.util

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import java.util.*

/**
 * This class defines fields and methods for drawing.
 */
class CanvasView : View {

    // Enumeration for Mode
    enum class Mode {
        DRAW,
        TEXT,
        ERASER
    }

    // Enumeration for Drawer
    enum class Drawer {
        PEN,
        LINE,
        RECTANGLE,
        CIRCLE,
        ELLIPSE,
        QUADRATIC_BEZIER,
        QUBIC_BEZIER
    }

    internal var bitmap: Bitmap? = null

    private val pathList = ArrayList<Path>()
    private val paintLists = ArrayList<Paint>()

    private val emptyPaint = Paint()

    // for Undo, Redo
    private var historyPointer = 0

    var mode = Mode.DRAW

    var drawer = Drawer.PEN
    private var isDown = false


    var paintStyle: Paint.Style = Paint.Style.STROKE

    var paintStrokeColor = Color.BLACK

    var paintStrokeWidth = 3f
        set(width) = if (width >= 0) {
            field = width
        } else {
            field = 3f
        }

    var opacity = 255
        set(opacity) = if (opacity in 0..255) {
            field = opacity
        } else {
            field = 255
        }

    var blur = 0f
        set(blur) = if (blur >= 0) {
            field = blur
        } else {
            field = 0f
        }

    var lineCap: Paint.Cap = Paint.Cap.ROUND

    var drawPathEffect: PathEffect? = null


    var text = ""

    var fontFamily = Typeface.DEFAULT

    var fontSize = 32f
        set(size) = if (size >= 0f) {
            field = size
        } else {
            field = 32f
        }

    private val textAlign = Paint.Align.RIGHT  // fixed
    private var textPaint = Paint()
    private var textX = 0f
    private var textY = 0f

    // for Drawer
    private var startX = 0f
    private var startY = 0f
    private var controlX = 0f
    private var controlY = 0f

    /**
     * Copy Constructor

     * @param context
     * *
     * @param attrs
     * *
     * @param defStyle
     */
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        this.setup()
    }

    /**
     * Copy Constructor

     * @param context
     * *
     * @param attrs
     */
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        this.setup()
    }

    /**
     * Copy Constructor

     * @param context
     */
    constructor(context: Context) : super(context) {
        this.setup()
    }

    /**
     * Common initialization.

     */
    private fun setup() {

        this.pathList.add(Path())
        this.paintLists.add(this.createPaint())
        this.historyPointer++

        this.textPaint.setARGB(0, 255, 255, 255)
    }

    /**
     * This method creates the instance of Paint.
     * In addition, this method sets styles for Paint.

     * @return paint This is returned as the instance of Paint
     */
    private fun createPaint(): Paint {
        val paint = Paint()

        paint.isAntiAlias = true
        paint.style = this.paintStyle
        paint.strokeWidth = this.paintStrokeWidth
        paint.strokeCap = this.lineCap
        paint.strokeJoin = Paint.Join.MITER  // fixed

        // for Text
        if (this.mode == Mode.TEXT) {
            paint.typeface = this.fontFamily
            paint.textSize = this.fontSize
            paint.textAlign = this.textAlign
            paint.strokeWidth = 0f
        }

        if (this.mode == Mode.ERASER) {
            // Eraser
            paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
            paint.setARGB(0, 0, 0, 0)

            // paint.setColor(this.baseColor);
            // paint.setShadowLayer(this.blur, 0F, 0F, this.baseColor);
        } else {
            // Otherwise
            paint.color = this.paintStrokeColor
            paint.setShadowLayer(this.blur, 0f, 0f, this.paintStrokeColor)
            paint.alpha = this.opacity
            paint.pathEffect = this.drawPathEffect
        }

        return paint
    }

    /**
     * This method initialize Path.
     * Namely, this method creates the instance of Path,
     * and moves current position.

     * @param event This is argument of onTouchEvent method
     * *
     * @return path This is returned as the instance of Path
     */
    private fun createPath(event: MotionEvent): Path {
        val path = Path()

        // Save for ACTION_MOVE
        if (pathPoints.isEmpty()) {
            this.startX = event.x
            this.startY = event.y
        } else {
            val lastPoint = pathPoints.last()
            this.startX = lastPoint.x
            this.startY = lastPoint.y
        }

        path.moveTo(this.startX, this.startY)
        pathPoints.add(PointF(this.startX, this.startY))

        return path
    }

    /**
     * This method updates the lists for the instance of Path and Paint.
     * "Undo" and "Redo" are enabled by this method.

     * @param path the instance of Path
     */
    private fun updateHistory(path: Path) {
        if (this.historyPointer == this.pathList.size) {
            this.pathList.add(path)
            this.paintLists.add(this.createPaint())
            this.historyPointer++
        } else {
            // On the way of Undo or Redo
            this.pathList[this.historyPointer] = path
            this.paintLists[this.historyPointer] = this.createPaint()
            this.historyPointer++

            var i = this.historyPointer
            val size = this.paintLists.size
            while (i < size) {
                this.pathList.removeAt(this.historyPointer)
                this.paintLists.removeAt(this.historyPointer)
                i++
            }
        }
    }

    /**
     * This method gets the instance of Path that pointer indicates.

     * @return the instance of Path
     */
    val currentPath: Path
        get() = this.pathList[this.historyPointer - 1]

    /**
     * This method draws text.

     * @param canvas the instance of Canvas
     */
    private fun drawText(canvas: Canvas) {
        if (this.text.isEmpty()) {
            return
        }

        if (this.mode == Mode.TEXT) {
            this.textX = this.startX
            this.textY = this.startY

            this.textPaint = this.createPaint()
        }

        val textX = this.textX
        val textY = this.textY

        val paintForMeasureText = Paint()

        // Line break automatically
        val textLength = paintForMeasureText.measureText(this.text)
        val lengthOfChar = textLength / this.text.length.toFloat()
        val restWidth = canvas.width - textX  // text-align : right
        val numChars = if (lengthOfChar <= 0) 1 else Math.floor((restWidth / lengthOfChar).toDouble()).toInt()  // The number of characters at 1 line
        val modNumChars = if (numChars < 1) 1 else numChars
        var y = textY

        var i = 0
        val len = this.text.length
        while (i < len) {
            var substring: String

            if (i + modNumChars < len) {
                substring = this.text.substring(i, i + modNumChars)
            } else {
                substring = this.text.substring(i, len)
            }

            y += this.fontSize

            canvas.drawText(substring, textX, y, this.textPaint)
            i += modNumChars
        }
    }

    /**
     * This method defines processes on MotionEvent.ACTION_DOWN

     * @param event This is argument of onTouchEvent method
     */
    private fun onActionDown(event: MotionEvent) {
        when (this.mode) {
            CanvasView.Mode.DRAW, CanvasView.Mode.ERASER -> if (this.drawer != Drawer.QUADRATIC_BEZIER && this.drawer != Drawer.QUBIC_BEZIER) {
                // Oherwise
                this.updateHistory(this.createPath(event))
                this.isDown = true
            } else {
                // Bezier
                if (this.startX == 0f && this.startY == 0f) {
                    // The 1st tap
                    this.updateHistory(this.createPath(event))
                } else {
                    // The 2nd tap
                    this.controlX = event.x
                    this.controlY = event.y

                    this.isDown = true
                }
            }
            CanvasView.Mode.TEXT -> {
                this.startX = event.x
                this.startY = event.y
            }
            else -> {
            }
        }
    }

    internal val pathPoints by lazy {
        mutableSetOf<PointF>()
//        arrayListOf<PointF>()
    }

    /**
     * This method defines processes on MotionEvent.ACTION_MOVE

     * @param event This is argument of onTouchEvent method
     */
    private fun onActionMove(event: MotionEvent) {
        val x = event.x
        val y = event.y

        when (this.mode) {
            CanvasView.Mode.DRAW, CanvasView.Mode.ERASER ->

                if (this.drawer != Drawer.QUADRATIC_BEZIER && this.drawer != Drawer.QUBIC_BEZIER) {
                    if (!isDown) {
                        return
                    }

                    val path = this.currentPath

                    when (this.drawer) {
                        CanvasView.Drawer.PEN -> {
                            path.lineTo(x, y)
//                            pathPoints.addDrillToDatabase(PointF(x, y))
                        }
                        CanvasView.Drawer.LINE -> {
                            path.reset()
                            path.moveTo(this.startX, this.startY)
                            path.lineTo(x, y)
//                            pathPoints.addDrillToDatabase(PointF(x, y))
                        }
                        CanvasView.Drawer.RECTANGLE -> {
                            path.reset()

                            val left = Math.min(this.startX, x)
                            val right = Math.max(this.startX, x)
                            val top = Math.min(this.startY, y)
                            val bottom = Math.max(this.startY, y)

                            path.addRect(left, top, right, bottom, Path.Direction.CCW)
                        }
                        CanvasView.Drawer.CIRCLE -> {
                            val distanceX = Math.abs((this.startX - x).toDouble())
                            val distanceY = Math.abs((this.startX - y).toDouble())
                            val radius = Math.sqrt(Math.pow(distanceX, 2.0) + Math.pow(distanceY, 2.0))

                            path.reset()
                            path.addCircle(this.startX, this.startY, radius.toFloat(), Path.Direction.CCW)
                        }
                        CanvasView.Drawer.ELLIPSE -> {
                            val rect = RectF(this.startX, this.startY, x, y)

                            path.reset()
                            path.addOval(rect, Path.Direction.CCW)
                        }
                        else -> {
                        }
                    }
                } else {
                    if (!isDown) {
                        return
                    }

                    val path = this.currentPath

                    path.reset()
                    path.moveTo(this.startX, this.startY)
                    path.quadTo(this.controlX, this.controlY, x, y)
//                    pathPoints.clear()
//                    pathPoints.addDrillToDatabase(PointF(this.startX, this.startY))
                }
            CanvasView.Mode.TEXT -> {
                this.startX = x
                this.startY = y
            }
            else -> {
            }
        }
    }

    /**
     * This method defines processes on MotionEvent.ACTION_DOWN

     * @param event This is argument of onTouchEvent method
     */
    private fun onActionUp(event: MotionEvent) {
        if (isDown) {
            this.startX = 0f
            this.startY = 0f
            this.isDown = false

            pathPoints.add(PointF(event.x, event.y))
        }
    }

    /**
     * This method updates the instance of Canvas (View)

     * @param canvas the new instance of Canvas
     */
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Before "drawPath"
        //        canvas.drawColor(this.baseColor);

        this.bitmap?.let {
            canvas.drawBitmap(it, 0f, 0f, emptyPaint)
        }

        for (i in 0..this.historyPointer - 1) {
            val path = this.pathList[i]
            val paint = this.paintLists[i]

            canvas.drawPath(path, paint)
        }

        this.drawText(canvas)
    }

    /**
     * This method set event listener for drawing.

     * @param event the instance of MotionEvent
     * *
     * @return
     */
    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> this.onActionDown(event)
            MotionEvent.ACTION_MOVE -> this.onActionMove(event)
            MotionEvent.ACTION_UP -> this.onActionUp(event)
            else -> {
            }
        }

        // Re draw
        this.invalidate()

        return true
    }

    /**
     * This method checks if Undo is available

     * @return If Undo is available, this is returned as true. Otherwise, this is returned as false.
     */
    fun canUndo(): Boolean {
        return this.historyPointer > 1
    }

    /**
     * This method checks if Redo is available

     * @return If Redo is available, this is returned as true. Otherwise, this is returned as false.
     */
    fun canRedo(): Boolean {
        return this.historyPointer < this.pathList.size
    }

    /**
     * This method draws canvas again for Undo.

     * @return If Undo is enabled, this is returned as true. Otherwise, this is returned as false.
     */
    fun undo(): Boolean {
        if (canUndo()) {
            this.historyPointer--
            this.invalidate()

            return true
        } else {
            return false
        }
    }

    /**
     * This method draws canvas again for Redo.

     * @return If Redo is enabled, this is returned as true. Otherwise, this is returned as false.
     */
    fun redo(): Boolean {
        if (canRedo()) {
            this.historyPointer++
            this.invalidate()

            return true
        } else {
            return false
        }
    }

    /**
     * This method initializes canvas.

     * @return
     */
    fun clear() {
        while (historyPointer > 0 && canUndo()) {
            undo()
        }
    }

    /**
     * This method gets current canvas as bitmap.

     * @return This is returned as bitmap.
     */
    fun getBitmap(): Bitmap {
        this.isDrawingCacheEnabled = false
        this.isDrawingCacheEnabled = true

        return Bitmap.createBitmap(this.drawingCache)
    }

}
