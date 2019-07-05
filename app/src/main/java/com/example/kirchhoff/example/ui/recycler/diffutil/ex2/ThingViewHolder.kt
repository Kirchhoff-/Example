package com.example.kirchhoff.example.ui.recycler.diffutil.ex2

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

import com.example.kirchhoff.example.R

class ThingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val textView: TextView = itemView.findViewById(R.id.text)

    fun bind(thing: Thing) {
        itemView.setBackgroundColor(thing.color)
        textView.text = thing.text
    }
}
