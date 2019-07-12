package com.kirchhoff.viewpagerwithoutfragment

import android.support.annotation.LayoutRes
import android.support.annotation.StringRes

enum class CustomPagerEnum(@param:StringRes @field:StringRes val titleResId: Int,
                           @param:LayoutRes @field:LayoutRes val layoutResId: Int) {
    RED(R.string.red, R.layout.v_red),
    BLUE(R.string.blue, R.layout.v_blue),
    ORANGE(R.string.orange, R.layout.v_orange)
}
