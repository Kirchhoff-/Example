package com.kirchhoff.recyclersearch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.kirchhoff.recyclersearch.R
import com.kirchhoff.recyclersearch.data.AndroidVersion
import java.util.*

class AndroidVersionDataAdapter(initialList: List<AndroidVersion>) : RecyclerView.Adapter<AndroidVersionViewHolder>(), Filterable {

    private val list: ArrayList<AndroidVersion> = ArrayList(initialList)
    private var filteredList: ArrayList<AndroidVersion> = ArrayList(initialList)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AndroidVersionViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.r_card, parent, false)
        return AndroidVersionViewHolder(view)
    }

    override fun onBindViewHolder(holder: AndroidVersionViewHolder, position: Int) {
        holder.bind(filteredList[position])
    }

    override fun getItemCount() = filteredList.size

    override fun getFilter(): Filter {

        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {

                val charString = charSequence.toString()

                filteredList = if (charString.isEmpty()) {
                    list
                } else {
                    val filList = ArrayList<AndroidVersion>()

                    for (androidVersion in list) {
                        if (androidVersion.api.toLowerCase(Locale.getDefault()).contains(charString) ||
                                androidVersion.name.toLowerCase(Locale.getDefault()).contains(charString) ||
                                androidVersion.version.toLowerCase(Locale.getDefault()).contains(charString)) {
                            filList.add(androidVersion)
                        }
                    }

                    filList
                }

                val filterResults = FilterResults()
                filterResults.values = filteredList
                return filterResults
            }

            @Suppress("UNCHECKED_CAST")
            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
                filteredList = filterResults.values as ArrayList<AndroidVersion>
                notifyDataSetChanged()
            }
        }
    }
}
