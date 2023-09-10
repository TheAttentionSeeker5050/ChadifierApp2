package com.example.chadifierapp2.ui.add_task

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewTaskViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is new task Fragment"
    }
    val text: LiveData<String> = _text
}