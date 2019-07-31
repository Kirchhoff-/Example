package com.example.kirchhoff.example

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

import com.example.likebutton.LikeButtonActivity
import com.example.raindropview.RainDropActivity
import com.example.recyclercollapsing.RecyclerCollapsingToolbarActivity
import com.example.recyclerswipe.RecyclerCustomSwipeActivity
import com.example.timediffutils.TimeDiffUtilActivity
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
import com.kirchhoff.simpletransition.SimpleTransitionActivity
import com.kirchhoff.thingdiffutils.ThingDiffUtilActivity
import com.kirchhoff.viewpagerwithoutfragment.VPWithoutFragmentActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_main)

        findViewById<View>(R.id.recyclerViewWithSearch).setOnClickListener(this)
        findViewById<View>(R.id.fabAnimationExample).setOnClickListener(this)
        findViewById<View>(R.id.customRecyclerSwipe).setOnClickListener(this)
        findViewById<View>(R.id.recyclerCollapsing).setOnClickListener(this)
        findViewById<View>(R.id.vpWithoutFragment).setOnClickListener(this)
        findViewById<View>(R.id.timeDiffUtil).setOnClickListener(this)
        findViewById<View>(R.id.likeButtonClick).setOnClickListener(this)
        findViewById<View>(R.id.countDownLabel).setOnClickListener(this)
        findViewById<View>(R.id.simpleTransition).setOnClickListener(this)
        findViewById<View>(R.id.customCoordinateLayoutBehavior).setOnClickListener(this)
        findViewById<View>(R.id.mvpRecycler).setOnClickListener(this)
        findViewById<View>(R.id.thingDiffUtils).setOnClickListener(this)
        findViewById<View>(R.id.fastRecyclerViewExample).setOnClickListener(this)
        findViewById<View>(R.id.curvedBottomBarExample).setOnClickListener(this)
        findViewById<View>(R.id.circularRevealFragmentAnimationExample).setOnClickListener(this)
        findViewById<View>(R.id.bFragmentCommunication).setOnClickListener(this)
        findViewById<View>(R.id.bGmailSelecting).setOnClickListener(this)
        findViewById<View>(R.id.bRaindropExample).setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val resultClass = when {
            view.id == R.id.recyclerViewWithSearch -> RecyclerSearchActivity::class.java
            view.id == R.id.fabAnimationExample -> FabAnimationActivity::class.java
            view.id == R.id.customRecyclerSwipe -> RecyclerCustomSwipeActivity::class.java
            view.id == R.id.recyclerCollapsing -> RecyclerCollapsingToolbarActivity::class.java
            view.id == R.id.vpWithoutFragment -> VPWithoutFragmentActivity::class.java
            view.id == R.id.timeDiffUtil -> TimeDiffUtilActivity::class.java
            view.id == R.id.likeButtonClick -> LikeButtonActivity::class.java
            view.id == R.id.countDownLabel -> CountdownLabelActivity::class.java
            view.id == R.id.simpleTransition -> SimpleTransitionActivity::class.java
            view.id == R.id.customCoordinateLayoutBehavior -> CoordinatorBehaviorActivity::class.java
            view.id == R.id.mvpRecycler -> MvpRecyclerViewActivity::class.java
            view.id == R.id.thingDiffUtils -> ThingDiffUtilActivity::class.java
            view.id == R.id.fastRecyclerViewExample -> FastRecyclerViewActivity::class.java
            view.id == R.id.curvedBottomBarExample -> CurvedBottomBarActivity::class.java
            view.id == R.id.circularRevealFragmentAnimationExample -> CircularFragmentAnimationActivity::class.java
            view.id == R.id.bFragmentCommunication -> FragmentCommunicationActivity::class.java
            view.id == R.id.bGmailSelecting -> GmailSelectionActivity::class.java
            view.id == R.id.bRaindropExample -> RainDropActivity::class.java
            else -> MainActivity::class.java
        }

        startActivity(Intent(this, resultClass))
    }
}
