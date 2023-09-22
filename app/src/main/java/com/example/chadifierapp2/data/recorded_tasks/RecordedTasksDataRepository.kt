package com.example.chadifierapp2.data.recorded_tasks

import android.text.format.DateUtils
import com.example.chadifierapp2.data.add_task.GenericTaskModel
import java.util.Date

class RecordedTasksDataRepository (

) {
//    this repository will handle the user profile data transactions, to affect and syncronize the data on the model
//    first create a mutable array of recorded task
    private var recordedTasksData: MutableList<RecordedTasksDataModel> = mutableListOf()

//    constructor
    init {

//        create a dummy data, for testing purposes
        val myRecordedGenericTask =  RecordedTasksDataModel(
                genericTask = GenericTaskModel("Old task #", 2, false),
                pointsEarned = 0,
                taskIsChad = false,
//            date in today of last year
                date = Date(Date().time - DateUtils.YEAR_IN_MILLIS)
            )

//    add the dummy data to the recorded tasks data
        recordedTasksData.add(myRecordedGenericTask)
        recordedTasksData.add(myRecordedGenericTask)
        recordedTasksData.add(myRecordedGenericTask)
        recordedTasksData.add(myRecordedGenericTask)
        recordedTasksData.add(myRecordedGenericTask)
        recordedTasksData.add(myRecordedGenericTask)
        recordedTasksData.add(myRecordedGenericTask)
        recordedTasksData.add(myRecordedGenericTask)
        recordedTasksData.add(myRecordedGenericTask)
        recordedTasksData.add(myRecordedGenericTask)
        recordedTasksData.add(myRecordedGenericTask)
    }


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

    fun getRecordedTasksData() : MutableList<RecordedTasksDataModel> {
        return recordedTasksData
    }

    fun editTaskByIndex(newRecordedTask: RecordedTasksDataModel, index: Int = 0) {
        recordedTasksData[index] = newRecordedTask
    }

    fun deleteLastWeekEntries() {
//        delete all the entries that are older than a week starting from today at 00:00
//        get the date of today
        val today = Date()
//        get cutout times at midnight
        val oneWeekAgo = Date(today.time - DateUtils.WEEK_IN_MILLIS)
        val oneWeekAgoAtMidnight = Date(oneWeekAgo.year, oneWeekAgo.month, oneWeekAgo.date)
        val oneWeekAgoAtMidnightTime = oneWeekAgoAtMidnight.time


//        create a copy of the recorded tasks data to iterate through
        val recordedTasksDataCopy = recordedTasksData.toMutableList()

//        iterate through the recorded tasks data
        for (recordedTask in recordedTasksDataCopy) {
//            if the recorded task date is older than a week ago at midnight,
//            remove it from the recorded tasks data
//            this will remove it from the original recorded tasks data in the repo
            if (recordedTask.date.time < oneWeekAgoAtMidnightTime) {
                recordedTasksData.remove(recordedTask)
            }
        }
    }


//    other methods to handle the recorded tasks data ------------------------------------------------
    fun fetchRemoteRecordedTasks() {

    }

    fun pullRemoteRecordedTasks() {

    }
}