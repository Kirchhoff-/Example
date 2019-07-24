package com.kirchhoff.fastrecyclerview

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup


class FastRecyclerViewAdapter internal constructor(private val data: List<State>) : RecyclerView.Adapter<StateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StateViewHolder {
        val personCell = LayoutInflater.from(parent.context).inflate(R.layout.r_fast_recycler, parent, false)
        return StateViewHolder(personCell)
    }

    override fun onBindViewHolder(holder: StateViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount() = data.size
}