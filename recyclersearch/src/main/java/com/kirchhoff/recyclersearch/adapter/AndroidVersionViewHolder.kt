package com.kirchhoff.recyclersearch.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kirchhoff.recyclersearch.R
import com.kirchhoff.recyclersearch.data.AndroidVersion

class AndroidVersionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val name: TextView = itemView.findViewById(R.id.name)
    private val version: TextView = itemView.findViewById(R.id.version)
    private val apiLevel: TextView = itemView.findViewById(R.id.apiLevel)

    fun bind(androidVersion: AndroidVersion) {
        name.text = androidVersion.name
        version.text = androidVersion.version
        apiLevel.text = androidVersion.api
    }
}
