package com.kirchhoff.activitytoservice.resultreceiver

import android.os.Bundle
import android.os.Handler
import android.os.ResultReceiver

internal class CustomResultReceiver(handler: Handler, private val appReceiver: AppReceiver?) : ResultReceiver(handler) {

    override fun onReceiveResult(resultCode: Int, resultData: Bundle) {
        appReceiver?.onReceiveResult(resultCode, resultData)
    }

    internal interface AppReceiver {
        fun onReceiveResult(resultCode: Int, resultData: Bundle)
    }
}