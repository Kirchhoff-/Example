package com.example.simpletransition

import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class SimpleTransitionDetailsActivity : AppCompatActivity() {

    private lateinit var tvDesc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_simple_transition_details)

        val transitionItem = intent.getParcelableExtra<TransitionItem>("parameter")

        val layout = findViewById<RelativeLayout>(R.id.layout)
        layout.setBackgroundColor(ContextCompat.getColor(this, transitionItem.color))

        val tvHeading = findViewById<TextView>(R.id.tvHeading)
        tvHeading.text = transitionItem.title

        val tvLanguage = findViewById<TextView>(R.id.tvLanguage)
        tvLanguage.text = transitionItem.language

        tvDesc = findViewById(R.id.tvDesc)
        tvDesc.text = transitionItem.description
    }

    override fun onBackPressed() {
        tvDesc.visibility = View.GONE
        ActivityCompat.finishAfterTransition(this)
    }
}
