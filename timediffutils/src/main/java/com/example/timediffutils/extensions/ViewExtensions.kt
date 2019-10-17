package com.example.timediffutils.extensions

import android.widget.TextView

fun TextView.setFormatDigit(digit: Int) {
    text = String.format("%02d", digit)
}
