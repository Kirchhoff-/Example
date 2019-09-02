package com.kirchhoff.activitytoservice

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import com.kirchhoff.activitytoservice.broadcast.SMSActivity
import com.kirchhoff.activitytoservice.handler.HandlerActivity
import com.kirchhoff.activitytoservice.resultreceiver.ResultReceiverActivity

class ActivityToService : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_activity_to_service)

        findViewById<Button>(R.id.smsReceiver).setOnClickListener(this)
        findViewById<Button>(R.id.resultReceiver).setOnClickListener(this)
        findViewById<Button>(R.id.handler).setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val targetActivity = when (v.id) {
            R.id.smsReceiver -> SMSActivity::class.java
            R.id.resultReceiver -> ResultReceiverActivity::class.java
            R.id.handler -> HandlerActivity::class.java
            else -> SMSActivity::class.java
        }

        val intent = Intent(this, targetActivity)
        startActivity(intent)
    }
}