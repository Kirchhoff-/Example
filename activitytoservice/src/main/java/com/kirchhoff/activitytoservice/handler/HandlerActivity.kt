package com.kirchhoff.activitytoservice.handler

import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.os.Messenger
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

internal class HandlerActivity : AppCompatActivity(), CustomHandler.AppReceiver {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerService()
    }

    private fun registerService() {
        val intent = Intent(applicationContext, CustomHandlerIntentService::class.java)
        /*
         * Pass the handler via the intent to the intent service
         * */
        val handler = CustomHandler(this)
        intent.putExtra("handler", Messenger(handler))
        startService(intent)
    }

    override fun onReceiveResult(message: Message) {
        /*
         * Handle the results from the intent service here!
         * */
        if (message.what == CustomHandlerIntentService.STATUS_FINISHED) {
            Toast.makeText(this, message.obj as String, Toast.LENGTH_LONG).show()
        }
    }
}
