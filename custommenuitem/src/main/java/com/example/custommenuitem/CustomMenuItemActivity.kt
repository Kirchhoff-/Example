package com.example.custommenuitem

import android.view.Menu
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.FrameLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CustomMenuItemActivity : AppCompatActivity(R.layout.a_custom_menu_item) {

    private lateinit var redCircle: FrameLayout
    private lateinit var tvViewAlertCount: TextView
    private var alertCount = 0

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.custom_menu, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val alertMenuItem = menu?.findItem(R.id.menu_item_alerts)
        val rootView = alertMenuItem?.actionView

        if (rootView != null) {
            redCircle = rootView.findViewById(R.id.view_alert_red_circle)
            tvViewAlertCount = rootView.findViewById(R.id.tvViewAlertCount)

            rootView.setOnClickListener {
                onOptionsItemSelected(alertMenuItem)
            }
        }

        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_item_alerts -> {
                alertCount = 0
                updateAlertIcon()
                true
            }
            R.id.menu_item_refresh -> {
                alertCount += 1
                updateAlertIcon()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateAlertIcon() {
        tvViewAlertCount.text = alertCount.toString()
        redCircle.visibility = if (alertCount > 0) VISIBLE else GONE
    }
}
