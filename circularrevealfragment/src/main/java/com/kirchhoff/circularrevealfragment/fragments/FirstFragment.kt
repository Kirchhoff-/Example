package com.kirchhoff.circularrevealfragment.fragments

import com.kirchhoff.circularrevealfragment.R

internal class FirstFragment : BaseCircularRevealFragment(R.layout.f_first) {
    override fun isToBeExitedWithAnimation(): Boolean = true
    override fun circularRevealFromLeft() = false
}
