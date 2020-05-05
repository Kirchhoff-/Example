package com.kirchhoff.viewpagerwithoutfragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager

class VPWithoutFragmentActivity : AppCompatActivity(R.layout.a_vp_without_fragment) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewPager = findViewById<ViewPager>(R.id.viewpager)
        viewPager.adapter = CustomPagerAdapter(this)
    }
}
