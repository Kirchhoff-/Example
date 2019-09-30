package com.kirchhoff.fragmentcommunication.contract.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.kirchhoff.fragmentcommunication.R

internal class FirstInterfaceFragment : Fragment() {

    private var textClickListener: TextClickedListener? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.f_first_interface, container, false)
        val edInit: EditText = rootView.findViewById(R.id.edInit)
        rootView.findViewById<Button>(R.id.bSend).setOnClickListener { textClickListener?.sendText(edInit.text.toString()) }
        return rootView
    }

    fun setOnTextClickListener(textClickListener: TextClickedListener) {
        this.textClickListener = textClickListener
    }

    interface TextClickedListener {
        fun sendText(text: String)
    }
}