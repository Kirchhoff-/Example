package com.example.kirchhoff.example

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.example.bottomnavigationview.BottomNavigationViewActivity
import com.example.constraintanimation.ConstraintLayoutAnimationActivity
import com.example.lazybind.LazyBindActivity
import com.example.likebutton.LikeButtonActivity
import com.example.prefixedittext.PrefixEditTextActivity
import com.example.raindropview.RainDropActivity
import com.example.recyclercollapsing.RecyclerCollapsingToolbarActivity
import com.example.recyclerdragdrop.RecyclerViewDragDropActivity
import com.example.recyclersmoothswipe.RecyclerSmoothSwipeActivity
import com.example.recyclertoviewpager.RecyclerToViewPagerActivity
import com.example.screenshot.ScreenshotActivity
import com.example.simpletransition.SimpleTransitionActivity
import com.example.timediffutils.TimeDiffUtilActivity
import com.kirchhoff.activitytoservice.ActivityToService
import com.kirchhoff.circularrevealfragment.CircularFragmentAnimationActivity
import com.kirchhoff.coordinatebehavior.CoordinatorBehaviorActivity
import com.kirchhoff.countdownlabel.CountdownLabelActivity
import com.kirchhoff.curvedbottombar.CurvedBottomBarActivity
import com.kirchhoff.fabanimation.FabAnimationActivity
import com.kirchhoff.fastrecyclerview.FastRecyclerViewActivity
import com.kirchhoff.fragmentcommunication.FragmentCommunicationActivity
import com.kirchhoff.gmailselectinganimation.GmailSelectionActivity
import com.kirchhoff.recyclermvp.MvpRecyclerViewActivity
import com.kirchhoff.recyclersearch.RecyclerSearchActivity
import com.kirchhoff.thingdiffutils.ThingDiffUtilActivity
import com.kirchhoff.viewpagerwithoutfragment.VPWithoutFragmentActivity

@Suppress("UNUSED_PARAMETER")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_main)
    }

    fun recyclerViewWithSearch(view: View) {
        startActivity(RecyclerSearchActivity::class.java)
    }

    fun fabAnimation(view: View) {
        startActivity(FabAnimationActivity::class.java)
    }

    fun recyclerCollapsing(view: View) {
        startActivity(RecyclerCollapsingToolbarActivity::class.java)
    }

    fun vpWithoutFragment(view: View) {
        startActivity(VPWithoutFragmentActivity::class.java)
    }

    fun timeDiffUtil(view: View) {
        startActivity(TimeDiffUtilActivity::class.java)
    }

    fun likeButtonClick(view: View) {
        startActivity(LikeButtonActivity::class.java)
    }

    fun countDownLabel(view: View) {
        startActivity(CountdownLabelActivity::class.java)
    }

    fun simpleTransition(view: View) {
        startActivity(SimpleTransitionActivity::class.java)
    }

    fun customCoordinateLayoutBehavior(view: View) {
        startActivity(CoordinatorBehaviorActivity::class.java)
    }

    fun mvpRecycler(view: View) {
        startActivity(MvpRecyclerViewActivity::class.java)
    }

    fun thingDiffUtils(view: View) {
        startActivity(ThingDiffUtilActivity::class.java)
    }

    fun fastRecyclerViewExample(view: View) {
        startActivity(FastRecyclerViewActivity::class.java)
    }

    fun curvedBottomBarExample(view: View) {
        startActivity(CurvedBottomBarActivity::class.java)
    }

    fun circularRevealFragmentAnimationExample(view: View) {
        startActivity(CircularFragmentAnimationActivity::class.java)
    }

    fun fragmentCommunication(view: View) {
        startActivity(FragmentCommunicationActivity::class.java)
    }

    fun gmailSelecting(view: View) {
        startActivity(GmailSelectionActivity::class.java)
    }

    fun raindropExample(view: View) {
        startActivity(RainDropActivity::class.java)
    }

    fun recyclerSmoothSwipe(view: View) {
        startActivity(RecyclerSmoothSwipeActivity::class.java)
    }

    fun constraintLayoutAnimation(view: View) {
        startActivity(ConstraintLayoutAnimationActivity::class.java)
    }

    fun recyclerDragDrop(view: View) {
        startActivity(RecyclerViewDragDropActivity::class.java)
    }

    fun recyclerToViewPager(view: View) {
        startActivity(RecyclerToViewPagerActivity::class.java)
    }

    fun prefixEditText(view: View) {
        startActivity(PrefixEditTextActivity::class.java)
    }

    fun bottomNavigationView(view: View) {
        startActivity(BottomNavigationViewActivity::class.java)
    }

    fun activityToService(view: View) {
        startActivity(ActivityToService::class.java)
    }

    fun lazyBind(view: View) {
        startActivity(LazyBindActivity::class.java)
    }

    fun screenshot(view: View) {
        startActivity(ScreenshotActivity::class.java)
    }

    private fun startActivity(cls: Class<*>) {
        startActivity(Intent(this, cls))
    }
}
