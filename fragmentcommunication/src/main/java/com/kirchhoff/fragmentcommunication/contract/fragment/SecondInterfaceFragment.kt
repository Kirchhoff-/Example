package com.kirchhoff.fragmentcommunication.contract.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.kirchhoff.fragmentcommunication.R

internal class SecondInterfaceFragment : Fragment() {

    private lateinit var tvIncomingText: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.f_second_interface, container, false)
        tvIncomingText = rootView.findViewById(R.id.tvIncomingText)
        return rootView
    }

    fun updateText(text: String) {
        tvIncomingText.text = text
    }
}
