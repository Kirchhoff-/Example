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
        layout.setBackgroundColor(Color.parseColor(array[3]))

        val tvHeading = findViewById<TextView>(R.id.tvHeading)
        tvHeading.text = array[0]

        val tvLanguage = findViewById<TextView>(R.id.tvLanguage)
        tvLanguage.text = array[1]

        tvDesc = findViewById(R.id.tvDesc)
        tvDesc.text = array[2]
    }

    override fun onBackPressed() {
        tvDesc.visibility = View.GONE
        ActivityCompat.finishAfterTransition(this)
    }
}
