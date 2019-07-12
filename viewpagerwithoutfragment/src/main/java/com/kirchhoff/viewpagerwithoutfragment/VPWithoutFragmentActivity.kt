package com.kirchhoff.viewpagerwithoutfragment

import android.os.Bundle
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity

class VPWithoutFragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_vp_without_fragment)

        val viewPager = findViewById<ViewPager>(R.id.viewpager)
        viewPager.adapter = CustomPagerAdapter(this)
    }
}
