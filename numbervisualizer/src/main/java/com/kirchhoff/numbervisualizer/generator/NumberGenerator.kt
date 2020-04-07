package com.kirchhoff.numbervisualizer.generator

import android.os.Handler
import kotlin.random.Random

internal class NumberGenerator(
    private val maxNumber: Int,
    private val interval: Long,
    private val listener: NumberGeneratorListener
) {

    private val handler = Handler()
    private val generatorRunnable = GeneratorRunnable()
    private var currentStep = 0

    fun startGenerate() {
        handler.post(generatorRunnable)
    }

    fun stopGenerate() {
        handler.removeCallbacks(generatorRunnable)
    }

    private inner class GeneratorRunnable : Runnable {
        override fun run() {
            listener.onNewNumber(Random.nextInt(maxNumber), currentStep)
            currentStep += 1
            handler.postDelayed(generatorRunnable, interval)
        }
    }

    internal interface NumberGeneratorListener {
        fun onNewNumber(newNumber: Int, step: Int)
    }
}
