package com.example.custommenuitem

import android.view.Menu
import android.view.MenuItem
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.FrameLayout
import android.widget.TextView
import com.example.core.ui.BaseActivity

class CustomMenuItemActivity : BaseActivity() {

    private lateinit var redCircle: FrameLayout
    private lateinit var tvViewAlertCount: TextView
    private var alertCount = 0

    override fun getLayoutId() = R.layout.a_custom_menu_item

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.custom_menu, menu)
        return true
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        val alertMenuItem = menu?.findItem(R.id.menu_item_alerts)
        val rootView = alertMenuItem?.actionView as FrameLayout

        redCircle = rootView.findViewById(R.id.view_alert_red_circle) as FrameLayout
        tvViewAlertCount = rootView.findViewById(R.id.tvViewAlertCount) as TextView

        rootView.setOnClickListener {
            onOptionsItemSelected(alertMenuItem)
        }

        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.menu_item_alerts -> {
                alertCount = 0
                updateAlertIcon()
                true
            }
            R.id.menu_item_refresh -> {
                alertCount = (alertCount + 1) % 11
                updateAlertIcon()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateAlertIcon() {
        if (alertCount in 1..9) {
            tvViewAlertCount.text = alertCount.toString()
        } else {
            tvViewAlertCount.text = ""
        }

        redCircle.visibility = if (alertCount > 0) VISIBLE else GONE
    }
}