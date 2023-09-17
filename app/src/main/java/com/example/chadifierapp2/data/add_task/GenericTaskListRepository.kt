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
        if (indexNum>0 && taskList.size > indexNum) {
            return taskList.get(indexNum)
        } else {
            return GenericTaskModel(
                "Task not found", 1, false
            )
        }
    }


// for the selected task index, set the taskIsSelected to true
    fun setSelectedTaskIndex(indexNum: Int) {
        if (indexNum>0 && taskList.size > indexNum) {
            selectedTaskIndex = indexNum
        } else {
            selectedTaskIndex = -1
        }
    }

    fun getSelectedTaskIndex(): Int {
        return selectedTaskIndex
    }

//    other methods
}