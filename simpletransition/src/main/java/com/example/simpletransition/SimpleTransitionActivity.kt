package com.example.simpletransition

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat

class SimpleTransitionActivity : AppCompatActivity(R.layout.a_simple_transition) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val values = createData()

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

    private fun createData(): List<TransitionItem> {
        return listOf(TransitionItem("Android", "Java", getString(R.string.android), R.color.green_900),
                TransitionItem("iOS", "Swift", getString(R.string.ios), R.color.yellow_700),
                TransitionItem("Xamarin", "C#", getString(R.string.xamarin), R.color.pink_700),
                TransitionItem("PhoneGap", "HTML CSS and JScript", getString(R.string.phonegap), R.color.brown_800))
    }
}
