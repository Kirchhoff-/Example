package com.example.recyclersmoothswipe.adapter.holders

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.View
import android.widget.FrameLayout
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclersmoothswipe.R

internal open class ColorViewHolder(private val context: Context, view: View) : RecyclerView.ViewHolder(view) {

    open fun bind(color: String) {
        val container: FrameLayout = itemView.findViewById(R.id.container)
        container.setBackgroundColor(Color.parseColor(color))
        container.setOnClickListener {
            Log.d("TraceTouch", "ColorViewHolder is clicked")
            Toast.makeText(context, "ColorViewHolder is clicked", Toast.LENGTH_SHORT).show()
        }
    }
}