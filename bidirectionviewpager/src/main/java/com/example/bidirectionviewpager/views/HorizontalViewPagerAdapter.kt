package com.example.bidirectionviewpager.views

import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter

class HorizontalViewPagerAdapter(
    private var biAdapter: BiDirectionViewPager.BiDirectionViewPagerAdapter?,
    private val verticalPosition: Int
) : PagerAdapter() {

    override fun instantiateItem(parent: ViewGroup, position: Int): Any {
        biAdapter?.also { _biAdapter ->
            val viewHolder = _biAdapter.onCreateView(parent)
            val view = viewHolder.itemView
            parent.addView(view)
            _biAdapter.onBindView(viewHolder, verticalPosition, position)
            return view
        }
        return Unit
    }

    override fun destroyItem(parent: ViewGroup, position: Int, _object: Any) {
        parent.removeView(_object as View)
    }

    override fun isViewFromObject(view: View, _object: Any): Boolean = view == _object

    override fun getCount() = biAdapter?.getHorizontalItemCount(verticalPosition) ?: 0

    fun dispose() {
        biAdapter = null
        notifyDataSetChanged()
    }
}
