package com.kirchhoff.numbervisualizer

import android.os.Bundle
import android.widget.TextView
import com.example.core.ui.BaseActivity
import com.kirchhoff.numbervisualizer.generator.NumberGenerator
import com.kirchhoff.numbervisualizer.view.NumberVisualizerView

class NumberVisualizerActivity : BaseActivity(), NumberGenerator.NumberGeneratorListener {
    override fun getLayoutId() = R.layout.a_number_visualizer

    private lateinit var tvCurrentStep: TextView
    private lateinit var tvCurrentNumber: TextView
    private lateinit var numberVisualizerView: NumberVisualizerView

    private val numberGenerator = NumberGenerator(MAX_NUMBER, INTERVAL, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tvCurrentStep = findViewById(R.id.tvCurrentStep)
        tvCurrentNumber = findViewById(R.id.tvCurrentNumber)
        numberVisualizerView = findViewById(R.id.numberVisualizerView)
        numberVisualizerView.setMaxNumber(MAX_NUMBER)
    }

    override fun onResume() {
        super.onResume()
        numberGenerator.startGenerate()
    }

    override fun onPause() {
        super.onPause()
        numberGenerator.stopGenerate()
    }

    override fun onNewNumber(newNumber: Int, step: Int) {
        tvCurrentStep.text = getString(R.string.current_step_format, step)
        tvCurrentNumber.text = getString(R.string.current_number_format, newNumber)
        numberVisualizerView.newNumber(newNumber)
    }

    companion object {
        private const val MAX_NUMBER = 100
        private const val INTERVAL = 1000L
    }
}
