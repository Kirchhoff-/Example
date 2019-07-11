package com.kirchhoff.thingdiffutils

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class ThingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val textView: TextView = itemView.findViewById(R.id.text)

    fun bind(thing: Thing) {
        itemView.setBackgroundColor(thing.color)
        textView.text = thing.text
    }
}
