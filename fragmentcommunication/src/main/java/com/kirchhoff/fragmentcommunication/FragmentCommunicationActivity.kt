package com.kirchhoff.fragmentcommunication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.kirchhoff.fragmentcommunication.contract.FragmentCommunicationInterfaceActivity
import com.kirchhoff.fragmentcommunication.viewmodel.FragmentCommunicationViewModelActivity

class FragmentCommunicationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_fragment_communication)
        findViewById<View>(R.id.bInterfaceCommunication).setOnClickListener { startActivity(Intent(this, FragmentCommunicationInterfaceActivity::class.java)) }
        findViewById<View>(R.id.bViewModelCommunication).setOnClickListener { startActivity(Intent(this, FragmentCommunicationViewModelActivity::class.java)) }
    }
}