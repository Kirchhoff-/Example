package com.example.simpletransition

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

class SimpleTransitionDetailsActivity : AppCompatActivity() {

    private lateinit var tvDesc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_simple_transition_details)

        val array = intent.getStringArrayExtra("parameter")

        val layout = findViewById<RelativeLayout>(R.id.layout)
        layout.setBackgroundColor(Color.parseColor(array[COLOR_ARG_POSITION]))

        val tvHeading = findViewById<TextView>(R.id.tvHeading)
        tvHeading.text = array[TITLE_ARG_POSITION]

        val tvLanguage = findViewById<TextView>(R.id.tvLanguage)
        tvLanguage.text = array[LANGUAGE_ARG_POSITION]

        tvDesc = findViewById(R.id.tvDesc)
        tvDesc.text = array[DESCRIPTION_ARG_POSITION]
    }

    override fun onBackPressed() {
        tvDesc.visibility = View.GONE
        ActivityCompat.finishAfterTransition(this)
    }

    companion object {
        private const val TITLE_ARG_POSITION = 0
        private const val LANGUAGE_ARG_POSITION = 1
        private const val DESCRIPTION_ARG_POSITION = 2
        private const val COLOR_ARG_POSITION = 3
    }
}
