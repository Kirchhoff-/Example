package com.example.kirchhoff.example.ui.recycler.testable.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

import com.example.kirchhoff.example.ui.recycler.testable.SimpleListItemView

internal class SimpleListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), SimpleListItemView {

    override fun setText(text: String) {
        (itemView as TextView).text = text
    }

}