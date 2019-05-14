package com.example.kirchhoff.example.ui.recycler.toolbar

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.kirchhoff.example.R

class RecyclerCollapsingToolbarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_recycler_collapsing_toolbard)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}
