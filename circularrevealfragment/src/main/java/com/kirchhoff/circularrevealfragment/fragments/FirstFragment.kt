package com.kirchhoff.circularrevealfragment.fragments

import com.kirchhoff.circularrevealfragment.R

internal class FirstFragment : BaseCircularRevealFragment() {
    override fun isToBeExitedWithAnimation(): Boolean = true
    override fun layoutId() = R.layout.f_first
    override fun circularRevealFromLeft() = false
}
