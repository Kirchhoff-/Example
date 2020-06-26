package com.kirchhoff.stateviewgroup.extensions

import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

fun TextView.textColor(@ColorRes id: Int) {
    setTextColor(ContextCompat.getColorStateList(context, id))
}
