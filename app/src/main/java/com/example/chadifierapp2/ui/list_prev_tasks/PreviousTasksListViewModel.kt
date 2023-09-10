package com.example.chadifierapp2.ui.list_prev_tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PreviousTasksListViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Previous Tasks Fragment"
    }
    val text: LiveData<String> = _text
}