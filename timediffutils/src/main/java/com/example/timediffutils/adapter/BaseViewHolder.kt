package com.example.timediffutils.adapter

import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<D>(itemView: android.view.View) : RecyclerView.ViewHolder(itemView) {

    abstract fun onBind(item: D)
}
