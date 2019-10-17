package com.example.recyclertoviewpager.fragment

import android.os.Bundle
import android.transition.TransitionInflater
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnLayoutChangeListener
import android.view.ViewGroup
import androidx.core.app.SharedElementCallback
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclertoviewpager.R
import com.example.recyclertoviewpager.RecyclerToViewPagerActivity
import com.example.recyclertoviewpager.adapter.GridAdapter
import com.example.recyclertoviewpager.adapter.listener.ViewHolderListenerImpl

/**
 * A fragment for displaying a grid of images.
 */
internal class GridFragment : Fragment() {

    private var recyclerView: RecyclerView? = null

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        recyclerView = inflater.inflate(R.layout.f_grid, container, false) as RecyclerView
        recyclerView!!.layoutManager = GridLayoutManager(context, 2)
        recyclerView!!.adapter = GridAdapter(Glide.with(this), ViewHolderListenerImpl(this))

        prepareTransitions()
        postponeEnterTransition()

        return recyclerView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scrollToPosition()
    }

    /**
     * Scrolls the recycler view to show the last viewed item in the grid. This is important when
     * navigating back from the grid.
     */
    private fun scrollToPosition() {
        recyclerView!!.addOnLayoutChangeListener(object : OnLayoutChangeListener {
            override fun onLayoutChange(
                    v: View,
                    left: Int,
                    top: Int,
                    right: Int,
                    bottom: Int,
                    oldLeft: Int,
                    oldTop: Int,
                    oldRight: Int,
                    oldBottom: Int
            ) {
                recyclerView!!.removeOnLayoutChangeListener(this)
                val layoutManager = recyclerView!!.layoutManager
                val viewAtPosition = layoutManager!!.findViewByPosition(RecyclerToViewPagerActivity.currentPosition)
                // Scroll to position if the view for the current position is null (not currently part of
                // layout manager children), or it's not completely visible.
                if (viewAtPosition == null || layoutManager
                                .isViewPartiallyVisible(viewAtPosition, false, true)) {
                    recyclerView!!.post { layoutManager.scrollToPosition(RecyclerToViewPagerActivity.currentPosition) }
                }
            }
        })
    }

    /**
     * Prepares the shared element transition to the pager fragment, as well as the other transitions
     * that affect the flow.
     */
    private fun prepareTransitions() {
        exitTransition = TransitionInflater.from(context)
                .inflateTransition(R.transition.grid_exit_transition)

        // A similar mapping is set at the ImagePagerFragment with a setEnterSharedElementCallback.
        setExitSharedElementCallback(object : SharedElementCallback() {
            override fun onMapSharedElements(names: List<String>?, sharedElements: MutableMap<String, View>?) {
                super.onMapSharedElements(names, sharedElements)
                val selectedViewHolder = recyclerView!!
                        .findViewHolderForAdapterPosition(RecyclerToViewPagerActivity.currentPosition)
                if (selectedViewHolder?.itemView == null) {
                    return
                }

                // Map the first shared element name to the child ImageView.
                sharedElements!![names!![0]] = selectedViewHolder.itemView.findViewById(R.id.card_image)
            }
        })
    }
}
