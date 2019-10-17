package com.kirchhoff.activitytoservice.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

internal class SMSActivity : AppCompatActivity() {

    private var broadcastReceiver: BroadcastReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerReceiver()
    }

    override fun onStop() {
        super.onStop()
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver)
        }
    }

    private fun registerReceiver() {
        broadcastReceiver = object : SMSReceiver() {
            override fun onReceive(context: Context, intent: Intent) {
                val senderAndBody = intent.getStringExtra(SMSReceiver.SMS_INTENT_DATA)
                Toast.makeText(this@SMSActivity, senderAndBody, Toast.LENGTH_LONG).show()
            }
        }
        registerReceiver(broadcastReceiver, IntentFilter(SMSReceiver.SMS_INTENT_ACTION))
    }
}
