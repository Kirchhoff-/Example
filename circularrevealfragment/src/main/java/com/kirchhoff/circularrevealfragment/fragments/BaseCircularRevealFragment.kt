package com.kirchhoff.circularrevealfragment.fragments

import android.os.Bundle
import android.view.View
import com.example.core.ui.BaseFragment
import com.kirchhoff.circularrevealfragment.utils.ExitWithAnimation
import com.kirchhoff.circularrevealfragment.utils.startCircularReveal

internal abstract class BaseCircularRevealFragment : BaseFragment(), ExitWithAnimation {

    override var posX: Int? = null
    override var posY: Int? = null

    abstract fun circularRevealFromLeft(): Boolean

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.startCircularReveal(circularRevealFromLeft())
    }
}
