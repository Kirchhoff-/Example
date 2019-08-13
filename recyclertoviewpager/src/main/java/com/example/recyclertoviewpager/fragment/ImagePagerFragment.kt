package com.example.recyclertoviewpager.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.recyclertoviewpager.ImagePagerAdapter

import com.example.recyclertoviewpager.R
import com.example.recyclertoviewpager.RecyclerToViewPagerActivity

/**
 * A fragment for displaying a pager of images.
 */
internal class ImagePagerFragment : Fragment() {

    private var viewPager: ViewPager? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewPager = inflater.inflate(R.layout.f_pager, container, false) as ViewPager
        viewPager!!.adapter = ImagePagerAdapter(this)
        // Set the current position and add a listener that will update the selection coordinator when
        // paging the images.
        viewPager!!.currentItem = RecyclerToViewPagerActivity.currentPosition
        viewPager!!.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageSelected(position: Int) {
                RecyclerToViewPagerActivity.currentPosition = position
            }
        })

        prepareSharedElementTransition()

        // Avoid a postponeEnterTransition on orientation change, and postpone only of first creation.
        if (savedInstanceState == null) {
            postponeEnterTransition()
        }

        return viewPager
    }

    /**
     * Prepares the shared element transition from and back to the grid fragment.
     */
    private fun prepareSharedElementTransition() {
        val transition = TransitionInflater.from(context)
                .inflateTransition(R.transition.image_shared_element_transition)
        sharedElementEnterTransition = transition

        // A similar mapping is set at the GridFragment with a setExitSharedElementCallback.
        setEnterSharedElementCallback(object : android.support.v4.app.SharedElementCallback() {
            override fun onMapSharedElements(names: List<String>?, sharedElements: MutableMap<String, View>?) {
                super.onMapSharedElements(names, sharedElements)
                // visible). To locate the fragment, call instantiateItem with the selection position.
                // At this stage, the method will simply return the fragment at the position and will
                // not create a new one.
                val currentFragment = viewPager!!.adapter!!
                        .instantiateItem(viewPager!!, RecyclerToViewPagerActivity.currentPosition) as Fragment
                val view = currentFragment.view ?: return

                // Map the first shared element name to the child ImageView.
                sharedElements!![names!![0]] = view.findViewById(R.id.image)
            }
        })
    }
}