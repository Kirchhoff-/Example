package com.example.kirchhoff.example.ui.recycler.diffutil

import android.animation.ValueAnimator
import android.view.View
import android.widget.TextView
import com.example.kirchhoff.example.R
import com.example.kirchhoff.example.ui.extensions.setFormatDigit

/**
 * @author Kirchhoff-
 */
class TimeViewHolder(itemView: View?) : BaseViewHolder<Time>(itemView) {

    companion object {
        @JvmStatic
        val valueAnimator: ValueAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
            this.repeatCount = ValueAnimator.INFINITE
            this.repeatMode = ValueAnimator.REVERSE
            this.duration = 400
            this.start()
        }
    }

    val vFirstDivider by lazy { itemView?.findViewById(R.id.vFirstDivider) }
    val vSecondDivider by lazy { itemView?.findViewById(R.id.vSecondDivider) }
    val tvId by lazy { itemView?.findViewById(R.id.tvId) as TextView? }
    val tvHours by lazy { itemView?.findViewById(R.id.tvHours) as TextView? }
    val tvMinutes by lazy { itemView?.findViewById(R.id.tvMinutes) as TextView? }
    val tvSeconds by lazy { itemView?.findViewById(R.id.tvSeconds) as TextView? }

    init {
        valueAnimator.addUpdateListener {
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