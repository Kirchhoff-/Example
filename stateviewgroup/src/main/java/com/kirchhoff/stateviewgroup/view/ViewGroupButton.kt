package com.kirchhoff.stateviewgroup.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.CheckedTextView
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.use
import androidx.core.view.children
import com.kirchhoff.stateviewgroup.R

open class ViewGroupButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.v_state_button, this, true)

        val civIcon: ImageView = findViewById(R.id.civIcon)
        val civIndicator: CheckableImageView = findViewById(R.id.civIndicator)
        val ctvLabel: CheckedTextView = findViewById(R.id.ctvLabel)

        context.theme.obtainStyledAttributes(attrs, R.styleable.ViewGroupButton, 0, 0).use {
            isEnabled = it.getBoolean(R.styleable.ViewGroupButton_android_enabled, isEnabled)
            civIcon.setImageDrawable(it.getDrawable(R.styleable.ViewGroupButton_icon))
            ctvLabel.text = it.getText(R.styleable.ViewGroupButton_android_text)
        }

        background = context.getDrawable(R.drawable.background_selector)
        civIcon.imageTintList = ContextCompat.getColorStateList(context, R.color.text_color_selector)
        civIndicator.imageTintList = ContextCompat.getColorStateList(context, R.color.icon_tint_selector)
        ctvLabel.setTextColor(ContextCompat.getColorStateList(context, R.color.icon_tint_selector))

        isClickable = true
        isFocusable = true
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        children.forEach { it.isEnabled = enabled }
    }
}
