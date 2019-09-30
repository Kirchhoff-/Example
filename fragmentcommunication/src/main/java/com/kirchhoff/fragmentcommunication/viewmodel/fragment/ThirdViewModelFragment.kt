package com.kirchhoff.fragmentcommunication.viewmodel.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
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