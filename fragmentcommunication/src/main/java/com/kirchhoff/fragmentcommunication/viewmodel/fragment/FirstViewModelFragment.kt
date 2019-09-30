package com.kirchhoff.fragmentcommunication.viewmodel.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.kirchhoff.fragmentcommunication.R
import com.kirchhoff.fragmentcommunication.viewmodel.TextViewModel

class FirstViewModelFragment : Fragment() {

    private val allowedChars = "ABCDEFGHIJKLMNOPQRSTUVWXTZabcdefghiklmnopqrstuvwxyz"
    private var textViewModel: TextViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.f_first_view_model, container, false)
        textViewModel = activity?.let { ViewModelProviders.of(it).get(TextViewModel::class.java) }
        rootView.findViewById<Button>(R.id.bRandomString).setOnClickListener {
            textViewModel?.message(randomString())
        }
        return rootView
    }

    private fun randomString(): String {
        return (1..allowedChars.length)
                .map { allowedChars.random() }
                .joinToString("")
    }
}