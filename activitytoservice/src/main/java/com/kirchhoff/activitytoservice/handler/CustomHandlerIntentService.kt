package com.kirchhoff.activitytoservice.handler

import android.app.IntentService
import android.content.Intent
import android.os.Message
import android.os.Messenger
import com.kirchhoff.activitytoservice.ActivityToService

internal class CustomHandlerIntentService : IntentService(CustomHandlerIntentService::class.java.name) {

    companion object {
        const val STATUS_FINISHED = 1
    }

    override fun onHandleIntent(intent: Intent?) {
        /*
         * Pass the Handler from the activity to the intent service via intent.
         *  */
        val messenger = intent?.getParcelableExtra<Messenger>("handler")

        // Process background task here!
        try {
            Thread.sleep(ActivityToService.DELAY)
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }

        /*
         * Now background service is processed,
         * we can pass the status of the service back to the activity using the handler
         *  */
        val msg = Message()
        msg.obj = "Sending message to UI after completion of background task!"
        msg.what = STATUS_FINISHED
        messenger?.send(msg)
    }
}
