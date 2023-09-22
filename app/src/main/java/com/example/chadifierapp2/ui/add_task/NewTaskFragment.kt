package com.example.chadifierapp2.ui.add_task

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chadifierapp2.R
import com.example.chadifierapp2.data.add_task.GenericTaskModel
import com.example.chadifierapp2.data.recorded_tasks.RecordedTasksDataModel
import com.example.chadifierapp2.databinding.FragmentAddNewTaskBinding
import com.example.chadifierapp2.ui.recorded_tasks.RecordedTasksListViewModel
import com.example.chadifierapp2.ui.task_added.TaskAddedViewModel

class NewTaskFragment : Fragment() {

    private var _binding: FragmentAddNewTaskBinding? = null
    private val binding get() = _binding!!


    //        get the view model from the main activity
    // Declare ViewModels here to make them accessible throughout the fragment
    private val newTaskViewModel: NewTaskViewModel by activityViewModels()
    private val recordedTasksListViewModel: RecordedTasksListViewModel by activityViewModels()
    private val taskAddedViewModel: TaskAddedViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAddNewTaskBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        get the list in the layout that will hold the items
        val recyclerView: RecyclerView = binding.rvRecyclerView

        // populate the recycler view elements using adapter
        val listItemsAdapter =
            NewTaskListItemAdapter(
                newTaskViewModel.taskList,
                newTaskViewModel.getGenericTaskListRepository()
            )
        recyclerView.adapter = listItemsAdapter
        recyclerView.layoutManager =
            LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)

//        get the add button
        val recordTaskButton: Button = binding.btnAddNewTask

//        add click listener to the button
        recordTaskButton.setOnClickListener {


            //    get the selected task index
            val selectedTaskIndex = newTaskViewModel.getSelectedTaskIndex()


            //    if the selected task index is not -1, perform add action
            if (selectedTaskIndex != -1) {
//                get the task selected
                val taskSelected = newTaskViewModel.getTaskByIndex(selectedTaskIndex)


//                get the points earned
                val pointsEarned = calculatePoints(taskSelected)

//                save the points into the task added view model
                taskAddedViewModel.setPointsEarned(pointsEarned)


//                build recorded task data object
                val recordedTaskDataObj : RecordedTasksDataModel =
                    RecordedTasksDataModel(taskSelected, pointsEarned, taskSelected.taskIsChad)


//                add the recorded task to the recorded task list view model
                recordedTasksListViewModel.addRecordedTask(recordedTaskDataObj)


                findNavController()
                    .navigate(R.id.action_navigation_new_task_to_navigation_task_added)

            }

        }

        return root
    }

    fun calculatePoints(task: GenericTaskModel): Int {
        return Math.round((task.taskCompletionMultiplier * 100) * Math.abs(1 - Math.random()) * if (task.taskIsChad) 1 else -1).toInt()
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}