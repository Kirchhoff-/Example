package com.example.recyclerdragdrop.adapter.holder

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.recyclerdragdrop.R
import com.example.recyclerdragdrop.data.User

internal class UserViewHolder(itemView: View, private val touchHelper: ItemTouchHelper) : RecyclerView.ViewHolder(itemView) {

    private val ivAvatar: ImageView = itemView.findViewById(R.id.ivAvatar)
    private val tvName: TextView = itemView.findViewById(R.id.tvName)
    private val ivReorder: ImageView = itemView.findViewById(R.id.ivReorder)

    @SuppressLint("ClickableViewAccessibility")
    fun bind(user: User) {
        tvName.text = user.name
        Glide.with(itemView)
                .load(user.imageUrl)
                .into(ivAvatar)
        ivReorder.setOnTouchListener { _, event ->
            if (event.actionMasked == MotionEvent.ACTION_DOWN) {
                touchHelper.startDrag(this)
            }
            false
        }
    }
}