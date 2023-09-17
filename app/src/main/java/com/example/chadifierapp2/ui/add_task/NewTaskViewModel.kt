package com.example.chadifierapp2.ui.add_task


import androidx.lifecycle.ViewModel
import com.example.chadifierapp2.data.add_task.GenericTaskListRepository
import com.example.chadifierapp2.data.add_task.GenericTaskModel

class NewTaskViewModel : ViewModel() {

    private val genericTaskListRepository: GenericTaskListRepository = GenericTaskListRepository()

    val taskList: Array<GenericTaskModel> =
        genericTaskListRepository.getAllTasks()

    fun getGenericTaskListRepository(): GenericTaskListRepository {
        return genericTaskListRepository
    }



}