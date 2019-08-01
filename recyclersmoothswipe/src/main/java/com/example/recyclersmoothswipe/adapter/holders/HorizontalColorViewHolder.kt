package com.example.recyclersmoothswipe.adapter.holders

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.recyclersmoothswipe.R
import com.example.recyclersmoothswipe.adapter.SimpleAdapter

internal class HorizontalColorViewHolder(private val context: Context, view: View) : ColorViewHolder(context, view) {

    private val recyclerViewHorizontal: RecyclerView = view.findViewById(R.id.recyclerView_horizontal)

    override fun bind(color: String) {
        recyclerViewHorizontal.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        recyclerViewHorizontal.adapter = SimpleAdapter(context)
    }
}