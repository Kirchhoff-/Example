package com.example.recyclerswipe

import android.graphics.*
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.kirchhoff.recyclerswipe.R
import java.util.*


class RecyclerCustomSwipeActivity : AppCompatActivity() {

    private val countries = ArrayList<String>()
    private lateinit var adapter: DataAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var view: View
    private lateinit var country: EditText
    private lateinit var alertDialog: AlertDialog.Builder
    private var editPosition: Int = 0
    private var add = false
    private val p = Paint()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_recycler_custom_swipe)

        countries.add("Australia")
        countries.add("India")
        countries.add("United States of America")
        countries.add("Germany")
        countries.add("Russia")
        initViews()
        initDialog()
    }

    private fun initViews() {

        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener {
            removeView()
            add = true
            alertDialog.setTitle("Add Country")
            country.setText("")
            alertDialog.show()
        }
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = DataAdapter(countries)
        recyclerView.adapter = adapter
        initSwipe()
    }

    private fun initSwipe() {
        val simpleCallback = object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition

                if (direction == ItemTouchHelper.LEFT) {
                    adapter.removeItem(position)
                } else {
                    removeView()
                    editPosition = position
                    alertDialog.setTitle("Edit Country")
                    country.setText(countries[position])
                    alertDialog.show()
                }
            }

            override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {

                var icon: Bitmap
                if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {

                    val itemView = viewHolder.itemView
                    val height = itemView.bottom.toFloat() - itemView.top.toFloat()
                    val width = height / 3

                    if (dX > 0) {
                        p.color = Color.parseColor("#388E3C")
                        val background = RectF(itemView.left.toFloat(), itemView.top.toFloat(), dX, itemView.bottom.toFloat())
                        c.drawRect(background, p)
                        icon = BitmapFactory.decodeResource(resources, R.drawable.ic_edit)
                        val icon_dest = RectF(itemView.left.toFloat() + width,
                                itemView.top.toFloat() + width, itemView.left.toFloat() + 2 * width, itemView.bottom.toFloat() - width)
                        c.drawBitmap(icon, null, icon_dest, p)
                    } else {
                        p.color = Color.parseColor("#D32F2F")
                        val background = RectF(itemView.right.toFloat() + dX,
                                itemView.top.toFloat(), itemView.right.toFloat(), itemView.bottom.toFloat())
                        c.drawRect(background, p)
                        icon = BitmapFactory.decodeResource(resources, R.drawable.ic_delete)
                        val icon_dest = RectF(itemView.right.toFloat() - 2 * width, itemView.top.toFloat() + width, itemView.right.toFloat() - width, itemView.bottom.toFloat() - width)
                        c.drawBitmap(icon, null, icon_dest, p)
                    }
                }
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            }
        }
        val itemTouchHelper = ItemTouchHelper(simpleCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)
    }

    private fun removeView() {
        if (view.parent != null) {
            (view.parent as ViewGroup).removeView(view)
        }
    }

    private fun initDialog() {
        alertDialog = AlertDialog.Builder(this)
        view = layoutInflater.inflate(R.layout.d_country, null)
        alertDialog.setView(view)
        alertDialog.setPositiveButton("Save") { dialog, which ->
            if (add) {
                add = false
                adapter.addItem(country.text.toString())
                dialog.dismiss()
            } else {
                countries[editPosition] = country.text.toString()
                adapter.notifyDataSetChanged()
                dialog.dismiss()
            }
        }
        country = view.findViewById(R.id.country)
    }
}
