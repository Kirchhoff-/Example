package com.example.raindropview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class RainDropView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyleAttr: Int = 0,
        defStyleRes: Int = 0
) :
        View(context, attrs, defStyleAttr, defStyleRes) {

    private val paint = Paint()
            .apply { color = Color.BLACK }
            .apply { style = Paint.Style.STROKE }
            .apply { isAntiAlias = true }
            .apply { strokeWidth = 2f }

    private var rainDropList: MutableList<RainDrop> = mutableListOf()
    private val maxRadius by lazy {
        context.resources.getDimension(R.dimen.max_radius)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val desiredWidth = suggestedMinimumWidth + paddingLeft + paddingRight
        val desiredHeight = suggestedMinimumHeight + paddingTop + paddingBottom
        setMeasuredDimension(resolveSize(desiredWidth, widthMeasureSpec),
                resolveSize(desiredHeight, heightMeasureSpec))
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        rainDropList.forEach { it.draw(canvas, paint) }
        rainDropList = rainDropList.filter { it.isValid() }.toMutableList()
        if (rainDropList.isNotEmpty() && isAttachedToWindow) invalidate()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val pointerIndex = event.actionIndex
        when (event.actionMasked) {
            MotionEvent.ACTION_DOWN,
            MotionEvent.ACTION_POINTER_DOWN -> return true
            MotionEvent.ACTION_UP,
            MotionEvent.ACTION_POINTER_UP -> {
                rainDropList.add(RainDrop(event.getX(pointerIndex), event.getY(pointerIndex), maxRadius))
                performClick()
                invalidate()
                return true
            }
        }
        return super.onTouchEvent(event)
    }

    override fun performClick(): Boolean {
        super.performClick()
        return true
    }
}
