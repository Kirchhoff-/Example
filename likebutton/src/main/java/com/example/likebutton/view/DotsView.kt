package com.example.likebutton.view

import android.animation.ArgbEvaluator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Property
import android.view.View
import com.example.likebutton.utils.MathUtils

class DotsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    companion object {
        val DOTS_PROGRESS: Property<DotsView, Float> = object : Property<DotsView, Float>(Float::class.java, "dotsProgress") {

            override fun get(dotsView: DotsView) = dotsView.currentProgress

            override fun set(dotsView: DotsView, value: Float) {
                dotsView.currentProgress = value
            }
        }

        private const val DOTS_COUNT = 12
        private const val OUTER_DOTS_POSITION_ANGLE = 360 / DOTS_COUNT

        private const val COLOR_1 = -0x3ef9
        private const val COLOR_2 = -0x6800
        private const val COLOR_3 = -0xa8de
        private const val COLOR_4 = -0xbbcca
    }

    private val circlePaints = arrayOfNulls<Paint>(4)
    private var centerX: Int = 0
    private var centerY: Int = 0
    private var maxOuterDotsRadius: Float = 0f
    private var maxInnerDotsRadius: Float = 0f
    private var maxDotSize: Float = 0f
    private var currentRadius1 = 0f
    private var currentDotSize1 = 0f
    private var currentDotSize2 = 0f
    private var currentRadius2 = 0f
    private val argbEvaluator = ArgbEvaluator()
    var currentProgress = 0f
        set(currentProgress) {
            field = currentProgress

            updateInnerDotsPosition()
            updateOuterDotsPosition()
            updateDotsPaints()
            updateDotsAlpha()

            postInvalidate()
        }

    init {
        for (i in circlePaints.indices) {
            circlePaints[i] = Paint()
            circlePaints[i]?.style = Paint.Style.FILL
        }
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        centerX = w / 2
        centerY = h / 2
        maxDotSize = 20f
        maxOuterDotsRadius = w / 2 - maxDotSize * 2
        maxInnerDotsRadius = 0.8f * maxOuterDotsRadius
    }

    override fun onDraw(canvas: Canvas) {
        drawOuterDotsFrame(canvas)
        drawInnerDotsFrame(canvas)
    }

    private fun drawOuterDotsFrame(canvas: Canvas) {
        for (i in 0 until DOTS_COUNT) {
            val cX = getCenterPointForOuterDots(true, i)
            val cY = getCenterPointForOuterDots(false, i)
            canvas.drawCircle(cX, cY, currentDotSize1, circlePaints[i % circlePaints.size]!!)
        }
    }

    private fun getCenterPointForOuterDots(isXCoordinate: Boolean, dot: Int): Float {
        val angle = dot.toDouble() * OUTER_DOTS_POSITION_ANGLE.toDouble() * Math.PI / 180

        val resultAngle = if (isXCoordinate) Math.cos(angle) else Math.sin(angle)

        return centerX + currentRadius1 * resultAngle.toFloat()
    }

    private fun drawInnerDotsFrame(canvas: Canvas) {
        for (i in 0 until DOTS_COUNT) {
            val cX = getCenterPointForInnerDots(true, i)
            val cY = getCenterPointForInnerDots(false, i)
            canvas.drawCircle(cX, cY, currentDotSize2, circlePaints[(i + 1) % circlePaints.size]!!)
        }
    }

    private fun getCenterPointForInnerDots(isXCoordinate: Boolean, dot: Int): Float {
        val angle = (dot * OUTER_DOTS_POSITION_ANGLE - 10) * Math.PI / 180

        val resultAngle = if (isXCoordinate) Math.cos(angle) else Math.sin(angle)

        return centerX + currentRadius2 * resultAngle.toFloat()
    }

    private fun updateInnerDotsPosition() {
        currentRadius2 = if (currentProgress < 0.3f) {
            MathUtils.mapValueFromRangeToRange(currentProgress.toDouble(), 0.0, 0.3, 0.0, maxInnerDotsRadius.toDouble()).toFloat()
        } else {
            maxInnerDotsRadius
        }

        currentDotSize2 = when {
            currentProgress < 0.2 -> maxDotSize
            currentProgress < 0.5 -> MathUtils.mapValueFromRangeToRange(currentProgress.toDouble(), 0.2, 0.5, maxDotSize.toDouble(), 0.3 * maxDotSize).toFloat()
            else -> MathUtils.mapValueFromRangeToRange(currentProgress.toDouble(), 0.5, 1.0, (maxDotSize * 0.3f).toDouble(), 0.0).toFloat()
        }
    }

    private fun updateOuterDotsPosition() {
        currentRadius1 = if (currentProgress < 0.3f) {
            MathUtils.mapValueFromRangeToRange(currentProgress.toDouble(), 0.0, 0.3, 0.0, (maxOuterDotsRadius * 0.8f).toDouble()).toFloat()
        } else {
            MathUtils.mapValueFromRangeToRange(currentProgress.toDouble(), 0.3, 1.0, (0.8f * maxOuterDotsRadius).toDouble(), maxOuterDotsRadius.toDouble()).toFloat()
        }

        currentDotSize1 = if (currentProgress < 0.7) {
            maxDotSize
        } else {
            MathUtils.mapValueFromRangeToRange(currentProgress.toDouble(), 0.7, 1.0, maxDotSize.toDouble(), 0.0).toFloat()
        }
    }

    private fun updateDotsPaints() {
        if (currentProgress < 0.5f) {
            val progress = MathUtils.mapValueFromRangeToRange(currentProgress.toDouble(), 0.0, 0.5, 0.0, 1.0).toFloat()
            circlePaints[0]?.color = argbEvaluator.evaluate(progress, COLOR_1, COLOR_2) as Int
            circlePaints[1]?.color = argbEvaluator.evaluate(progress, COLOR_2, COLOR_3) as Int
            circlePaints[2]?.color = argbEvaluator.evaluate(progress, COLOR_3, COLOR_4) as Int
            circlePaints[3]?.color = argbEvaluator.evaluate(progress, COLOR_4, COLOR_1) as Int
        } else {
            val progress = MathUtils.mapValueFromRangeToRange(currentProgress.toDouble(), 0.5, 1.0, 0.0, 1.0).toFloat()
            circlePaints[0]?.color = argbEvaluator.evaluate(progress, COLOR_2, COLOR_3) as Int
            circlePaints[1]?.color = argbEvaluator.evaluate(progress, COLOR_3, COLOR_4) as Int
            circlePaints[2]?.color = argbEvaluator.evaluate(progress, COLOR_4, COLOR_1) as Int
            circlePaints[3]?.color = argbEvaluator.evaluate(progress, COLOR_1, COLOR_2) as Int
        }
    }

    private fun updateDotsAlpha() {
        val progress = MathUtils.clamp(currentProgress.toDouble(), 0.6, 1.0).toFloat()
        val alpha = MathUtils.mapValueFromRangeToRange(progress.toDouble(), 0.6, 1.0, 255.0, 0.0).toInt()
        circlePaints[0]?.alpha = alpha
        circlePaints[1]?.alpha = alpha
        circlePaints[2]?.alpha = alpha
        circlePaints[3]?.alpha = alpha
    }
}
