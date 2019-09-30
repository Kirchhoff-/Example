package com.kirchhoff.circularrevealfragment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kirchhoff.circularrevealfragment.R
import com.kirchhoff.circularrevealfragment.utils.ExitWithAnimation
import com.kirchhoff.circularrevealfragment.utils.startCircularReveal

/**
 * @author Kirchhoff-
 */
class TwoFragment : Fragment(), ExitWithAnimation {

    override var posX: Int? = null
    override var posY: Int? = null

    override fun isToBeExitedWithAnimation(): Boolean = true

    companion object {
        @JvmStatic
        fun newInstance(exit: IntArray? = null): TwoFragment = TwoFragment().apply {
            if (exit != null && exit.size == 2) {
                posX = exit[0]
                posY = exit[1]
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.f_two, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.startCircularReveal(true)
    }
}