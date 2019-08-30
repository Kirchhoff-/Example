package com.kirchhoff.activitytoservice.resultreceiver

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

internal class ResultReceiverActivity : AppCompatActivity(), CustomResultReceiver.AppReceiver {

    private var resultReceiver: CustomResultReceiver? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerService()
    }

    private fun registerService() {
        val intent = Intent(applicationContext, CustomIntentService::class.java)
        /*
         * Pass the ResultReceiver via the intent to the intent service
         * */
        resultReceiver = CustomResultReceiver(Handler(), this)
        intent.putExtra("receiver", resultReceiver)
        startService(intent)
    }

    override fun onReceiveResult(resultCode: Int, resultData: Bundle) {
        /*
         * Handle the results from the intent service here!
         * */
        Toast.makeText(this, "Some text from Service", Toast.LENGTH_LONG).show()
    }

    override fun onStop() {
        super.onStop()
        if (resultReceiver != null) {
            resultReceiver = null
        }
    }
}
