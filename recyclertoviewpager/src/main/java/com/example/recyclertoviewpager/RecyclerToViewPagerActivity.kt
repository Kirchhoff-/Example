package com.example.recyclertoviewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.recyclertoviewpager.fragment.GridFragment

class RecyclerToViewPagerActivity : AppCompatActivity(R.layout.a_recycler_to_viewpager) {

    companion object {
        var currentPosition: Int = 0
        private const val KEY_CURRENT_POSITION = "com.google.samples.gridtopager.key.currentPosition"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt(KEY_CURRENT_POSITION, 0)
            // Return here to prevent adding additional GridFragments when changing orientation.
            return
        }
        val fragmentManager = supportFragmentManager
        fragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainer, GridFragment(), GridFragment::class.java.simpleName)
                .commit()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(KEY_CURRENT_POSITION, currentPosition)
    }
}
