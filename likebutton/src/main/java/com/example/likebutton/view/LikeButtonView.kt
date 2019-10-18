package com.example.likebutton.view

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.animation.DecelerateInterpolator
import android.view.animation.OvershootInterpolator
import android.widget.FrameLayout
import android.widget.ImageView
import com.kirchhoff.likebutton.R

class LikeButtonView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), View.OnClickListener {

    companion object {
        private val DECELERATE_INTERPOLATOR = DecelerateInterpolator()
        private val ACCELERATE_DECELERATE_INTERPOLATOR = AccelerateDecelerateInterpolator()
        private val OVERSHOOT_INTERPOLATOR = OvershootInterpolator(4f)
    }

    private val ivStar: ImageView
    private val vDotsView: DotsView
    private val vCircle: CircleView

    private var isChecked: Boolean = false
    private var animatorSet: AnimatorSet? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.v_like_button, this, true)
        ivStar = findViewById(R.id.ivStar)
        vDotsView = findViewById(R.id.vDotsView)
        vCircle = findViewById(R.id.vCircle)
        setOnClickListener(this)
    }

    override fun onClick(v: View) {
        isChecked = !isChecked
        ivStar.setImageResource(if (isChecked) R.drawable.ic_star else R.drawable.ic_star_empty)

        animatorSet?.cancel()

        if (isChecked) {
            ivStar.animate().cancel()
            ivStar.scaleX = 0f
            ivStar.scaleY = 0f
            vCircle.innerCircleRadiusProgress = 0f
            vCircle.outerCircleRadiusProgress = 0f
            vDotsView.currentProgress = 0f

            animatorSet = AnimatorSet()

            val outerCircleAnimator = ObjectAnimator.ofFloat(vCircle, CircleView.OUTER_CIRCLE_RADIUS_PROGRESS, 0.1f, 1f)
            outerCircleAnimator.duration = 250
            outerCircleAnimator.interpolator = DECELERATE_INTERPOLATOR

            val innerCircleAnimator = ObjectAnimator.ofFloat(vCircle, CircleView.INNER_CIRCLE_RADIUS_PROGRESS, 0.1f, 1f)
            innerCircleAnimator.duration = 200
            innerCircleAnimator.startDelay = 200
            innerCircleAnimator.interpolator = DECELERATE_INTERPOLATOR

            val starScaleYAnimator = ObjectAnimator.ofFloat(ivStar, ImageView.SCALE_Y, 0.2f, 1f)
            starScaleYAnimator.duration = 350
            starScaleYAnimator.startDelay = 250
            starScaleYAnimator.interpolator = OVERSHOOT_INTERPOLATOR

            val starScaleXAnimator = ObjectAnimator.ofFloat(ivStar, ImageView.SCALE_X, 0.2f, 1f)
            starScaleXAnimator.duration = 350
            starScaleXAnimator.startDelay = 250
            starScaleXAnimator.interpolator = OVERSHOOT_INTERPOLATOR

            val dotsAnimator = ObjectAnimator.ofFloat(vDotsView, DotsView.DOTS_PROGRESS, 0f, 1f)
            dotsAnimator.duration = 900
            dotsAnimator.startDelay = 50
            dotsAnimator.interpolator = ACCELERATE_DECELERATE_INTERPOLATOR

            animatorSet?.playTogether(
                    outerCircleAnimator,
                    innerCircleAnimator,
                    starScaleYAnimator,
                    starScaleXAnimator,
                    dotsAnimator)

            animatorSet?.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationCancel(animation: Animator) {
                    vCircle.innerCircleRadiusProgress = 0f
                    vCircle.outerCircleRadiusProgress = 0f
                    vDotsView.currentProgress = 0f
                    ivStar.scaleX = 1f
                    ivStar.scaleY = 1f
                }
            })

            animatorSet?.start()
        }
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                ivStar.animate().scaleX(0.7f).scaleY(0.7f).setDuration(150).interpolator = DECELERATE_INTERPOLATOR
                isPressed = true
            }

            MotionEvent.ACTION_MOVE -> {
                val x = event.x
                val y = event.y
                val isInside = x > 0 && x < width && y > 0 && y < height
                if (isPressed != isInside) {
                    isPressed = isInside
                }
            }

            MotionEvent.ACTION_UP -> {
                ivStar.animate().scaleX(1f).scaleY(1f).interpolator = DECELERATE_INTERPOLATOR
                if (isPressed) {
                    performClick()
                    isPressed = false
                }
            }
        }

        return true
    }

    override fun performClick(): Boolean {
        super.performClick()
        return true
    }
}
