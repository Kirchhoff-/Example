package com.example.recyclersmoothswipe.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.recyclersmoothswipe.R
import com.example.recyclersmoothswipe.adapter.holders.ColorViewHolder

internal class SimpleAdapter(val context: Context) : RecyclerView.Adapter<ColorViewHolder>() {

    private val item = listOf("#FF0000", "#00FF00", "#0000FF", "#FFFF00", "#FF00FF", "#00FFFF")

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): ColorViewHolder {
        return ColorViewHolder(context,
                LayoutInflater.from(context)
                        .inflate(R.layout.horizontal_cell, parent, false))
    }

    override fun getItemCount() = item.size

    override fun onBindViewHolder(view: ColorViewHolder, position: Int) = view.bind(item[position])
}