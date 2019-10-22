package com.kirchhoff.circularrevealfragment.fragments

import com.kirchhoff.circularrevealfragment.R

internal class SecondFragment : BaseCircularRevealFragment() {
    override fun isToBeExitedWithAnimation(): Boolean = false
    override fun layoutId() = R.layout.f_second
    override fun circularRevealFromLeft() = true
}
