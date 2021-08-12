package com.example.recyclersmoothswipe

import android.os.Bundle
import android.view.MotionEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclersmoothswipe.adapter.ColorsAdapter
import com.example.recyclersmoothswipe.utils.OnItemTouchListenerAdapter

class RecyclerSmoothSwipeActivity : AppCompatActivity(R.layout.a_recycler_smooth_swipe) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ColorsAdapter(this)

        recyclerView.addOnItemTouchListener(object : OnItemTouchListenerAdapter() {
            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                if (e.action == MotionEvent.ACTION_DOWN &&
                        rv.scrollState == RecyclerView.SCROLL_STATE_SETTLING) {
                    rv.stopScroll()
                }
                return false
            }
        })
    }
}
