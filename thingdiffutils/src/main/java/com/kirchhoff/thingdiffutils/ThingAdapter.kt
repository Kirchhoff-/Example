package com.kirchhoff.thingdiffutils

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import java.util.*

class ThingAdapter : RecyclerView.Adapter<ThingViewHolder>() {

    private var things: List<Thing> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ThingViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.r_thing, parent, false))

    override fun onBindViewHolder(holder: ThingViewHolder, position: Int) {
        holder.bind(things[position])
    }

    override fun getItemCount() = things.size

    fun setThings(things: List<Thing>) {
        this.things = things
    }
}
