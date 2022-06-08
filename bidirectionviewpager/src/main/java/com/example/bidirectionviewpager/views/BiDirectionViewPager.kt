package com.example.bidirectionviewpager.views

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Point
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.example.bidirectionviewpager.R
import com.example.bidirectionviewpager.extensions.distanceFrom
import com.example.bidirectionviewpager.utils.MotionUtil

class BiDirectionViewPager @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : ViewPager(context, attrs) {

    var biAdapter: BiDirectionViewPagerAdapter? = null
        set(value) {
            value?.let {
                field = it
                adapter = BiDirectionViewPagerAdapterInternal(it)
            }
        }

    private val fingerMoveThreshold: Int
    private var initialTouchPoint = Point(0, 0)
    private var firstTime = true

    init {
        setPageTransformer(true, VerticalPageTransformer())
        fingerMoveThreshold = context.resources.getDimensionPixelSize(R.dimen.finger_move_threshold)
    }

    override fun onInterceptTouchEvent(event: MotionEvent): Boolean {
        val action = event.actionMasked
        val currentPoint = Point(event.x.toInt(), event.y.toInt())

        initialTouchPoint = when (action) {
            MotionEvent.ACTION_DOWN -> Point(currentPoint)
            MotionEvent.ACTION_UP -> Point(0, 0)
            else -> return checkVerticalScroll(currentPoint)
        }

        return false
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent): Boolean {
        // swapping the motionEvent's x and y, so that when finger moves right, it becomes moving down
        // for VerticalViewPager effect
        event.swapXY()

        if (firstTime && event.actionMasked == MotionEvent.ACTION_MOVE) {
            injectActionDown(event)
            firstTime = false
        }
        if (event.actionMasked == MotionEvent.ACTION_UP) {
            firstTime = true
        }
        super.onTouchEvent(event)
        return true
    }

    /**
     * in order for super.onTouchEvent() to actually scroll the VerticalViewPager,
     * we need to start with ACTION_DOWN
     *
     * Because the complete cycle is:
     * super.onTouchEvent(event with ACTION_DOWN) x 1 time
     * super.onTouchEvent(event with ACTION_MOVE) x n times
     * super.onTouchEvent(event with ACTION_DOWN) x 1 time
     *
     * this method returns nothing, but has side effect
     */
    private fun injectActionDown(event: MotionEvent) {
        event.action = MotionEvent.ACTION_DOWN
        super.onTouchEvent(event)
        event.action = MotionEvent.ACTION_MOVE
    }

    @Suppress("unused")
    fun notifyDataSetChangedHorizontal(verticalPosition: Int) {
        (adapter as? BiDirectionViewPagerAdapterInternal)?.let {
            it.viewList[verticalPosition]?.getHorizontalViewPager()?.adapter?.notifyDataSetChanged()
        }
    }

    private fun MotionEvent.swapXY() {
        val width = width.toFloat()
        val height = height.toFloat()
        val newX = y / height * width
        val newY = x / width * height
        setLocation(newX, newY)
    }

    private fun checkVerticalScroll(currentPoint: Point): Boolean {
        if (currentPoint.distanceFrom(initialTouchPoint) > fingerMoveThreshold) {
            val direction = MotionUtil.getDirection(initialTouchPoint, currentPoint)
            if (direction == MotionUtil.Direction.UP || direction == MotionUtil.Direction.DOWN) {
                return true
            }
        }

        return false
    }

    interface BiDirectionViewPagerAdapter {
        fun onCreateView(parent: ViewGroup): ViewHolder
        fun onBindView(viewHolder: ViewHolder, rowPosition: Int, columnPosition: Int)
        fun getItemCount(): Int
        fun getHorizontalItemCount(verticalPosition: Int): Int
    }

    abstract class ViewHolder(val itemView: View)

    private inner class BiDirectionViewPagerAdapterInternal(
        val biAdapter: BiDirectionViewPagerAdapter
    ) : PagerAdapter() {
        val viewList = mutableMapOf<Int, View>()

        override fun instantiateItem(parent: ViewGroup, position: Int): Any {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.v_horizontal_view_pager, parent, false)
            parent.addView(view)
            view.getHorizontalViewPager().adapter = HorizontalViewPagerAdapter(biAdapter, position)
            viewList[position] = view

            return view
        }

        override fun destroyItem(parent: ViewGroup, position: Int, _object: Any) {
            val view = _object as View
            view.getHorizontalViewPager().let {
                (it.adapter as? HorizontalViewPagerAdapter)?.dispose()
                it.adapter = null
            }
            parent.removeView(view)
            viewList.remove(position)
        }

        override fun isViewFromObject(view: View, _object: Any): Boolean = view == _object

        override fun getCount() = biAdapter.getItemCount()
    }

    private fun View.getHorizontalViewPager(): ViewPager = this.findViewById(R.id.horizontalViewPager)
}
