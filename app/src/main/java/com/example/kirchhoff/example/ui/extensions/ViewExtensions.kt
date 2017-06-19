package com.example.kirchhoff.example.ui.extensions

import android.widget.TextView

/**
 * @author Kirchhoff-
 */
fun TextView.setFormatDigit(digit: Int) {
    text = String.format("%02d", digit)
}