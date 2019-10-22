package com.kirchhoff.circularrevealfragment.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.kirchhoff.circularrevealfragment.utils.ExitWithAnimation
import com.kirchhoff.circularrevealfragment.utils.startCircularReveal

internal abstract class BaseCircularRevealFragment : Fragment(), ExitWithAnimation {

    override var posX: Int? = null
    override var posY: Int? = null

    @LayoutRes abstract fun layoutId(): Int

    abstract fun circularRevealFromLeft(): Boolean

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.startCircularReveal(circularRevealFromLeft())
    }
}
