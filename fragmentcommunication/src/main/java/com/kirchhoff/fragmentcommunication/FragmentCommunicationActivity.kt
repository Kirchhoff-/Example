package com.kirchhoff.fragmentcommunication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.kirchhoff.fragmentcommunication.contract.FragmentCommunicationInterfaceActivity
import com.kirchhoff.fragmentcommunication.viewmodel.FragmentCommunicationViewModelActivity

class FragmentCommunicationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_fragment_communication)
        val bInterface: Button = findViewById(R.id.bInterfaceCommunication)
        val bViewModel: Button = findViewById(R.id.bViewModelCommunication)
        bInterface.setOnClickListener { open(FragmentCommunicationInterfaceActivity::class.java) }
        bViewModel.setOnClickListener { open(FragmentCommunicationViewModelActivity::class.java) }
    }

    fun open(cls: Class<*>) {
        startActivity(Intent(this, cls))
    }
}
