package com.example.chadifierapp2.data.recorded_tasks

import android.text.format.DateFormat
import com.example.chadifierapp2.data.add_task.GenericTaskModel
import java.time.format.DateTimeFormatter
import java.util.Date

//create a date time formatter
val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss")
data class RecordedTasksDataModel(
    val genericTask: GenericTaskModel,
    val pointsEarned: Int,
    val taskIsChad: Boolean,
    val date : Date = Date()

)