package com.kirchhoff.circularrevealfragment

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.os.Bundle
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.appcompat.app.AppCompatActivity
import com.kirchhoff.circularrevealfragment.fragments.DashboardFragment
import com.kirchhoff.circularrevealfragment.fragments.ExitWithAnimation
import kotlin.math.hypot

class CircularFragmentAnimationActivity : AppCompatActivity(R.layout.a_circular_fragment_animation) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        supportFragmentManager.beginTransaction()
                .replace(R.id.container, DashboardFragment.newInstance())
                .commit()
    }

    override fun onBackPressed() {
        with(supportFragmentManager.findFragmentById(R.id.container)) {
            // Check if the current fragment implements the [ExitWithAnimation] interface or not
            // Also check if the [ExitWithAnimation.isToBeExitedWithAnimation] is `true` or not
            if ((this as? ExitWithAnimation)?.isToBeExitedWithAnimation() == true &&
                    (posX != null || posY != null)) {
                this.view?.exitCircularReveal(posX!!, posY!!) { super.onBackPressed() } ?: super.onBackPressed()
            } else {
                super.onBackPressed()
            }
        }
    }

    private fun View.exitCircularReveal(exitX: Int, exitY: Int, block: () -> Unit) {
        val startRadius = hypot(this.width.toDouble(), this.height.toDouble())
        ViewAnimationUtils.createCircularReveal(this, exitX, exitY, startRadius.toFloat(), 0f).apply {
            duration = ANIMATION_DURATION
            interpolator = DecelerateInterpolator(1f)
            addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    block()
                    super.onAnimationEnd(animation)
                }
            })
            start()
        }
    }

    companion object {
        private const val ANIMATION_DURATION = 350L
    }
}
