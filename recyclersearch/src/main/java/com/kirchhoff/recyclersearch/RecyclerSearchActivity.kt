package com.kirchhoff.recyclersearch

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.support.v7.widget.Toolbar
import android.view.Menu

import com.kirchhoff.recyclersearch.adapter.AndroidVersionDataAdapter
import com.kirchhoff.recyclersearch.data.AndroidVersionRepository

class RecyclerSearchActivity : AppCompatActivity() {

    private lateinit var adapter: AndroidVersionDataAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_recycler_search)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = AndroidVersionDataAdapter(AndroidVersionRepository().getAndroidVersionsList())
        recyclerView.adapter = adapter
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.recycler_search, menu)

        val search = menu.findItem(R.id.search)
        val searchView = search.actionView as SearchView
        search(searchView)
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
