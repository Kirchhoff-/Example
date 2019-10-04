package com.example.bottomnavigationview.fragment

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.TextView
import com.example.bottomnavigationview.R
import com.example.core.ui.BaseFragment

internal class InformationFragment : BaseFragment() {

    override fun getLayoutId() = R.layout.f_information

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tvInformation = view.findViewById<TextView>(R.id.tvInformation)
        tvInformation.movementMethod = ScrollingMovementMethod()
    }
}