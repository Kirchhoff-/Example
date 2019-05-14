package com.example.kirchhoff.example.ui.recycler.testable.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

internal class MyAdapter : RecyclerView.Adapter<SimpleListItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimpleListItemViewHolder {
        val itemView = TextView(parent.context)
        itemView.tag = Presenter()
        return SimpleListItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SimpleListItemViewHolder, position: Int) {
        (holder.itemView.tag as Presenter).presenterListItem(holder, position)
    }

    override fun getItemCount(): Int {
        return 100
    }
}
