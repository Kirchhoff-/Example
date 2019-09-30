package com.example.bottomnavigationview.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.bottomnavigationview.R

internal class ActionFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.f_action, container, false)
        val bClick: Button = rootView.findViewById(R.id.bClick)
        val tvClickCount: TextView = rootView.findViewById(R.id.tvClickCount)
        bClick.setOnClickListener {
            var currentClickCount = tvClickCount.text.toString().toInt()
            currentClickCount += 1
            tvClickCount.text = currentClickCount.toString()
        }
        return rootView
    }
}