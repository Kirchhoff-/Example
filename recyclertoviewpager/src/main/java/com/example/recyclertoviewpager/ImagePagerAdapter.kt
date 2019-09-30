package com.example.recyclertoviewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.recyclertoviewpager.data.IMAGE_DRAWABLES
import com.example.recyclertoviewpager.fragment.ImageFragment

internal class ImagePagerAdapter(fragment: Fragment) : FragmentStatePagerAdapter(fragment.childFragmentManager) {

    override fun getCount() = IMAGE_DRAWABLES.size

    override fun getItem(position: Int) = ImageFragment.newInstance(IMAGE_DRAWABLES[position])
}