package com.example.likebutton.view

import android.animation.ArgbEvaluator
import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PorterDuff
import android.graphics.PorterDuffXfermode
import android.util.AttributeSet
import android.util.Property
import android.view.View
import com.example.likebutton.utils.MathUtils

class CircleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val argbEvaluator = ArgbEvaluator()
    private val circlePaint = Paint()
    private val maskPaint = Paint()
    private lateinit var tempBitmap: Bitmap
    private lateinit var tempCanvas: Canvas
    var outerCircleRadiusProgress = 0f
        set(outerCircleRadiusProgress) {
            field = outerCircleRadiusProgress
            updateCircleColor()
            postInvalidate()
        }
    var innerCircleRadiusProgress = 0f
        set(innerCircleRadiusProgress) {
            field = innerCircleRadiusProgress
            postInvalidate()
        }
    private var maxCircleSize: Int = 0

    init {
        circlePaint.style = Paint.Style.FILL
        maskPaint.xfermode = PorterDuffXfermode(PorterDuff.Mode.CLEAR)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        maxCircleSize = w / 2
        tempBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888)
        tempCanvas = Canvas(tempBitmap)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        tempCanvas.drawColor(0xffffff, PorterDuff.Mode.CLEAR)
        tempCanvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), this.outerCircleRadiusProgress * maxCircleSize, circlePaint)
        tempCanvas.drawCircle((width / 2).toFloat(), (height / 2).toFloat(), this.innerCircleRadiusProgress * maxCircleSize, maskPaint)
        canvas.drawBitmap(tempBitmap, 0f, 0f, null)
    }

    private fun updateCircleColor() {
        var colorProgress = MathUtils.clamp(this.outerCircleRadiusProgress.toDouble(), 0.5, 1.0).toFloat()
        colorProgress = MathUtils.mapValueFromRangeToRange(colorProgress.toDouble(), 0.5, 1.0, 0.0, 1.0).toFloat()
        this.circlePaint.color = argbEvaluator.evaluate(colorProgress, START_COLOR, END_COLOR) as Int
    }

    companion object {
        private const val START_COLOR = -0xa8de
        private const val END_COLOR = -0x3ef9

        val INNER_CIRCLE_RADIUS_PROGRESS: Property<CircleView, Float> = object : Property<CircleView, Float>(Float::class.java, "innerCircleRadiusProgress") {

            override fun get(circleView: CircleView) = circleView.innerCircleRadiusProgress

            override fun set(circleView: CircleView, value: Float) {
                circleView.innerCircleRadiusProgress = value
            }
        }

        val OUTER_CIRCLE_RADIUS_PROGRESS: Property<CircleView, Float> = object : Property<CircleView, Float>(Float::class.java, "outerCircleRadiusProgress") {

            override fun get(circleView: CircleView) = circleView.outerCircleRadiusProgress

            override fun set(circleView: CircleView, value: Float) {
                circleView.outerCircleRadiusProgress = value
            }
        }
    }
}
