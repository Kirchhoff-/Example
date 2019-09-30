package com.example.recyclertoviewpager.adapter.listener

import android.transition.TransitionSet
import android.view.View
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.recyclertoviewpager.R
import com.example.recyclertoviewpager.RecyclerToViewPagerActivity
import com.example.recyclertoviewpager.fragment.ImagePagerFragment
import java.util.concurrent.atomic.AtomicBoolean

internal class ViewHolderListenerImpl internal constructor(private val fragment: Fragment) : ViewHolderListener {

    private val enterTransitionStarted: AtomicBoolean = AtomicBoolean()

    override fun onLoadCompleted(view: ImageView, adapterPosition: Int) {
        if (RecyclerToViewPagerActivity.currentPosition != adapterPosition) {
            return
        }

        if (enterTransitionStarted.getAndSet(true)) {
            return
        }

        fragment.startPostponedEnterTransition()
    }

    override fun onItemClicked(view: View, adapterPosition: Int) {
        RecyclerToViewPagerActivity.currentPosition = adapterPosition

        (fragment.exitTransition as TransitionSet).excludeTarget(view, true)

        val transitionView = view.findViewById<ImageView>(R.id.card_image)
        fragment.fragmentManager!!
                .beginTransaction()
                .setReorderingAllowed(true)
                .addSharedElement(transitionView, transitionView.transitionName)
                .replace(R.id.fragmentContainer, ImagePagerFragment(), ImagePagerFragment::class.java.simpleName)
                .addToBackStack(null)
                .commit()
    }
}