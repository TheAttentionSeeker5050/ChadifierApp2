package com.example.chadifierapp2.ui.add_task

import android.util.Log
import android.widget.Button
import com.example.chadifierapp2.data.add_task.GenericTaskListRepository

fun  addTaskButtonOnClickAction(

    genericTaskListRepository: GenericTaskListRepository,
) {

//    get the selected task index
    val selectedTaskIndex = genericTaskListRepository.getSelectedTaskIndex()

//    if the selected task index is not -1, perform add action
    if (selectedTaskIndex != -1) {
        val taskSelected = genericTaskListRepository.getTaskByIndex(selectedTaskIndex)
        Log.i("NewTaskFragment", "Task selected: ${taskSelected.taskName}")
    }

}