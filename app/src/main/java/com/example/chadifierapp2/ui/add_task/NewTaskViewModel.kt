package com.example.chadifierapp2.ui.add_task


import androidx.lifecycle.ViewModel
import com.example.chadifierapp2.data.add_task.GenericTaskListRepository
import com.example.chadifierapp2.data.add_task.GenericTaskModel

class NewTaskViewModel : ViewModel() {

    val uiState: Any
        get() = taskList

    private val genericTaskListRepository: GenericTaskListRepository = GenericTaskListRepository()

    val taskList: Array<GenericTaskModel> =
        genericTaskListRepository.getAllTasks()

    fun getGenericTaskListRepository(): GenericTaskListRepository {
        return genericTaskListRepository
    }

    fun getCurrentTask(): GenericTaskModel {
        return genericTaskListRepository.getTaskByIndex()
    }

    fun getTaskByIndex(indexNum: Int): GenericTaskModel {
        return genericTaskListRepository.getTaskByIndex(indexNum)
    }

    fun setSelectedTaskIndex(indexNum: Int) {
        genericTaskListRepository.setSelectedTaskIndex(indexNum)
    }

    fun getSelectedTaskIndex(): Int {
        return genericTaskListRepository.getSelectedTaskIndex()
    }




}