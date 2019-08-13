package com.example.recyclertoviewpager.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import com.example.recyclertoviewpager.R
import com.example.recyclertoviewpager.adapter.holders.ImageViewHolder
import com.example.recyclertoviewpager.adapter.listener.ViewHolderListener
import com.example.recyclertoviewpager.data.IMAGE_DRAWABLES


internal class GridAdapter(private val requestManager: RequestManager,
                           private val viewHolderListener: ViewHolderListener) : RecyclerView.Adapter<ImageViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.image_card, parent, false)
        return ImageViewHolder(view, requestManager, viewHolderListener)
    }

    override fun onBindViewHolder(viewHolder: ImageViewHolder, position: Int) = viewHolder.onBind()

    override fun getItemCount() = IMAGE_DRAWABLES.size
}