package com.example.chadifierapp2.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chadifierapp2.MainActivity
import com.example.chadifierapp2.data.user_profile.UserDataRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class HomePageState(
    var chadPoints: Int = 0,
    var chadLevel: Int = 1,
)


class HomeViewModel : ViewModel() {



    private val userDataRepository = UserDataRepository("Nicolas")
    private val myChadPoints = userDataRepository.getChadPoints()
    private val myChadLevel = userDataRepository.getChadLevel()



    private val _uiState = MutableStateFlow(HomePageState(
        chadPoints = myChadPoints,
        chadLevel = myChadLevel,
    ))
    val uiState: StateFlow<HomePageState> = _uiState.asStateFlow()





}