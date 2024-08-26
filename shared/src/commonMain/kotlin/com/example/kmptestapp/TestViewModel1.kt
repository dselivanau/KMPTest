package com.example.kmptestapp

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TestViewModel1 {

    private val _state = MutableStateFlow(0)
    val state = _state.asStateFlow()

    fun increaseCount() {
        _state.value += 1
    }
}