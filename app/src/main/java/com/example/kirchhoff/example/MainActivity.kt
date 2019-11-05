package com.example.kirchhoff.example

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.bottomnavigationview.BottomNavigationViewActivity
import com.example.constraintanimation.ConstraintLayoutAnimationActivity
import com.example.custommenuitem.CustomMenuItemActivity
import com.example.kirchhoff.example.extension.startActivity
import com.example.lazybind.LazyBindActivity
import com.example.prefixedittext.PrefixEditTextActivity
import com.example.progressbarcustomization.ProgressBarCustomizationActivity
import com.example.raindropview.RainDropActivity
import com.example.screenshot.ScreenshotActivity
import com.example.simpletransition.SimpleTransitionActivity
import com.kirchhoff.activitytoservice.ActivityToService
import com.kirchhoff.coordinatebehavior.CoordinatorBehaviorActivity
import com.kirchhoff.countdownlabel.CountdownLabelActivity
import com.kirchhoff.curvedbottombar.CurvedBottomBarActivity
import com.kirchhoff.fabanimation.FabAnimationActivity
import com.kirchhoff.gmailselectinganimation.GmailSelectionActivity
import com.kirchhoff.viewpagerwithoutfragment.VPWithoutFragmentActivity

@Suppress("UNUSED_PARAMETER")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_main)
    }

    fun recyclerViewExamples(view: View) {
        startActivity(RecyclerViewExamplesActivity::class.java)
    }

    fun fragmentsExamples(view: View) {
        startActivity(FragmentsActivity::class.java)
    }

    fun fabAnimation(view: View) {
        startActivity(FabAnimationActivity::class.java)
    }

    fun vpWithoutFragment(view: View) {
        startActivity(VPWithoutFragmentActivity::class.java)
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

    fun curvedBottomBarExample(view: View) {
        startActivity(CurvedBottomBarActivity::class.java)
    }

    fun gmailSelecting(view: View) {
        startActivity(GmailSelectionActivity::class.java)
    }

    fun raindropExample(view: View) {
        startActivity(RainDropActivity::class.java)
    }

    fun constraintLayoutAnimation(view: View) {
        startActivity(ConstraintLayoutAnimationActivity::class.java)
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

    fun progressBarCustomization(view: View) {
        startActivity(ProgressBarCustomizationActivity::class.java)
    }

    fun customMenuItem(view: View) {
        startActivity(CustomMenuItemActivity::class.java)
    }
}
