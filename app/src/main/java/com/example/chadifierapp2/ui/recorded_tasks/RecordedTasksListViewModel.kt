package com.example.chadifierapp2.ui.recorded_tasks

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.chadifierapp2.data.add_task.GenericTaskModel
import com.example.chadifierapp2.data.recorded_tasks.RecordedTasksDataModel
import com.example.chadifierapp2.data.recorded_tasks.RecordedTasksDataRepository

class RecordedTasksListViewModel : ViewModel() {

    private val recordedTasksListRepository: RecordedTasksDataRepository = RecordedTasksDataRepository()

    private var recordedTaskElement : RecordedTasksDataModel  = RecordedTasksDataModel(
        GenericTaskModel("No task", 0, false),
        0,
        false
    )

//    getters and setters
    fun getRecordedTasksListRepository(): RecordedTasksDataRepository {
        return recordedTasksListRepository
    }






//    other methods

}