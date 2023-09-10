package com.example.chadifierapp2.ui.user_profile

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ProfileViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is User Profile Fragment"
    }
    val text: LiveData<String> = _text
}