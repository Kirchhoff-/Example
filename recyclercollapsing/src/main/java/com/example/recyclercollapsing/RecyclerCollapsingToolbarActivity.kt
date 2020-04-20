package com.example.recyclercollapsing

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kirchhoff.recyclercollapsing.R

class RecyclerCollapsingToolbarActivity : AppCompatActivity(R.layout.a_recycler_collapsing_toolbard) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}
