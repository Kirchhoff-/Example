package com.example.kirchhoff.example.ui.Extensions

import android.widget.TextView

/**
 * @author Kirchhoff-
 */
fun TextView.setFormatDigit(digit: Int) {
    text = String.format("%02d", digit)
}