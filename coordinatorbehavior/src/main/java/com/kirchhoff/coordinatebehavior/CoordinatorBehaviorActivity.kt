package com.kirchhoff.coordinatebehavior

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View

class CoordinatorBehaviorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_coordinate_behavior)

        findViewById<View>(R.id.bApply).setOnClickListener { view -> showSnackbar(view, "Button with custom behavior") }
        findViewById<View>(R.id.fab).setOnClickListener { view -> showSnackbar(view, "FAB with custom behavior") }
    }

    private fun showSnackbar(view: View, text: String) {
        Snackbar.make(view, text, Snackbar.LENGTH_LONG).setAction("Action", null).show()
    }
}