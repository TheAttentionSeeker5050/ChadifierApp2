package com.example.chadifierapp2.ui.recorded_tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RecordedTasksListViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Previous Tasks Fragment"
    }
    val text: LiveData<String> = _text
}