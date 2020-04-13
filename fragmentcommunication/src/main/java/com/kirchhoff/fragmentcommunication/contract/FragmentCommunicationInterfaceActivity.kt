package com.kirchhoff.fragmentcommunication.contract

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.kirchhoff.fragmentcommunication.R
import com.kirchhoff.fragmentcommunication.contract.fragment.FirstInterfaceFragment
import com.kirchhoff.fragmentcommunication.contract.fragment.SecondInterfaceFragment

internal class FragmentCommunicationInterfaceActivity : AppCompatActivity(),
        FirstInterfaceFragment.TextClickedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_fragment_communication_interface)

        supportFragmentManager.beginTransaction()
                .add(R.id.firstContainer, FirstInterfaceFragment())
                .add(R.id.secondContainer, SecondInterfaceFragment())
                .commit()
    }

    override fun onAttachFragment(fragment: Fragment) {
        super.onAttachFragment(fragment)
        if (fragment is FirstInterfaceFragment) {
            fragment.setOnTextClickListener(this)
        }
    }

    override fun sendText(text: String) {
        val secondInterfaceFragment = supportFragmentManager
                .findFragmentById(R.id.secondContainer)
        if (secondInterfaceFragment is SecondInterfaceFragment) {
            secondInterfaceFragment.updateText(text)
        }
    }
}
