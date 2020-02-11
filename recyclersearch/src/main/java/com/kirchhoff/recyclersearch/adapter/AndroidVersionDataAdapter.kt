package com.kirchhoff.recyclersearch.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.kirchhoff.recyclersearch.R
import com.kirchhoff.recyclersearch.data.AndroidVersion
import java.util.Locale
import kotlin.collections.ArrayList

class AndroidVersionDataAdapter(initialList: List<AndroidVersion>) :
        RecyclerView.Adapter<AndroidVersionViewHolder>(), Filterable {

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

    override fun getFilter() = FilterImpl()

    inner class FilterImpl : Filter() {

        override fun performFiltering(charSequence: CharSequence?): FilterResults {
            val charString = charSequence.toString()

            filteredList = if (charString.isEmpty()) {
                list
            } else {
                list.filter { containsAny(charString, it.api, it.name, it.version) } as ArrayList<AndroidVersion>
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

        private fun containsAny(searchedString: String, vararg values: String): Boolean {
            for (value in values) {
                if (value.toLowerCase(Locale.getDefault()).contains(searchedString)) {
                    return true
                }
            }

            return false
        }
    }
}
