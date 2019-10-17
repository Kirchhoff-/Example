package com.example.recyclertoviewpager.adapter.listener

import android.view.View
import android.widget.ImageView

internal interface ViewHolderListener {

    fun onLoadCompleted(view: ImageView, adapterPosition: Int)

    fun onItemClicked(view: View, adapterPosition: Int)
}
