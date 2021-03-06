package com.kirchhoff.fastrecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

internal class FastRecyclerViewAdapter(private val data: List<State>) : RecyclerView.Adapter<StateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StateViewHolder {
        val personCell = LayoutInflater.from(parent.context).inflate(R.layout.r_fast_recycler, parent, false)
        return StateViewHolder(personCell)
    }

    override fun onBindViewHolder(holder: StateViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size
}
