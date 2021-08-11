package com.example.kirchhoff.example

import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.bottomnavigationview.BottomNavigationViewActivity
import com.example.edittextcounter.EditTextCounterActivity
import com.example.kirchhoff.example.extension.startActivity
import com.example.prefixedittext.PrefixEditTextActivity
import com.example.progressbarcustomization.ProgressBarCustomizationActivity
import com.example.raindropview.RainDropActivity
import com.example.telegramloadinganimation.TelegramLoadingAnimation
import com.kirchhoff.countdownlabel.CountdownLabelActivity
import com.kirchhoff.curvedbottombar.CurvedBottomBarActivity
import com.kirchhoff.numbervisualizer.NumberVisualizerActivity
import com.kirchhoff.stateviewgroup.StateViewGroupActivity

@Suppress("UNUSED_PARAMETER")
class ViewsExample : AppCompatActivity(R.layout.a_views) {

    fun countDownLabel(view: View) {
        startActivity(CountdownLabelActivity::class.java)
    }

    fun curvedBottomBarExample(view: View) {
        startActivity(CurvedBottomBarActivity::class.java)
    }

    fun raindropExample(view: View) {
        startActivity(RainDropActivity::class.java)
    }

    fun prefixEditText(view: View) {
        startActivity(PrefixEditTextActivity::class.java)
    }

    fun bottomNavigationView(view: View) {
        startActivity(BottomNavigationViewActivity::class.java)
    }

    fun progressBarCustomization(view: View) {
        startActivity(ProgressBarCustomizationActivity::class.java)
    }

    fun editTextCounter(view: View) {
        startActivity(EditTextCounterActivity::class.java)
    }

    fun numberVisualizer(view: View) {
        startActivity(NumberVisualizerActivity::class.java)
    }

    fun stateViewGroup(view: View) {
        startActivity(StateViewGroupActivity::class.java)
    }

    fun telegramLoadingAnimation(view: View) {
        startActivity(TelegramLoadingAnimation::class.java)
    }
}
