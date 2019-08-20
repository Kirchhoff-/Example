package com.example.recyclercollapsing

import android.os.Bundle
import com.example.core.ui.BaseActivity
import com.kirchhoff.recyclercollapsing.R

class RecyclerCollapsingToolbarActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(findViewById(R.id.toolbar))
    }

    override fun getLayoutId() = R.layout.a_recycler_collapsing_toolbard
}
