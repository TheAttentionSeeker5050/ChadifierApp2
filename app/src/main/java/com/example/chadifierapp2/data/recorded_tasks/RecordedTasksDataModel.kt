package com.example.chadifierapp2.data.recorded_tasks

import com.example.chadifierapp2.data.add_task.GenericTaskModel

data class RecordedTasksDataModel(
    val genericTask: GenericTaskModel,
    val pointsEarned: Int,
    val taskIsChad: Boolean,

)