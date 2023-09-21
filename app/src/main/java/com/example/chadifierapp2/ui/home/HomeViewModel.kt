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
    var username: String = "User Name",
)


class HomeViewModel : ViewModel() {



//    private val userDataRepository = UserDataRepository("Nicolas")
    private val myChadPoints = 0
    private val myChadLevel = 1
    private val myUsername = "User Name"



    private val _uiState = MutableStateFlow(HomePageState(
        chadPoints = myChadPoints,
        chadLevel = myChadLevel,
        username = myUsername,
    ))
    val uiState: StateFlow<HomePageState> = _uiState.asStateFlow()





}