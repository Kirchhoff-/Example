package com.kirchhoff.viewpagerwithoutfragment;

import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;

/**
 * @author Kirchhoff-
 */

public enum CustomPagerEnum {

    RED(R.string.red, R.layout.v_red),
    BLUE(R.string.blue, R.layout.v_blue),
    ORANGE(R.string.orange, R.layout.v_orange);

    @StringRes
    private int titleResId;
    @LayoutRes
    private int layoutResId;

    CustomPagerEnum(@StringRes int titleResId, @LayoutRes int layoutResId) {
        this.titleResId = titleResId;
        this.layoutResId = layoutResId;
    }

    public int getTitleResId() {
        return titleResId;
    }

    public int getLayoutResId() {
        return layoutResId;
    }
}
