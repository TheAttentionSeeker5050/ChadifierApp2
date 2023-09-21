package com.example.chadifierapp2.ui.user_profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chadifierapp2.data.user_profile.UserDataRepository

class ProfileViewModel : ViewModel() {

    private val userDataRepository: UserDataRepository = UserDataRepository("User Name")

    fun getUserDataRepository(): UserDataRepository {
        return userDataRepository
    }

    fun getUserName(): String {
        return userDataRepository.getUserName()
    }

    fun checkLevel() {
        userDataRepository.checkUserLevel()
    }

    fun addChadPoints(numPoints: Int) {
        userDataRepository.addChadPoints(numPoints)
    }


    fun getUserLevel(): Int {
        return userDataRepository.getUserLevel()
    }

    fun getTotalChadPoints(): Int {
        return userDataRepository.getChadPoints()
    }

}