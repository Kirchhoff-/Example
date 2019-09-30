package com.example.recyclerdragdrop.adapter.holder

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerdragdrop.R

internal class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val tvSectionHeader: TextView = itemView.findViewById(R.id.tvSectionHeader)

    fun bind(type: String) {
        tvSectionHeader.text = type
    }
}