package com.example.chadifierapp2.ui.add_task

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chadifierapp2.R
import com.example.chadifierapp2.data.add_task.GenericTaskModel

class NewTaskListItemAdapter(
    private var taskData: Array<GenericTaskModel>
) : RecyclerView.Adapter<NewTaskListItemAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */

    private var selectedTaskIndex: Int = -1

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        we will reference the text item in the list item blueprint

        val textView: TextView = view.findViewById<TextView>(R.id.txt_new_task_item)


    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.add_new_task_list_item, parent, false)

        Log.d("INFLATE_VIEW_HOLDER", view.toString())
        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    // with the task name in our task items in the repo
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with the task name in this element according to position
        holder.textView.text = taskData[position].taskName

//      add a listener for selecting the task item
        holder.textView.setOnClickListener {textView ->
//          use function to set the listener action
            onClickAction(holder, position)

        }

//        holder.textView.text = "TEXT"
        Log.d("OUTPUT", taskData[position].taskName)
        Log.d("UI", holder.textView.toString())
        Log.d("UI_TEXT", holder.textView.text.toString())

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = taskData.size

//    add a listener action for selecting the task item
    fun onClickAction(holder: ViewHolder, position: Int) {

//        change the background to purple500 and text color to white
        holder.textView.setBackgroundResource(R.color.purple_500)
        holder.textView.setTextColor(Color.WHITE)

//        remove the style from the previously selected item
        if (selectedTaskIndex != -1 && selectedTaskIndex != position) {
//            get the previous view holder by position
            val previousSelectedTaskView = (holder.itemView.parent as RecyclerView)
                .findViewHolderForAdapterPosition(selectedTaskIndex)!!
                .itemView.findViewById<TextView>(R.id.txt_new_task_item)

            previousSelectedTaskView.setBackgroundResource(R.color.white)
            previousSelectedTaskView.setTextColor(Color.BLACK)
        }

//        set the selected task index to the current position
        selectedTaskIndex = position

    }

//    getter for the selected task index
    fun getSelectedTaskIndex(): Int {
        return selectedTaskIndex
    }


}