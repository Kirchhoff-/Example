package com.kirchhoff.fragmentcommunication.viewmodel.fragment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.kirchhoff.fragmentcommunication.R
import com.kirchhoff.fragmentcommunication.viewmodel.TextViewModel

class ThirdViewModelFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.f_third_view_model, container, false)
        val tvReverseRandomString = rootView.findViewById<TextView>(R.id.tvReverseRandomString)

        val textViewModel = activity?.let { ViewModelProviders.of(it).get(TextViewModel::class.java) }
        textViewModel?.message?.observe(this, Observer<String> { text -> tvReverseRandomString.text = text?.reversed() })
        return rootView
    }
}