package com.example.timediffutils.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup


abstract class BaseAdapter<D, VH : BaseViewHolder<D>> : RecyclerView.Adapter<VH>() {

    var listSource: List<D> = emptyList()

    override fun getItemCount(): Int = listSource.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val inflater = android.view.LayoutInflater.from(parent.context)
        val view = inflater.inflate(getItemViewId(), parent, false)
        return instantiateViewHolder(view)
    }

    abstract fun getItemViewId(): Int

    abstract fun instantiateViewHolder(view: android.view.View): VH

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.onBind(getItem(position))
    }

    fun getItem(position: Int) = listSource[position]
}

