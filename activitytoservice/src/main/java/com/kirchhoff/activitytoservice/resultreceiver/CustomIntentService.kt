package com.kirchhoff.activitytoservice.resultreceiver

import android.app.IntentService
import android.content.Intent
import android.os.Bundle
import android.os.ResultReceiver

internal class CustomIntentService : IntentService(CustomIntentService::class.java.name) {

    companion object {
        const val STATUS_FINISHED = 1
    }

    override fun onHandleIntent(intent: Intent) {

        /*
         We pass the ResultReceiver from the activity to the intent service via intent.
         *  */
        val receiver = intent.getParcelableExtra<ResultReceiver>("receiver")

        // Process background task here!
        try {
            Thread.sleep(2000)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        /*
         * Now background service is processed,
         * we can pass the status of the service back to the activity using the resultReceiver
         *  */
        val b = Bundle()
        receiver.send(STATUS_FINISHED, b)
    }
}
