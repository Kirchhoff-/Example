package com.example.recyclerdragdrop

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import com.example.recyclerdragdrop.adapter.UserListAdapter
import com.example.recyclerdragdrop.data.UsersRepository
import com.example.recyclerdragdrop.helper.SwipeAndDragHelper


class RecyclerViewDragDropActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_recycler_view_drag_drop)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = UserListAdapter(UsersRepository.provideUsersList())
        val swipeAndDragHelper = SwipeAndDragHelper(adapter)
        val touchHelper = ItemTouchHelper(swipeAndDragHelper)
        adapter.setOnTouchHelper(touchHelper)
        recyclerView.adapter = adapter
        touchHelper.attachToRecyclerView(recyclerView)
    }
}