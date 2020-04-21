package com.example.bottomnavigationview.fragment

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.bottomnavigationview.R

internal class InformationFragment : Fragment(R.layout.f_information) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val tvInformation = view.findViewById<TextView>(R.id.tvInformation)
        tvInformation.movementMethod = ScrollingMovementMethod()
    }
}
