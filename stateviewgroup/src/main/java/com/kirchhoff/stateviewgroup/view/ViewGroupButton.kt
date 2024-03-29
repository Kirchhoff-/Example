package com.kirchhoff.stateviewgroup.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.CheckedTextView
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.content.res.use
import com.kirchhoff.stateviewgroup.R
import com.kirchhoff.stateviewgroup.extensions.setImageTint
import com.kirchhoff.stateviewgroup.extensions.textColor

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

        background = ContextCompat.getDrawable(context, R.drawable.background_selector)
        civIcon.setImageTint(R.color.text_color_selector)
        civIndicator.setImageTint(R.color.icon_tint_selector)
        ctvLabel.textColor(R.color.icon_tint_selector)

        isClickable = true
        isFocusable = true
    }

    override fun setEnabled(enabled: Boolean) {
        super.setEnabled(enabled)
        for (i in 0..childCount) {
            getChildAt(i)?.isEnabled = enabled
        }
    }
}
