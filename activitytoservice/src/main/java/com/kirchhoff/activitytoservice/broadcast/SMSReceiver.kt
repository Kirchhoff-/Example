package com.kirchhoff.activitytoservice.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.Telephony

internal open class SMSReceiver : BroadcastReceiver() {

    companion object {
        const val SMS_INTENT_DATA = "sms.intent.data"
        const val SMS_INTENT_ACTION = "sms.intent.action"
    }

    @Suppress("UNCHECKED_CAST")
    override fun onReceive(context: Context, intent: Intent) {

        if (intent.extras != null) {

            /*
             * We need to fetch the incoming sms that is broadcast.
             * For this we check the intent of the receiver.
             * */
            val pdus = intent.extras!!.get("pdus") as Array<Any>
            for (i in pdus.indices) {

                val smsMessage = Telephony.Sms.Intents.getMessagesFromIntent(intent)[i]
                val sender = smsMessage.originatingAddress
                val body = smsMessage.messageBody.toString()

                /*
                 * We have to specify an action for this intent. Now this can be anything String.
                 * This action is important because this action identifies the broadcast event
                 *  */
                val smsIntent = Intent(SMS_INTENT_ACTION)
                val extras = Bundle()
                extras.putString(SMS_INTENT_DATA, "$sender $body")
                smsIntent.putExtras(extras)
                context.sendBroadcast(smsIntent)
            }
        }
    }
}