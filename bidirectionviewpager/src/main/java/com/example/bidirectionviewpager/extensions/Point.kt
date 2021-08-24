package com.example.bidirectionviewpager.extensions

import android.graphics.Point
import kotlin.math.hypot

fun Point.distanceFrom(point: Point): Int {
    val diffX = x - point.x
    val diffY = y - point.y
    return hypot(diffX.toDouble(), diffY.toDouble()).toInt()
}
