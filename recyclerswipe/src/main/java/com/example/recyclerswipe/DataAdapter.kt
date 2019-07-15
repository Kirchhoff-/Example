package com.example.recyclerswipe

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.kirchhoff.recyclerswipe.R
import java.util.*

class DataAdapter constructor(private val countries: ArrayList<String>) : RecyclerView.Adapter<DataAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context)
                .inflate(R.layout.r_recycler_custom, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(countries[position])
    }

    override fun getItemCount() = countries.size

    fun addItem(country: String) {
        countries.add(country)
        notifyItemInserted(countries.size)
    }

    fun removeItem(position: Int) {
        countries.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, countries.size)
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var country: TextView = itemView.findViewById(R.id.country)

        fun bind(text: String) {
            country.text = text
        }
    }
}
