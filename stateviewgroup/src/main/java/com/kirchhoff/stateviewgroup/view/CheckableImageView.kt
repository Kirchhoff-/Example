package com.kirchhoff.stateviewgroup.view

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.widget.Checkable
import android.widget.ImageView

@SuppressLint("AppCompatCustomView")
class CheckableImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ImageView(context, attrs, defStyleAttr), Checkable {

    private var isChecked = false

    override fun isChecked() = isChecked

    override fun toggle() {
        isChecked = !isChecked()
    }

    override fun setChecked(checked: Boolean) {
        if (checked != isChecked) {
            isChecked = checked
            refreshDrawableState()
        }
    }

    override fun onCreateDrawableState(extraSpace: Int): IntArray {
        val drawableState = super.onCreateDrawableState(extraSpace + 1)
        if (isChecked) {
            mergeDrawableStates(drawableState, STATE_CHECKED)
        }
        return drawableState
    }

    override fun drawableStateChanged() {
        super.drawableStateChanged()
        invalidate()
    }

    companion object {
        private val STATE_CHECKED = intArrayOf(android.R.attr.state_checked)
    }
}
