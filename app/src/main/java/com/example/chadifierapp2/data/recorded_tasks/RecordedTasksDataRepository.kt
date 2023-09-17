package com.example.chadifierapp2.data.recorded_tasks

import com.example.chadifierapp2.data.add_task.GenericTaskModel

class RecordedTasksDataRepository (
    val genericTask: GenericTaskModel,
    val pointsEarned: Int,
    val taskIsChad: Boolean,
) {
//    this repository will handle the user profile data transactions, to affect and syncronize the data on the model
//    first create a mutable array of recorded task
    private var recordedTasksData: MutableList<RecordedTasksDataModel> = mutableListOf()


//    getter and setter for recordedTasksData --------------------------------------------------
    fun getGenericTaskByIndex(index: Int = 0) : GenericTaskModel {
        return recordedTasksData[index].genericTask
    }

    fun getPointsEarnedByIndex(index: Int = 0) : Int {
        return recordedTasksData[index].pointsEarned
    }

    fun getTaskIsChadByIndex(index: Int = 0) : Boolean {
        return recordedTasksData[index].taskIsChad
    }

    fun addRecordedTask(recordedTask: RecordedTasksDataModel) {
        recordedTasksData.add(recordedTask)
    }

    fun removeRecordedTaskByIndex(index: Int = 0) {
        recordedTasksData.removeAt(index)
    }


//    other methods to handle the recorded tasks data ------------------------------------------------
    fun fetchRemoteRecordedTasks() {

    }

    fun pullRemoteRecordedTasks() {

    }
}