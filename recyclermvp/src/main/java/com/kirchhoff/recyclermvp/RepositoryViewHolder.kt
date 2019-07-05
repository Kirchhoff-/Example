package com.kirchhoff.recyclermvp

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class RepositoryViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView), RepositoryRowView {

    private val titleTextView: TextView = itemView.findViewById(R.id.repoTitleText)
    private val startCountTextView: TextView = itemView.findViewById(R.id.repoStartCountText)

    override fun setTitle(title: String) {
        titleTextView.text = title
    }

    override fun setStarCount(starCount: Int) {
        startCountTextView.text = String.format("%s start", starCount)
    }
}
