package com.kirchhoff.thingdiffutils

import androidx.recyclerview.widget.DiffUtil

class DiffUtilCallback(
        private val current: List<Thing>,
        private val next: List<Thing>
) : DiffUtil.Callback() {

    override fun getOldListSize() = current.size

    override fun getNewListSize() = next.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) = current[oldItemPosition] == next[newItemPosition]

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) = current[oldItemPosition] == next[newItemPosition]
}
