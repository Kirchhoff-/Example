package com.kirchhoff.gmailselectinganimation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.kirchhoff.gmailselectinganimation.R
import com.kirchhoff.gmailselectinganimation.data.EmailUiModel
import com.kirchhoff.gmailselectinganimation.view.SwivelCheckView

class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val avatarView: SwivelCheckView = itemView.findViewById(R.id.avatarView)
    private val tvPreview: TextView = itemView.findViewById(R.id.tvPreview)

    fun bind(email: EmailUiModel) {
        tvPreview.text = email.preview
        itemView.setOnClickListener { email.onClick() }
        downloadImage(email.contactImageUrl)
        avatarView.setChecked(email.isSelected(), shouldAnimate = false)
        setAvatarClickListener(email)
    }

    private fun downloadImage(url: String) {
        Glide.with(avatarView.context)
                .load(url)
                .apply(RequestOptions.circleCropTransform())
                .into(avatarView.imageView())
    }

    private fun setAvatarClickListener(email: EmailUiModel) {
        avatarView.setOnClickListener {
            val targetState = !avatarView.isChecked
            avatarView.setChecked(targetState, shouldAnimate = true)
            email.setSelected(targetState)
        }
    }

    companion object {
        fun inflate(parent: ViewGroup): EmailViewHolder = LayoutInflater.from(parent.context).let {
            val view = it.inflate(R.layout.view_email, parent, false)
            return EmailViewHolder(view)
        }
    }
}
