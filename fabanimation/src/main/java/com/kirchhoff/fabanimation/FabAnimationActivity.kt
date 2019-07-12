package com.kirchhoff.fabanimation

import android.os.Bundle
import android.support.annotation.AnimRes
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils

class FabAnimationActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var fab: FloatingActionButton
    private lateinit var fab1: FloatingActionButton
    private lateinit var fab2: FloatingActionButton

    private lateinit var fabOpen: Animation
    private lateinit var fabClose: Animation
    private lateinit var rotateForward: Animation
    private lateinit var rotateBackward: Animation

    private var isFabOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_fab_animation)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        fab = findViewById(R.id.fab)
        fab1 = findViewById(R.id.fab1)
        fab2 = findViewById(R.id.fab2)
        fabOpen = loadAnimation(R.anim.fab_open)
        fabClose = loadAnimation(R.anim.fab_close)
        rotateForward = loadAnimation(R.anim.rotate_forward)
        rotateBackward = loadAnimation(R.anim.rotate_backward)
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
            fab.startAnimation(rotateBackward)
            fab1.startAnimation(fabClose)
            fab2.startAnimation(fabClose)
            fab1.isClickable = false
            fab2.isClickable = false
            isFabOpen = false
        } else {
            fab.startAnimation(rotateForward)
            fab1.startAnimation(fabOpen)
            fab2.startAnimation(fabOpen)
            fab1.isClickable = true
            fab2.isClickable = true
            isFabOpen = true
        }
    }

    private fun loadAnimation(@AnimRes animId: Int) = AnimationUtils.loadAnimation(this, animId)
}
