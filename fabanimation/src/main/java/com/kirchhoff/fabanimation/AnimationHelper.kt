package com.kirchhoff.fabanimation

import android.content.Context
import android.support.annotation.AnimRes
import android.view.animation.Animation
import android.view.animation.AnimationUtils

internal class AnimationHelper(private val context: Context) {

    private val fabOpen: Animation
    private val fabClose: Animation
    private val rotateForward: Animation
    private val rotateBackward: Animation

    init {
        fabOpen = loadAnimation(R.anim.fab_open)
        fabClose = loadAnimation(R.anim.fab_close)
        rotateForward = loadAnimation(R.anim.rotate_forward)
        rotateBackward = loadAnimation(R.anim.rotate_backward)
    }

    fun openAnimation() = fabOpen
    fun closeAnimation() = fabClose
    fun rotateForwardAnimation() = rotateForward
    fun rotateBackwardAnimation() = rotateBackward

    private fun loadAnimation(@AnimRes animId: Int) = AnimationUtils.loadAnimation(context, animId)
}