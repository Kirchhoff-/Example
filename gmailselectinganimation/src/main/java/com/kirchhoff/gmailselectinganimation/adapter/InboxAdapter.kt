package com.kirchhoff.gmailselectinganimation.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.kirchhoff.gmailselectinganimation.data.EmailUiModel

class InboxAdapter : ListAdapter<EmailUiModel, EmailViewHolder>(EmailDiffer) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = EmailViewHolder.inflate(parent)

    override fun onBindViewHolder(viewHolder: EmailViewHolder, position: Int) = viewHolder.bind(getItem(position))

    object EmailDiffer : DiffUtil.ItemCallback<EmailUiModel>() {
        override fun areItemsTheSame(oldItem: EmailUiModel, newItem: EmailUiModel) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: EmailUiModel, newItem: EmailUiModel) = oldItem == newItem
    }
}