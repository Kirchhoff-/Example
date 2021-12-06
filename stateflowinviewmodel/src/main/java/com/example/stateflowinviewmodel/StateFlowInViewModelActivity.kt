package com.example.stateflowinviewmodel

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.flow.collect

class StateFlowInViewModelActivity : AppCompatActivity(R.layout.a_state_flow_in_view_model) {

    private lateinit var viewModel: StateFlowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(StateFlowViewModel::class.java)

        val tvValue: TextView = findViewById(R.id.tvValue)
        val tvSquaredValue: TextView = findViewById(R.id.tvSquaredValue)
        val bPlusOne: Button = findViewById(R.id.bPlusOne)

        bPlusOne.setOnClickListener { viewModel.increment() }

        lifecycleScope.launchWhenResumed {
            viewModel.sourceFlow.collect {
                tvValue.text = it.toString()
            }
        }

        lifecycleScope.launchWhenResumed {
            viewModel.transformedFlow.collect {
                tvSquaredValue.text = it.toString()
            }
        }
    }
}
