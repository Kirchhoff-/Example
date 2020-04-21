package com.kirchhoff.circularrevealfragment.fragments

import android.os.Bundle
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import kotlin.math.hypot

internal abstract class BaseCircularRevealFragment(@LayoutRes contentLayoutId: Int) :
    Fragment(contentLayoutId), ExitWithAnimation {

    override var posX: Int? = null
    override var posY: Int? = null

    abstract fun circularRevealFromLeft(): Boolean

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.startCircularReveal(circularRevealFromLeft())
    }

    private fun View.startCircularReveal(fromLeft: Boolean) {
        addOnLayoutChangeListener(object : View.OnLayoutChangeListener {
            override fun onLayoutChange(
                v: View,
                left: Int,
                top: Int,
                right: Int,
                bottom: Int,
                oldLeft: Int,
                oldTop: Int,
                oldRight: Int,
                oldBottom: Int
            ) {
                v.removeOnLayoutChangeListener(this)
                val cx = if (fromLeft) v.left else v.right
                val cy = v.bottom
                val radius = hypot(right.toDouble(), bottom.toDouble()).toFloat()
                ViewAnimationUtils.createCircularReveal(v, cx, cy, 0f, radius).apply {
                    interpolator = DecelerateInterpolator(2f)
                    duration = ANIMATION_DURATION
                    start()
                }
            }
        })
    }

    companion object {
        private const val ANIMATION_DURATION = 1000L
    }
}
