package com.example.lazybind

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.lazybind.extensions.bindView

class LazyBindActivity : AppCompatActivity() {

    private val tvFirst by bindView<TextView>(R.id.tvFirst)
    private val tvSecond: TextView by bindView(R.id.tvSecond)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.a_lazy_bind)

        tvFirst.setText(R.string.first_text)
        tvSecond.setText(R.string.second_text)
    }
}
