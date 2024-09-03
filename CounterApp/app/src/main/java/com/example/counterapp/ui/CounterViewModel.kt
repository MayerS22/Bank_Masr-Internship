package com.example.counterapp.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CounterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(0)

    val uiState = _uiState.asStateFlow()


    fun increment() {
        _uiState.update {
            it + 1
        }
    }
}