package com.example.kirchhoff.example

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.kirchhoff.example.extension.startActivity
import com.example.recyclercollapsing.RecyclerCollapsingToolbarActivity
import com.example.recyclerdragdrop.RecyclerViewDragDropActivity
import com.example.recyclersmoothswipe.RecyclerSmoothSwipeActivity
import com.example.recyclertoviewpager.RecyclerToViewPagerActivity
import com.example.timediffutils.TimeDiffUtilActivity
import com.kirchhoff.fastrecyclerview.FastRecyclerViewActivity
import com.kirchhoff.recyclermvp.MvpRecyclerViewActivity
import com.kirchhoff.recyclersearch.RecyclerSearchActivity
import com.kirchhoff.thingdiffutils.ThingDiffUtilActivity

@Suppress("UNUSED_PARAMETER")
class RecyclerViewExamplesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_recycler_view_examples)
    }

    fun recyclerViewWithSearch(view: View) {
        startActivity(RecyclerSearchActivity::class.java)
    }

    fun recyclerCollapsing(view: View) {
        startActivity(RecyclerCollapsingToolbarActivity::class.java)
    }

    fun mvpRecycler(view: View) {
        startActivity(MvpRecyclerViewActivity::class.java)
    }

    fun fastRecyclerViewExample(view: View) {
        startActivity(FastRecyclerViewActivity::class.java)
    }

    fun recyclerSmoothSwipe(view: View) {
        startActivity(RecyclerSmoothSwipeActivity::class.java)
    }

    fun recyclerDragDrop(view: View) {
        startActivity(RecyclerViewDragDropActivity::class.java)
    }

    fun recyclerToViewPager(view: View) {
        startActivity(RecyclerToViewPagerActivity::class.java)
    }

    fun timeDiffUtil(view: View) {
        startActivity(TimeDiffUtilActivity::class.java)
    }

    fun thingDiffUtils(view: View) {
        startActivity(ThingDiffUtilActivity::class.java)
    }
}
