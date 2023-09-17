package com.example.chadifierapp2.ui.add_task

import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.chadifierapp2.R
import com.example.chadifierapp2.data.add_task.GenericTaskListRepository
import com.example.chadifierapp2.data.add_task.GenericTaskModel

class NewTaskListItemAdapter(
    private var taskData: Array<GenericTaskModel>,
    private var genericTaskListRepository: GenericTaskListRepository,
) : RecyclerView.Adapter<NewTaskListItemAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder)
     */


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//        we will reference the text item in the list item blueprint

        val textView: TextView = view.findViewById<TextView>(R.id.txt_new_task_item)


    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.add_new_task_list_item, parent, false)


        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    // with the task name in our task items in the repo
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get element from your dataset at this position and replace the
        // contents of the view with the task name in this element according to position
        holder.textView.text = taskData[position].taskName

//      add a listener for selecting the task item
        holder.textView.setOnClickListener {
//          use function to set the listener action
            onClickAction(holder, position)

        }

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = taskData.size

//    add a listener action for selecting the task item
    fun onClickAction(holder: ViewHolder, position: Int) {

//        change the background to purple500 and text color to white
        holder.textView.setBackgroundResource(R.color.purple_500)
        holder.textView.setTextColor(Color.WHITE)

//        get the previously selected task index
        val prevSelectedTaskIndex = genericTaskListRepository.getSelectedTaskIndex()
        Log.d("PrevTaskListItemAdapterIndex", "prevSelectedTaskIndex: $prevSelectedTaskIndex")
        Log.d("NewTaskListItemAdapterIndex", "position: $position")

        if (prevSelectedTaskIndex == position) {
            return
        }

//        remove the style from the previously selected item
        if (prevSelectedTaskIndex != -1) {


//            get the previous view holder by position
//            escape if null pointer exception
            val previousSelectedTaskView = (holder.itemView.parent as RecyclerView)
                .findViewHolderForLayoutPosition(prevSelectedTaskIndex)!!
                .itemView.findViewById<TextView>(R.id.txt_new_task_item)



//          set the background to white and text color to black
            previousSelectedTaskView.setBackgroundResource(R.color.white)
            previousSelectedTaskView.setTextColor(Color.BLACK)
        }



//        set the selected task index to the current position
        genericTaskListRepository.setSelectedTaskIndex(position)

    }




}