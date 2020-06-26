package com.kirchhoff.stateviewgroup.extensions

import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

fun ImageView.setImageTint(@ColorRes id: Int) {
    imageTintList = ContextCompat.getColorStateList(context, id)
}
