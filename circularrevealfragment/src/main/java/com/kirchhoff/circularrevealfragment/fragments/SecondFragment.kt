package com.kirchhoff.circularrevealfragment.fragments

import com.kirchhoff.circularrevealfragment.R

internal class SecondFragment : BaseCircularRevealFragment(R.layout.f_second) {
    override fun isToBeExitedWithAnimation(): Boolean = false
    override fun circularRevealFromLeft() = true
}
