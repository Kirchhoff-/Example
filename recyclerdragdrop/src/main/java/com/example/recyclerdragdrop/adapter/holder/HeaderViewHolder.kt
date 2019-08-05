package com.example.recyclerdragdrop.adapter.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.example.recyclerdragdrop.R

internal class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val tvSectionHeader: TextView = itemView.findViewById(R.id.tvSectionHeader)

    fun bind(type: String) {
        tvSectionHeader.text = type
    }
}