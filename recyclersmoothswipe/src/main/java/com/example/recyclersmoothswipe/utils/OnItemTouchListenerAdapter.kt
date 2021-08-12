package com.example.recyclersmoothswipe.utils

import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView

abstract class OnItemTouchListenerAdapter : RecyclerView.OnItemTouchListener {
    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean = false
    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
        // override if required
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
        // override if required
    }
}
