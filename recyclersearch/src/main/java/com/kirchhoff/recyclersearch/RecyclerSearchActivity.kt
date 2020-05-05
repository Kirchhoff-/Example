package com.kirchhoff.recyclersearch

import android.os.Bundle
import android.view.Menu
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kirchhoff.recyclersearch.adapter.AndroidVersionDataAdapter
import com.kirchhoff.recyclersearch.data.AndroidVersionRepository

class RecyclerSearchActivity : AppCompatActivity(R.layout.a_recycler_search) {

    private lateinit var adapter: AndroidVersionDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = AndroidVersionDataAdapter(AndroidVersionRepository(this).getAndroidVersionsList())
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.recycler_search, menu)

        val search = menu.findItem(R.id.search)
        val searchView = search.actionView
        if (searchView is SearchView) {
            search(searchView)
        }
        return true
    }

    private fun search(searchView: SearchView) {
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                adapter.filter.filter(newText)
                return true
            }
        })
    }
}
