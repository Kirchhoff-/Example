package com.example.kirchhoff.example.ui.recycler.diffutil.ex1

import android.animation.ValueAnimator
import android.widget.TextView
import com.example.kirchhoff.example.R
import com.example.kirchhoff.example.ui.extensions.setFormatDigit

/**
 * @author Kirchhoff-
 */
class TimeViewHolder(itemView: android.view.View?) : BaseViewHolder<Time>(itemView) {

    companion object {
        @JvmStatic
        val valueAnimator: ValueAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
            this.repeatCount = android.animation.ValueAnimator.INFINITE
            this.repeatMode = android.animation.ValueAnimator.REVERSE
            this.duration = 400
            this.start()
        }
    }

    val vFirstDivider by lazy { itemView?.findViewById<TextView>(R.id.vFirstDivider) }
    val vSecondDivider by lazy { itemView?.findViewById<TextView>(R.id.vSecondDivider) }
    val tvId by lazy { itemView?.findViewById<TextView>(R.id.tvId) }
    val tvHours by lazy { itemView?.findViewById<TextView>(R.id.tvHours) }
    val tvMinutes by lazy { itemView?.findViewById<TextView>(R.id.tvMinutes) }
    val tvSeconds by lazy { itemView?.findViewById<TextView>(R.id.tvSeconds) }

    init {
        TimeViewHolder.Companion.valueAnimator.addUpdateListener {
            vFirstDivider?.alpha = it.animatedFraction
            vSecondDivider?.alpha = it.animatedFraction
        }
    }


    override fun onBind(item: Time) {
        with(item) {
            tvId?.text = id
            tvHours?.setFormatDigit(hours)
            tvMinutes?.setFormatDigit(minute)
            tvSeconds?.setFormatDigit(seconds)
        }
    }

}