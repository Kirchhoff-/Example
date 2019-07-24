package com.kirchhoff.fastrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class StateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val name: TextView = itemView.findViewById(R.id.name)
    private val location: TextView = itemView.findViewById(R.id.location)

    fun bind(state: State) {
        name.text = state.name
        location.text = state.location
    }
}