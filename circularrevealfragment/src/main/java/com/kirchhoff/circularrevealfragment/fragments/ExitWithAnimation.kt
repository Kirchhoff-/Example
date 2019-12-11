package com.kirchhoff.circularrevealfragment.fragments

/**
 * Needs to be implemented by fragments that should exit with circular reveal
 * animation along with [isToBeExitedWithAnimation] returning true
 * @property posX the X-axis position of the center of circular reveal
 * @property posY the Y-axis position of the center of circular reveal
 */
internal interface ExitWithAnimation {
    var posX: Int?
    var posY: Int?
    /**
     * Must return true if required to exit with circular reveal animation
     */
    fun isToBeExitedWithAnimation(): Boolean
}
