package com.example.raindropview

import android.graphics.Canvas
import android.graphics.Paint

data class RainDrop(private val centerX: Float, private val centerY: Float, private val maxRadius: Float) {

    private var currentRadius = 1f

    fun draw(canvas: Canvas, paint: Paint) {
        paint.apply { alpha = ((maxRadius - currentRadius) / maxRadius * MAX_ALPHA).toInt() }
        canvas.drawCircle(centerX, centerY, currentRadius++, paint)
    }

    fun isValid() = currentRadius < maxRadius

    companion object {
        private const val MAX_ALPHA = 255
    }
}
