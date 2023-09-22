package com.example.chadifierapp2.ui.recorded_tasks

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
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

//        buttons
        val btnEditTask = view.findViewById<ImageButton>(R.id.btn_recorded_task_item__edit)
        val btnDeleteTask = view.findViewById<ImageButton>(R.id.btn_recorded_task_item__delete)
        val rootLayout = view.findViewById<ViewGroup>(R.id.lo_recorded_task_item__root)
        var initialX = 0f


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
    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        date has to be formatted in MM/DD/YYYY HH:MM in string data type

//        use formatting tools to format the date
        val formattedDate : String = FormattingTools.myFormatDateTime(recordedTaskData[position].date)

//        val formattedDate : String = recordedTaskData[position].date.toString()
        holder.taskItemNameView.text = recordedTaskData[position].genericTask.taskName
        holder.taskSubTextView.text = "${recordedTaskData[position].pointsEarned} points on ${formattedDate}"

//    add the button listeners
//    I want to design a strategy where the user will be punished
//    for deleting or editing task
//    I will work on this later
        holder.btnEditTask.setOnClickListener {
            Log.d("RecordedTaskListItemAdapter", "Edit button clicked")
        }

        holder.btnDeleteTask.setOnClickListener {
            Log.d("RecordedTaskListItemAdapter", "Delete button clicked")
        }

//    make this global variable
//    an action listener for swipe right, will work on this.
//    It will delete the task, but Im working on this functionality
//    which makes part of the delete/edit features above
        holder.rootLayout.setOnTouchListener(View.OnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    holder.initialX = event.x
                    return@OnTouchListener true
                }
                MotionEvent.ACTION_MOVE -> {
                    // Check if moved right
                    if (event.x - holder.initialX > 0) {
                        Log.d("RecordedTaskListItemAdapter", "swiping right")
                    }
                    return@OnTouchListener true
                }
                MotionEvent.ACTION_UP -> {
                    // Check if swiped right
                    if (event.x - holder.initialX > 0) {
                        Log.d("RecordedTaskListItemAdapter", "swiped right")
                    }
                    return@OnTouchListener true
                }
                else -> {
                    Log.d("RecordedTaskListItemAdapter", "Nothing happened")
                    return@OnTouchListener false
                }
            }
            view.performClick()
            return@OnTouchListener true
        })
    }

    override fun getItemCount(): Int = recordedTaskData.size
}