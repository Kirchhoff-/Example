package com.kirchhoff.fastrecyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class FastRecyclerViewActivity : AppCompatActivity(R.layout.a_fast_recycler_view) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = FastRecyclerViewAdapter(mockData())
    }

    private fun mockData(): List<State> {
        val states = resources.getStringArray(R.array.States)
        val locations = resources.getStringArray(R.array.Locations)

        val resultArray: MutableList<State> = ArrayList()
        for (index in states.indices) {
            resultArray.add(State(states[index], locations[index]))
        }
        return resultArray
    }
}
