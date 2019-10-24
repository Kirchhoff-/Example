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
        fun newInstance(): DashboardFragment = DashboardFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.f_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<FloatingActionButton>(R.id.fab1).setOnClickListener { openFragment(FirstFragment()) }
        view.findViewById<FloatingActionButton>(R.id.fab2).setOnClickListener { openFragment(SecondFragment()) }
    }

    private fun openFragment(fragment: BaseCircularRevealFragment) {
        val positions = view!!.findLocationOfCenterOnTheScreen()
        fragmentManager?.beginTransaction()?.add(R.id.container,
                createFragmentWithPosition(fragment, positions))?.addToBackStack(null)?.commit()
    }

    private fun createFragmentWithPosition(fragment: BaseCircularRevealFragment, positions: IntArray): Fragment {
        fragment.posX = positions[0]
        fragment.posY = positions[1]
        return fragment
    }
}
