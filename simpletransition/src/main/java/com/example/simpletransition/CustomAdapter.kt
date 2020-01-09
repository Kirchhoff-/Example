package com.example.simpletransition

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat

internal class CustomAdapter(private val context: Context, list: List<TransitionItem>) : BaseAdapter() {

    private val arrayList = ArrayList(list)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val row: View
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        row = convertView ?: inflater.inflate(R.layout.r_simple_transition, parent, false)
        return createRow(row, getItem(position))
    }

    override fun getCount() = arrayList.size

    override fun getItem(position: Int): TransitionItem = arrayList[position]

    override fun getItemId(position: Int) = position.toLong()

    private fun createRow(row: View, item: TransitionItem): View {
        val layout = row.findViewById<LinearLayout>(R.id.layout)
        layout.setBackgroundColor(ContextCompat.getColor(context, item.color))
        val tvName = row.findViewById<TextView>(R.id.tvName)
        tvName.text = item.title
        val tvLanguage = row.findViewById<TextView>(R.id.tvLanguage)
        tvLanguage.text = item.language
        return row
    }
}
