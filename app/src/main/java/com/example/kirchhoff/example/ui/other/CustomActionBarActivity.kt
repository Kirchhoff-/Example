package com.example.kirchhoff.example.ui.other


import android.os.Bundle
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast

import com.example.kirchhoff.example.R


class CustomActionBarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_empty)

        val actionBar = supportActionBar
        if (actionBar != null) {
            actionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
            actionBar.setDisplayShowCustomEnabled(true)
            actionBar.setCustomView(R.layout.v_custom_action_bar)

            val view = actionBar.customView

            view.findViewById<View>(R.id.ibBack).setOnClickListener { showToast("Back Button is clicked") }
            view.findViewById<View>(R.id.ibForward).setOnClickListener { showToast("Forward Button is clicked") }
        }
    }

    private fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show()
    }
}
