package com.example.twittersplash

import android.annotation.SuppressLint
import android.app.Activity
import android.view.View
import androidx.appcompat.app.AppCompatActivity

@SuppressLint("CustomSplashScreen")
class TwitterSplashActivity: AppCompatActivity(R.layout.a_twitter_splash) {

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        if (hasFocus) {
            hideSystemUIAndNavigation(this)
        }
    }

    @Suppress("DEPRECATION")
    private fun hideSystemUIAndNavigation(activity: Activity) {
        val decorView: View = activity.window.decorView
        decorView.systemUiVisibility =
            (
                View.SYSTEM_UI_FLAG_IMMERSIVE or
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION or
                View.SYSTEM_UI_FLAG_FULLSCREEN
            )
    }
}