package com.example.chadifierapp2.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class HomePageState(
    var chadPoints: Int = 0,
    var chadLevel: Int = 1,
)


class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home / new task Fragment"
    }
    val text: LiveData<String> = _text

    private val _uiState = MutableStateFlow(HomePageState())
    val uiState: StateFlow<HomePageState> = _uiState.asStateFlow()

    val displayChadPoints: String = String.format("Amount of Chad Points: {0}", uiState.value.chadPoints)
    val displayChadLevel: String = String.format("Current Chad Level {0}", uiState.value.chadLevel)


}