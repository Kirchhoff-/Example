package com.kirchhoff.numbervisualizer.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import androidx.annotation.DimenRes
import androidx.core.content.ContextCompat
import com.kirchhoff.numbervisualizer.R

internal class NumberVisualizerView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val numberList: ArrayList<Int>
    private val blockHeight: Int
    private var widthPerNumber = 0f
    private var maxValue = 0
    private val marginHeight: Int
    private var maxSize = 0

    private val paint: Paint

    init {
        blockHeight = toPixel(R.dimen.block_size)
        marginHeight = toPixel(R.dimen.block_margin)
        numberList = arrayListOf()

        paint = Paint()
        paint.color = ContextCompat.getColor(context, R.color.block_color)
        paint.strokeWidth = resources.getDimension(R.dimen.block_stroke_width)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)
        maxSize = height / (blockHeight + marginHeight)
        widthPerNumber = width.toFloat().div(maxValue)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        for (i in numberList.indices) {
            drawRectangle(canvas, i, numberList[i])
        }
    }

    fun setMaxNumber(maxValue: Int) {
        this.maxValue = maxValue
    }

    fun newNumber(number: Int) {
        if (numberList.size == maxSize) {
            numberList.remove(numberList.size)
        }

        numberList.add(0, number)
        invalidate()
    }

    private fun drawRectangle(canvas: Canvas?, position: Int, number: Int) {
        val yOffset = (position * (blockHeight + marginHeight)).toFloat()
        canvas?.drawRect(0f, yOffset, number * widthPerNumber, yOffset + blockHeight, paint)
    }

    private fun toPixel(@DimenRes dimen: Int): Int =
            TypedValue.applyDimension(
                    TypedValue.COMPLEX_UNIT_DIP,
                    resources.getDimension(dimen),
                    resources.getDisplayMetrics()).toInt()
}
