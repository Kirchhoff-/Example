package com.example.simpletransition

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.content.ContextCompat

class SimpleTransitionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_simple_transition)

        val values = ArrayList<Array<String>>()
        fillDataArray(values)

        val list = findViewById<ListView>(R.id.list)
        list.adapter = CustomAdapter(this, values)

        list.onItemClickListener = AdapterView.OnItemClickListener { _, view, position, _ ->
            val intent = Intent(this@SimpleTransitionActivity, SimpleTransitionDetailsActivity::class.java)
            intent.putExtra("parameter", values[position])
            // Get the transition name from the string
            val transitionName = getString(R.string.transition)
            val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this@SimpleTransitionActivity,
                    view, // Starting view
                    transitionName // The String
            )
            ActivityCompat.startActivity(this@SimpleTransitionActivity, intent, options.toBundle())
        }
    }

    private fun fillDataArray(values: ArrayList<Array<String>>) {
        values.add(arrayOf("Android", "Java", getString(R.string.android), '#' + Integer.toHexString(ContextCompat.getColor(this, R.color.green_900))))
        values.add(arrayOf("iOS", "Swift", getString(R.string.ios), '#' + Integer.toHexString(ContextCompat.getColor(this, R.color.yellow_700))))
        values.add(arrayOf("Xamarin", "C#", getString(R.string.xamarin), '#' + Integer.toHexString(ContextCompat.getColor(this, R.color.pink_700))))
        values.add(arrayOf("PhoneGap", "HTML CSS and JScript", getString(R.string.phonegap), '#' + Integer.toHexString(ContextCompat.getColor(this, R.color.brown_800))))
    }
}
