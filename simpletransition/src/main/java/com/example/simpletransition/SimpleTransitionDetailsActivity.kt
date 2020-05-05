package com.example.simpletransition

import android.os.Bundle
import android.view.View
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class SimpleTransitionDetailsActivity : AppCompatActivity(R.layout.a_simple_transition_details) {

    private lateinit var tvDesc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val transitionItem = intent.getParcelableExtra<TransitionItem>("parameter")

        val layout = findViewById<RelativeLayout>(R.id.layout)
        val tvHeading = findViewById<TextView>(R.id.tvHeading)
        val tvLanguage = findViewById<TextView>(R.id.tvLanguage)
        tvDesc = findViewById(R.id.tvDesc)

        transitionItem?.let {
            layout.setBackgroundColor(ContextCompat.getColor(this, transitionItem.color))
            tvHeading.text = transitionItem.title
            tvLanguage.text = transitionItem.language
            tvDesc.text = transitionItem.description
        }
    }

    override fun onBackPressed() {
        tvDesc.visibility = View.GONE
        ActivityCompat.finishAfterTransition(this)
    }
}
