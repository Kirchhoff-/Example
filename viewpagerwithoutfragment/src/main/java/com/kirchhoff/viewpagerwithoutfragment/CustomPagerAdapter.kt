package com.kirchhoff.viewpagerwithoutfragment

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class CustomPagerAdapter constructor(private val context: Context) : PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val customPagerEnum = CustomPagerEnum.values()[position]
        val layout = LayoutInflater.from(context).inflate(customPagerEnum.layoutResId, container, false)
        container.addView(layout)
        return layout
    }

    override fun destroyItem(container: ViewGroup, position: Int, view: Any) {
        container.removeView(view as View)
    }

    override fun getCount() = CustomPagerEnum.values().size

    override fun isViewFromObject(view: View, `object`: Any) = view === `object`

    override fun getPageTitle(position: Int): CharSequence {
        val customPagerEnum = CustomPagerEnum.values()[position]
        return context.getString(customPagerEnum.titleResId)
    }
}
