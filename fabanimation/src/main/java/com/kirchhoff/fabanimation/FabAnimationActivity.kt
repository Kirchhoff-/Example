package com.kirchhoff.fabanimation

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FabAnimationActivity : AppCompatActivity(R.layout.a_fab_animation), View.OnClickListener {

    private lateinit var fab: FloatingActionButton
    private lateinit var fab1: FloatingActionButton
    private lateinit var fab2: FloatingActionButton

    private lateinit var animationHelper: AnimationHelper
    private var isFabOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(findViewById(R.id.toolbar))
        animationHelper = AnimationHelper(this)
        fab = findViewById(R.id.fab)
        fab1 = findViewById(R.id.fab1)
        fab2 = findViewById(R.id.fab2)
        fab.setOnClickListener(this)
        fab1.setOnClickListener(this)
        fab2.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.fab) {
            animateFAB()
        }
    }

    private fun animateFAB() {
        if (isFabOpen) {
            fab.startAnimation(animationHelper.rotateBackwardAnimation())
            fab1.startAnimation(animationHelper.closeAnimation())
            fab2.startAnimation(animationHelper.closeAnimation())
        } else {
            fab.startAnimation(animationHelper.rotateForwardAnimation())
            fab1.startAnimation(animationHelper.openAnimation())
            fab2.startAnimation(animationHelper.openAnimation())
        }

        isFabOpen = !isFabOpen
        updateButton(isFabOpen)
    }

    private fun updateButton(isClickable: Boolean) {
        fab1.isClickable = isClickable
        fab2.isClickable = isClickable
    }
}
