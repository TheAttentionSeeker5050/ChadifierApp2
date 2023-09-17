package com.example.chadifierapp2.data.add_task

class GenericTaskListRepository {

//    declare the task list, which most of the time will be inmutable, but well see
    private val taskList: Array<GenericTaskModel> = genericTaskList
    private var selectedTaskIndex: Int = -1

//    getter and setters methods
    fun getAllTasks(): Array<GenericTaskModel> {
        return taskList
    }


    fun getTaskByIndex(indexNum: Int): GenericTaskModel {
        val task = taskList.getOrNull(indexNum)
        if (task != null) {
            return task
        } else {
            return GenericTaskModel("Error: Task not found", 1, false)
        }
    }


// for the selected task index, set the taskIsSelected to true
    fun setSelectedTaskIndex(indexNum: Int) {
        selectedTaskIndex = indexNum
    }

    fun getSelectedTaskIndex(): Int {
        return selectedTaskIndex
    }

//    other methods
}