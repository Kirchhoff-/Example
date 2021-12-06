package com.example.stateflowinviewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map

class StateFlowViewModel : ViewModel() {

    private val _sourceFlow = MutableStateFlow(0)
    val sourceFlow: StateFlow<Int> = _sourceFlow

    private val _transformedFlow = _sourceFlow.map { it * it }
    val transformedFlow: Flow<Int> = _transformedFlow

    fun increment() {
        _sourceFlow.value = _sourceFlow.value + 1
    }
}
