package com.example.recyclerdragdrop.adapter

import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerdragdrop.R
import com.example.recyclerdragdrop.adapter.holder.HeaderViewHolder
import com.example.recyclerdragdrop.adapter.holder.UserViewHolder
import com.example.recyclerdragdrop.data.User
import com.example.recyclerdragdrop.helper.SwipeAndDragHelper

internal class UserListAdapter(private val usersList: MutableList<User>) :
        RecyclerView.Adapter< RecyclerView.ViewHolder>(), SwipeAndDragHelper.ActionCompletionContract {

    private lateinit var touchHelper: ItemTouchHelper

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View
        return when (viewType) {
            HEADER_TYPE -> {
                view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_user_header, parent, false)
                HeaderViewHolder(view)
            }
            else -> {
                view = LayoutInflater.from(parent.context)
                        .inflate(R.layout.item_user, parent, false)
                UserViewHolder(view, touchHelper)
            }
        }
    }

    @SuppressWarnings("UnsafeCast")
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewType = getItemViewType(position)
        if (itemViewType == USER_TYPE) {
            val userViewHolder = holder as UserViewHolder
            userViewHolder.bind(usersList[position])
        } else {
            val headerViewHolder = holder as HeaderViewHolder
            headerViewHolder.bind(usersList[position].type)
        }
    }

    override fun getItemCount() = usersList.size

    override fun getItemViewType(position: Int): Int {
        return if (TextUtils.isEmpty(usersList[position].name)) {
            HEADER_TYPE
        } else {
            USER_TYPE
        }
    }

    override fun onViewMoved(oldPosition: Int, newPosition: Int) {
        val targetUser = usersList[oldPosition]
        val user = User(targetUser)
        usersList.removeAt(oldPosition)
        usersList.add(newPosition, user)
        notifyItemMoved(oldPosition, newPosition)
    }

    override fun onViewSwiped(position: Int) {
        usersList.removeAt(position)
        notifyItemRemoved(position)
    }

    fun setOnTouchHelper(touchHelper: ItemTouchHelper) {
        this.touchHelper = touchHelper
    }

    companion object {
        private const val USER_TYPE = 1
        private const val HEADER_TYPE = 2
    }
}
