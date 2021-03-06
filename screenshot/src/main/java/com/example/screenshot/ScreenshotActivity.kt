package com.example.screenshot

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity

class ScreenshotActivity : AppCompatActivity(R.layout.a_screenshot), View.OnClickListener {

    private lateinit var rootLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rootLayout = findViewById(R.id.rootLayout)

        findViewById<Button>(R.id.bScreenshot).setOnClickListener(this)
        findViewById<Button>(R.id.bScreenshotWithToolbar).setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.bScreenshot -> makeScreenShot(rootLayout)
            R.id.bScreenshotWithToolbar -> makeScreenShot(window.decorView.rootView)
        }
    }

    private fun makeScreenShot(view: View): Bitmap {
        val returnedBitmap = Bitmap.createBitmap(view.width, view.height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(returnedBitmap)
        val bgDrawable = view.background
        if (bgDrawable != null) {
            bgDrawable.draw(canvas)
        } else canvas.drawColor(Color.WHITE)
        view.draw(canvas)
        return returnedBitmap
    }
}
