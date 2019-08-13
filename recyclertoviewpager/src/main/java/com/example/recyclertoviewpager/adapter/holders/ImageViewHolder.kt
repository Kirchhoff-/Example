package com.example.recyclertoviewpager.adapter.holders

import android.graphics.drawable.Drawable
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.recyclertoviewpager.R
import com.example.recyclertoviewpager.adapter.listener.ViewHolderListener
import com.example.recyclertoviewpager.data.IMAGE_DRAWABLES


internal class ImageViewHolder(itemView: View,
                               private val requestManager: RequestManager,
                               private val viewHolderListener: ViewHolderListener) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

    private val image: ImageView = itemView.findViewById(R.id.card_image)

    init {
        itemView.findViewById<View>(R.id.card_view).setOnClickListener(this)
    }

    fun onBind() {
        val adapterPosition = adapterPosition
        setImage(adapterPosition)
        image.transitionName = IMAGE_DRAWABLES[adapterPosition].toString()
    }

    private fun setImage(adapterPosition: Int) {
        requestManager
                .load(IMAGE_DRAWABLES[adapterPosition])
                .listener(object : RequestListener<Drawable> {

                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?,
                                                 dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        viewHolderListener.onLoadCompleted(image, adapterPosition)
                        return false
                    }

                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?,
                                              isFirstResource: Boolean): Boolean {
                        viewHolderListener.onLoadCompleted(image, adapterPosition)
                        return false
                    }

                })
                .into(image)
    }

    override fun onClick(view: View) {
        viewHolderListener.onItemClicked(view, adapterPosition)
    }
}