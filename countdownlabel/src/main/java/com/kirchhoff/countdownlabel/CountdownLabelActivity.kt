package com.kirchhoff.countdownlabel

import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.annotation.PluralsRes
import androidx.appcompat.app.AppCompatActivity
import java.util.Date

class CountdownLabelActivity : AppCompatActivity(R.layout.a_countdown_label) {

    private lateinit var tvCount: TextView
    private lateinit var futureDate: Date

    private var countdownHandler: Handler? = null
    private val updateCountdown = object : Runnable {
        override fun run() {
            try {
                tvCount.text = formatDate(futureDate)
            } finally {
                countdownHandler?.postDelayed(this, DELAY)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tvCount = findViewById(R.id.tvCount)

        futureDate = Date()
        futureDate.time = futureDate.time + FUTURE_TIME
    }

    override fun onStart() {
        super.onStart()
        startCountdown()
    }

    override fun onStop() {
        super.onStop()
        stopCountdown()
    }

    private fun startCountdown() {
        stopCountdown()

        countdownHandler = Handler()
        updateCountdown.run()
    }

    private fun stopCountdown() {
        if (countdownHandler != null) {
            countdownHandler?.removeCallbacks(updateCountdown)
            countdownHandler = null
        }
    }

    private fun formatDate(date: Date): String {
        val countdownText = StringBuilder()
        val timeRemaining = date.time - Date().time

        if (timeRemaining > 0) {
            countdownText.append(getTimeIfExist(timeRemaining.days(), R.plurals.days))
            countdownText.append(getTimeIfExist(timeRemaining.hours(), R.plurals.hours))
            countdownText.append(getTimeIfExist(timeRemaining.minutes(), R.plurals.minutes))
            countdownText.append(getTimeIfExist(timeRemaining.seconds(), R.plurals.seconds))
        }

        return countdownText.toString()
    }

    private fun getTimeIfExist(time: Int, @PluralsRes plurals: Int): String {
        if (time > 0) {
            return resources.getQuantityString(plurals, time, time)
        }

        return ""
    }

    companion object {
        private const val DELAY = 500L
        private const val FUTURE_TIME = 100000000
    }
}
