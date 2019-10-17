package com.example.progressbarcustomization

import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.ProgressBar
import com.example.core.ui.BaseActivity

class ProgressBarCustomizationActivity : BaseActivity() {

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

    override fun getLayoutId() = R.layout.a_progress_bar_customization

    private fun startProgress() {
        handler.postDelayed(progressRunnable, 1000)
    }

    private inner class ProgressRunnable : Runnable {

        private var progress: Int = 0

        override fun run() {

            pbFirst.progress = progress
            pbSecond.progress = progress
            pbThird.progress = progress
            progress += 10
            pbFirst.secondaryProgress = progress
            pbThird.secondaryProgress = progress

            if (progress == 110) {
                handler.removeCallbacks(this)
            } else {
                handler.postDelayed(this, 1000)
            }
        }
    }
}
