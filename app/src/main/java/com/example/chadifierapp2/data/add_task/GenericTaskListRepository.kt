package com.example.chadifierapp2.data.add_task

class GenericTaskListRepository {

//    declare the task list, which most of the time will be inmutable, but well see
    private val taskList: ArrayList<GenericTaskModel> = genericTaskList

//    getter and setters methods
    fun getAllTasks(): ArrayList<GenericTaskModel> {
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

//    other methods
}