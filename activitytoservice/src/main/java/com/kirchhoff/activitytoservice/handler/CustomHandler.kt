package com.kirchhoff.activitytoservice.handler

import android.os.Handler
import android.os.Message

internal class CustomHandler internal constructor(private val appReceiver: AppReceiver) : Handler() {

    override fun handleMessage(msg: Message) {
        super.handleMessage(msg)
        appReceiver.onReceiveResult(msg)
    }

    internal interface AppReceiver {
        fun onReceiveResult(message: Message)
    }
}