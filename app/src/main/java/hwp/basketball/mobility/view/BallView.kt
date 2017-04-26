package hwp.basketball.mobility.view

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.view.View

import hwp.basketball.mobility.R

/**
 * TODO: document your custom view class.
 */
class BallView : View {
    private var mExampleString: String? = null // TODO: use a default from R.string...
    private var mExampleColor = Color.RED // TODO: use a default from R.color...
    private var mExampleDimension = 0f // TODO: use a default from R.dimen...
    /**
     * Gets the example drawable attribute value.

     * @return The example drawable attribute value.
     */
    /**
     * Sets the view's example drawable attribute value. In the example view, this drawable is
     * drawn above the text.

     * @param exampleDrawable The example drawable attribute value to use.
     */
    var exampleDrawable: Drawable? = null

    private var mTextPaint: TextPaint? = null
    private var mTextWidth: Float = 0.toFloat()
    private var mTextHeight: Float = 0.toFloat()
    private var mBallSize: Float = 0.toFloat()

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(context, attrs, defStyle) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        // Load attributes
        val a = context.obtainStyledAttributes(
                attrs, R.styleable.BallView, defStyle, 0)

        mExampleString = a.getString(R.styleable.BallView_exampleString)
        mExampleColor = a.getColor(R.styleable.BallView_exampleColor, mExampleColor)
        // Use getDimensionPixelSize or getDimensionPixelOffset when dealing with
        // values that should fall on pixel boundaries.
        mExampleDimension = a.getDimension(R.styleable.BallView_exampleDimension, mExampleDimension)
        mBallSize = a.getDimension(R.styleable.BallView_ballSize, mBallSize)

        if (a.hasValue(R.styleable.BallView_exampleDrawable)) {
            exampleDrawable = a.getDrawable(R.styleable.BallView_exampleDrawable)
            exampleDrawable!!.callback = this
        }

        a.recycle()

        // Set up a default TextPaint object
        mTextPaint = TextPaint()
        mTextPaint!!.flags = Paint.ANTI_ALIAS_FLAG
        mTextPaint!!.textAlign = Paint.Align.LEFT

        // Update TextPaint and text measurements from attributes
        invalidateTextPaintAndMeasurements()
    }

    private fun invalidateTextPaintAndMeasurements() {
        mTextPaint!!.textSize = mExampleDimension
        mTextPaint!!.color = mExampleColor
        mTextWidth = mTextPaint!!.measureText(mExampleString)

        val fontMetrics = mTextPaint!!.fontMetrics
        mTextHeight = fontMetrics.bottom
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // TODO: consider storing these as member variables to reduce

        val arrowBottom = (measuredHeight / 2 - mBallSize / 2).toInt()
        val arrowWidth = (mBallSize / 2).toInt()
        val arrowLeft = (measuredWidth / 2 - arrowWidth / 2).toInt()

        // Draw the example drawable on top of the text.
        exampleDrawable?.let {
            it.setBounds(arrowLeft, arrowBottom - arrowWidth, arrowLeft + arrowWidth, arrowBottom)
            it.draw(canvas)
        }

        canvas.drawCircle((measuredWidth / 2).toFloat(), (measuredHeight / 2).toFloat(), mBallSize / 2, mTextPaint!!)
        pivotX = (measuredWidth / 2).toFloat()
        pivotY = (measuredHeight / 2).toFloat()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = (mBallSize * 2).toInt()
        setMeasuredDimension(size, size)
    }
}
