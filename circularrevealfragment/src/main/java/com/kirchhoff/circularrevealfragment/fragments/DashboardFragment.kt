package com.kirchhoff.circularrevealfragment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.kirchhoff.circularrevealfragment.R
import com.kirchhoff.circularrevealfragment.utils.findLocationOfCenterOnTheScreen

class DashboardFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(): DashboardFragment = DashboardFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.f_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<FloatingActionButton>(R.id.fab1).setOnClickListener {
            val positions = it.findLocationOfCenterOnTheScreen()
            fragmentManager?.beginTransaction()?.add(R.id.container, OneFragment.newInstance(positions))?.addToBackStack(null)?.commit()
        }

        view.findViewById<FloatingActionButton>(R.id.fab2).setOnClickListener {
            val positions = it.findLocationOfCenterOnTheScreen()
            fragmentManager?.beginTransaction()?.add(R.id.container, TwoFragment.newInstance(positions))?.addToBackStack(null)?.commit()
        }
    }
}
