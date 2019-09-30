package com.kirchhoff.countdownlabel

import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import java.util.concurrent.TimeUnit

class CountdownLabelActivity : AppCompatActivity() {

    private lateinit var tvCount: TextView
    private lateinit var futureDate: Date

    private var countdownHandler: Handler? = null
    private val updateCountdown = object : Runnable {
        override fun run() {
            try {
                tvCount.text = formatDate(futureDate)
            } finally {
                countdownHandler?.postDelayed(this, 500L)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_countdown_label)
        tvCount = findViewById(R.id.tvCount)

        futureDate = Date()
        futureDate.time = futureDate.time + 100000000
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

        var timeRemaining = date.time - Date().time

        if (timeRemaining > 0) {

            val days = TimeUnit.MILLISECONDS.toDays(timeRemaining).toInt()
            timeRemaining -= TimeUnit.DAYS.toMillis(days.toLong())
            val hours = TimeUnit.MILLISECONDS.toHours(timeRemaining).toInt()
            timeRemaining -= TimeUnit.HOURS.toMillis(hours.toLong())
            val minutes = TimeUnit.MILLISECONDS.toMinutes(timeRemaining).toInt()
            timeRemaining -= TimeUnit.MINUTES.toMillis(minutes.toLong())
            val seconds = TimeUnit.MILLISECONDS.toSeconds(timeRemaining).toInt()

            if (days > 0) {
                countdownText.append(resources.getQuantityString(R.plurals.days, days, days))
                countdownText.append(" ")
            }
            if (days > 0 || hours > 0) {
                countdownText.append(resources.getQuantityString(R.plurals.hours, hours, hours))
                countdownText.append(" ")
            }
            if (days > 0 || hours > 0 || minutes > 0) {
                countdownText.append(resources.getQuantityString(R.plurals.minutes, minutes, minutes))
                countdownText.append(" ")
            }
            if (days > 0 || hours > 0 || minutes > 0 || seconds > 0) {
                countdownText.append(resources.getQuantityString(R.plurals.seconds, seconds, seconds))
                countdownText.append(" ")
            }
        }

        return countdownText.toString()
    }
}
