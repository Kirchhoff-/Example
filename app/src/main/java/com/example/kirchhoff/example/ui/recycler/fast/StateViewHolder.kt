package com.example.kirchhoff.example.ui.recycler.fast

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

import com.example.kirchhoff.example.R

class StateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var name: TextView = itemView.findViewById(R.id.name)
    var location: TextView = itemView.findViewById(R.id.location)

    fun bind(state: State) {
        name.text = state.name
        location.text = state.location
    }
}