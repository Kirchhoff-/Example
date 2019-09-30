package com.kirchhoff.thingdiffutils

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ThingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val textView: TextView = itemView.findViewById(R.id.text)

    fun bind(thing: Thing) {
        itemView.setBackgroundColor(thing.color)
        textView.text = thing.text
    }
}
