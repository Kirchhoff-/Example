package com.example.kirchhoff.example.ui.recycler.fast

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.kirchhoff.example.R


class FastRecyclerViewAdapter internal constructor(private val data: List<State>) : RecyclerView.Adapter<StateViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StateViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val personCell = inflater.inflate(R.layout.r_fast_recycler, parent, false)
        return StateViewHolder(personCell)
    }

    override fun onBindViewHolder(holder: StateViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}