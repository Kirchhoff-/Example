package com.example.recyclersmoothswipe.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclersmoothswipe.R
import com.example.recyclersmoothswipe.adapter.holders.ColorViewHolder
import com.example.recyclersmoothswipe.adapter.holders.HorizontalColorViewHolder

internal class ColorsAdapter(private val context: Context) : RecyclerView.Adapter<ColorViewHolder>() {

    private val item = listOf("#FF0000", LIST, "#00FF00", LIST, "#0000FF", LIST, "#FFFF00", LIST, "#FF00FF", LIST, "#00FFFF")

    companion object {
        const val LIST = "LIST"
        const val TYPE_NORMAL = 0
        const val TYPE_LIST = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ColorViewHolder {
        return when (type) {
            TYPE_LIST ->
                HorizontalColorViewHolder(context,
                        LayoutInflater.from(context)
                                .inflate(R.layout.horizontal_view, parent, false))
            else ->
                ColorViewHolder(context,
                        LayoutInflater.from(context)
                                .inflate(R.layout.vertical_cell, parent, false))
        }
    }

    override fun onBindViewHolder(view: ColorViewHolder, position: Int) = view.bind(item[position])

    override fun getItemCount() = item.size

    override fun getItemViewType(position: Int) = if (item[position] == LIST) TYPE_LIST else TYPE_NORMAL
}
