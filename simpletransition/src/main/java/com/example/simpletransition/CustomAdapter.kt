package com.example.simpletransition

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import android.widget.TextView

class CustomAdapter internal constructor(private val context: Context, list: List<Array<String>>) : BaseAdapter() {

    private val arrayList: ArrayList<Array<String>> = ArrayList(list)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val row: View
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        row = convertView ?: inflater.inflate(R.layout.r_simple_transition, parent, false)
        return createRow(row, getItem(position))
    }

    override fun getCount() = arrayList.size

    override fun getItem(position: Int) = arrayList[position]

    override fun getItemId(position: Int) = position.toLong()

    private fun createRow(row: View, array: Array<String>): View {
        val layout = row.findViewById<LinearLayout>(R.id.layout)
        layout.setBackgroundColor(Color.parseColor(array[3]))
        val tvName = row.findViewById<TextView>(R.id.tvName)
        tvName.text = array[0]
        val tvEmail = row.findViewById<TextView>(R.id.tvEmail)
        tvEmail.text = array[1]
        return row
    }
}
