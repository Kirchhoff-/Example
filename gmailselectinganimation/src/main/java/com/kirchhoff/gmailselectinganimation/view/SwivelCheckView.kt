package com.kirchhoff.gmailselectinganimation.view

import android.content.Context
import android.graphics.Camera
import android.util.AttributeSet
import android.view.View
import android.view.animation.Animation
import android.view.animation.Transformation
import android.widget.Checkable
import android.widget.ImageView
import android.widget.ViewFlipper
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import com.kirchhoff.gmailselectinganimation.R
import com.kirchhoff.gmailselectinganimation.view.SwivelAnimation.Companion.toChecked
import com.kirchhoff.gmailselectinganimation.view.SwivelAnimation.Companion.toNotChecked

class SwivelCheckView constructor(context: Context, attrs: AttributeSet) :
    ViewFlipper(context, attrs), Checkable {

    private val imageView: ImageView
    private val calculateCenterX = { width / 2f }
    private val updateDisplayedSide: (DisplaySide) -> Unit = { setDisplaySide(it) }
    private val toCheckedAnimation = toChecked(calculateCenterX, updateDisplayedSide)
    private val toNotCheckedAnimation = toNotChecked(calculateCenterX, updateDisplayedSide)

    private var isChecked: Boolean = false

    init {
        View.inflate(context, R.layout.view_swivel_check, this)
        imageView = findViewById(R.id.imageView)
    }

    fun setChecked(targetState: Boolean, shouldAnimate: Boolean = true) {
        if (shouldAnimate) {
            setChecked(targetState)
        } else {
            setDisplaySide(if (targetState) DisplaySide.BACK else DisplaySide.FRONT)
            isChecked = targetState
        }
    }

    private fun setDisplaySide(displaySide: DisplaySide) {
        if (displayedChild != displaySide.viewFlipperChildIndex) {
            displayedChild = displaySide.viewFlipperChildIndex
        }
    }

    override fun setChecked(targetState: Boolean) {
        if (targetState == isChecked) {
            return
        }
        if (targetState) {
            isChecked = true
            startAnimation(toCheckedAnimation)
        } else {
            isChecked = false
            startAnimation(toNotCheckedAnimation)
        }
    }

    override fun isChecked() = isChecked
    override fun toggle() = setChecked(!isChecked)

    fun imageView(): ImageView = imageView
}

private class SwivelAnimation(
    private val rotation: ClosedFloatingPointRange<Float>,
    private val calculateCenterX: () -> Float,
    private val updateDisplayedSide: (DisplaySide) -> Unit
) : Animation() {

    private val camera = Camera()

    override fun applyTransformation(interpolatedTime: Float, transformation: Transformation) {
        val degrees = rotation.start + (rotation.endInclusive - rotation.start) * interpolatedTime

        val matrix = transformation.matrix
        val centerX = calculateCenterX()
        camera.save()
        camera.rotateY(degrees)
        camera.getMatrix(matrix)
        camera.restore()

        matrix.preTranslate(-centerX, 0f)
        matrix.postTranslate(centerX, 0f)

        val displaySide = if (degrees >= RIGHT_ANGLE) DisplaySide.BACK else DisplaySide.FRONT
        updateDisplayedSide(displaySide)
        if (displaySide == DisplaySide.BACK) {
            matrix.preScale(-1f, 1f, centerX, 0f)
        }
    }

    companion object {

        private const val RIGHT_ANGLE = 90
        private val ROTATION_TO_CHECKED = 0f..180f
        private val ROTATION_TO_NOT_CHECKED = 180f..0f
        private const val DURATION_MS = 320L

        fun toChecked(calculateCenterX: () -> Float, updateDisplayedSide: (DisplaySide) -> Unit) =
                createAnimation(ROTATION_TO_CHECKED, calculateCenterX, updateDisplayedSide)

        fun toNotChecked(
            calculateCenterX: () -> Float,
            updateDisplayedSide: (DisplaySide) -> Unit
        ) =
                createAnimation(ROTATION_TO_NOT_CHECKED, calculateCenterX, updateDisplayedSide)

        private fun createAnimation(
            rotation: ClosedFloatingPointRange<Float>,
            calculateCenterX: () -> Float,
            updateDisplayedSide: (DisplaySide) -> Unit
        ): Animation {
            return SwivelAnimation(rotation, calculateCenterX, updateDisplayedSide).apply {
                duration = DURATION_MS
                interpolator = FastOutSlowInInterpolator()
            }
        }
    }
}

private enum class DisplaySide(val viewFlipperChildIndex: Int) {
    FRONT(0),
    BACK(1)
}
