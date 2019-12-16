package com.kirchhoff.circularrevealfragment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.core.ui.BaseFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.kirchhoff.circularrevealfragment.R

class DashboardFragment : BaseFragment() {

    companion object {
        fun newInstance(): DashboardFragment = DashboardFragment()
    }

    override fun getLayoutId() = R.layout.f_dashboard

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

    private fun View.findLocationOfCenterOnTheScreen(): IntArray {
        val positions = intArrayOf(0, 0)
        getLocationInWindow(positions)
        positions[0] = positions[0] + width / 2
        positions[1] = positions[1] + height / 2
        return positions
    }
}
