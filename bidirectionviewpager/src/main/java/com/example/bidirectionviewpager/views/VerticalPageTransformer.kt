package com.example.bidirectionviewpager.views

import android.view.View
import androidx.viewpager.widget.ViewPager

class VerticalPageTransformer : ViewPager.PageTransformer {

    override fun transformPage(view: View, position: Float) {
        when {
            position < -1 -> view.alpha = 0f
            position <= 1 -> { // [-1,1]
                view.alpha = 1f
                // Counteract the default slide transition
                view.translationX = view.width * -position
                // set Y position to swipe in from top
                val yPosition = position * view.height
                view.translationY = yPosition
            }
            else -> view.alpha = 0f
        }
    }
}
