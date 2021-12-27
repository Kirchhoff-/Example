package com.kirchhoff.stateviewgroup.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.Checkable
import android.widget.CheckedTextView
import android.widget.ImageView
import androidx.core.content.res.use
import com.kirchhoff.stateviewgroup.R
import com.kirchhoff.stateviewgroup.extensions.setImageTint
import com.kirchhoff.stateviewgroup.extensions.textColor

class ViewGroupCheckableButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ViewGroupButton(context, attrs, defStyleAttr), Checkable {

    private var checked = false

    init {
        context.theme.obtainStyledAttributes(attrs, R.styleable.ViewGroupCheckableButton, 0, 0).use {
            isChecked = it.getBoolean(R.styleable.ViewGroupCheckableButton_android_checked, isChecked)
        }

        background = context.getDrawable(R.drawable.checkable_background_selector)
        findViewById<ImageView>(R.id.civIcon).setImageTint(R.color.checkable_text_color_selector)
        findViewById<CheckableImageView>(R.id.civIndicator).setImageTint(R.color.checkable_icon_tint_selector)
        findViewById<CheckedTextView>(R.id.ctvLabel).textColor(R.color.checkable_icon_tint_selector)
    }

    override fun isChecked() = checked

    override fun toggle() {
        isChecked = !checked
    }

    override fun setChecked(checked: Boolean) {
        if (this.checked != checked) {
            this.checked = checked
            for (i in 0..childCount) {
                val checkableChild = getChildAt(i)
                if (checkableChild is Checkable) {
                    checkableChild.isChecked = checked
                }
            }
            refreshDrawableState()
        }
    }

    override fun performClick(): Boolean {
        toggle()
        return super.performClick()
    }

    override fun onCreateDrawableState(extraSpace: Int): IntArray {
        val drawableState = super.onCreateDrawableState(extraSpace + 1)
        if (isChecked) {
            View.mergeDrawableStates(drawableState, STATE_CHECKED)
        }
        return drawableState
    }

    companion object {
        private val STATE_CHECKED = intArrayOf(android.R.attr.state_checked)
    }
}
