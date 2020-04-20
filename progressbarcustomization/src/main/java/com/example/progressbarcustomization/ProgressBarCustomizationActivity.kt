package com.example.progressbarcustomization

import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class ProgressBarCustomizationActivity : AppCompatActivity(R.layout.a_progress_bar_customization) {

    private lateinit var pbFirst: ProgressBar
    private lateinit var pbSecond: ProgressBar
    private lateinit var pbThird: ProgressBar

    private val handler = Handler()
    private val progressRunnable = ProgressRunnable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        pbFirst = findViewById(R.id.pbFirst)
        pbSecond = findViewById(R.id.pbSecond)
        pbThird = findViewById(R.id.pbThird)
        findViewById<Button>(R.id.bStartProgress).setOnClickListener { startProgress() }
    }

    override fun onStop() {
        super.onStop()
        handler.removeCallbacks(progressRunnable)
    }

    private fun startProgress() {
        handler.postDelayed(progressRunnable, DELAY_MILLIS)
    }

    private inner class ProgressRunnable : Runnable {

        private var progress: Int = 0

        override fun run() {

            pbFirst.progress = progress
            pbSecond.progress = progress
            pbThird.progress = progress
            progress += PROGRESS_VALUE
            pbFirst.secondaryProgress = progress
            pbThird.secondaryProgress = progress

            if (progress == FINISH_VALUE) {
                handler.removeCallbacks(this)
            } else {
                handler.postDelayed(this, DELAY_MILLIS)
            }
        }
    }

    companion object {
        private const val DELAY_MILLIS = 1000L
        private const val PROGRESS_VALUE = 10
        private const val FINISH_VALUE = 110
    }
}
