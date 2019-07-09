package com.example.timediffutils

import android.support.v7.widget.RecyclerView


abstract class BaseViewHolder<D>(itemView: android.view.View?) : RecyclerView.ViewHolder(itemView) {

    abstract fun onBind(item: D)
}