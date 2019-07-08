package com.example.recyclercollapsing

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kirchhoff.recyclercollapsing.R

class RecyclerCollapsingToolbarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_recycler_collapsing_toolbard)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}
