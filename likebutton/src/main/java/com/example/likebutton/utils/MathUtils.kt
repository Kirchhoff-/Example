package com.example.likebutton.utils

class MathUtils {

    companion object {
        fun mapValueFromRangeToRange(value: Double, fromLow: Double, fromHigh: Double, toLow: Double, toHigh: Double): Double {
            return toLow + (value - fromLow) / (fromHigh - fromLow) * (toHigh - toLow)
        }

        fun clamp(value: Double, low: Double, high: Double): Double {
            return Math.min(Math.max(value, low), high)
        }
    }
}
