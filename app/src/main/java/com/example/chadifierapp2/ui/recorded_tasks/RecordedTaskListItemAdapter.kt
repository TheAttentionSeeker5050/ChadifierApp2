package com.example.chadifierapp2.ui.recorded_tasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chadifierapp2.R
import com.example.chadifierapp2.data.recorded_tasks.RecordedTasksDataModel
import com.example.chadifierapp2.utils.FormattingTools
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import kotlin.time.Duration.Companion.hours
import kotlin.time.Duration.Companion.minutes

class RecordedTaskListItemAdapter(
    private var recordedTaskData: MutableList<RecordedTasksDataModel>,
    private var recordedTasksListViewModel: RecordedTasksListViewModel,
): RecyclerView.Adapter<RecordedTaskListItemAdapter.ViewHolder>() {



    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        here we will reference the components of the item
//        fragment that we want to add custom data to
        val taskItemNameView = view.findViewById<TextView>(R.id.txt_recorded_task_item__name)
//        this will contain the points earned and the date
        val taskSubTextView = view.findViewById<TextView>(R.id.txt_recorded_task_item__subtext)

    }

//    override methods
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        this will create a new list element and inflate into the recycler view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.recorded_task_list_item, parent, false)

        return ViewHolder(view)
    }

//    replace whatever contents of the list items populated with the contents in
//    the view model
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        date has to be formatted in MM/DD/YYYY HH:MM in string data type

//        use formatting tools to format the date
        val formattedDate : String = FormattingTools.myFormatDateTime(recordedTaskData[position].date)

//        val formattedDate : String = recordedTaskData[position].date.toString()
        holder.taskItemNameView.text = recordedTaskData[position].genericTask.taskName
        holder.taskSubTextView.text = "${recordedTaskData[position].pointsEarned} points on ${formattedDate}"

//    add the button listeners
    }

    override fun getItemCount(): Int = recordedTaskData.size
}