package com.example.timediffutils.adapter

import android.animation.ValueAnimator
import android.widget.TextView
import com.example.timediffutils.data.Time
import com.example.timediffutils.extensions.setFormatDigit
import com.kirchhoff.timediffutils.R

class TimeViewHolder(itemView: android.view.View) : BaseViewHolder<Time>(itemView) {

    companion object {
        @JvmStatic
        val valueAnimator: ValueAnimator = ValueAnimator.ofFloat(0f, 1f).apply {
            this.repeatCount = ValueAnimator.INFINITE
            this.repeatMode = ValueAnimator.REVERSE
            this.duration = 400
            this.start()
        }
    }

    private val vFirstDivider: TextView by lazy { itemView.findViewById<TextView>(R.id.vFirstDivider) }
    private val vSecondDivider: TextView by lazy { itemView.findViewById<TextView>(R.id.vSecondDivider) }
    private val tvId: TextView by lazy { itemView.findViewById<TextView>(R.id.tvId) }
    private val tvHours: TextView by lazy { itemView.findViewById<TextView>(R.id.tvHours) }
    private val tvMinutes: TextView by lazy { itemView.findViewById<TextView>(R.id.tvMinutes) }
    private val tvSeconds: TextView by lazy { itemView.findViewById<TextView>(R.id.tvSeconds) }

    init {
        valueAnimator.addUpdateListener {
            vFirstDivider.alpha = it.animatedFraction
            vSecondDivider.alpha = it.animatedFraction
        }
    }

    override fun onBind(item: Time) {
        with(item) {
            tvId.text = id
            tvHours.setFormatDigit(hours)
            tvMinutes.setFormatDigit(minute)
            tvSeconds.setFormatDigit(seconds)
        }
    }
}
