package com.example.chadifierapp2.ui.task_added

import android.icu.text.MessagePattern.ArgType
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.chadifierapp2.R
import com.example.chadifierapp2.data.recorded_tasks.RecordedTasksDataModel
import com.example.chadifierapp2.databinding.FragmentTaskAddedBinding
import com.example.chadifierapp2.ui.add_task.NewTaskFragment
import com.example.chadifierapp2.ui.add_task.NewTaskViewModel
import com.example.chadifierapp2.ui.recorded_tasks.RecordedTasksListViewModel

//create a fragment for the task added page
class TaskAddedFragment : Fragment() {
//    this fragment will be used to display the task added page
    private var _binding: FragmentTaskAddedBinding? = null

    val binding get() = _binding!!

//    the view model
    private lateinit var taskAddedViewModel: TaskAddedViewModel

//    override the fragment methods
    override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
    ): View {

//        get the view models from the main activity
    val newTaskViewModel : NewTaskViewModel by activityViewModels()
    val recordedTasksListViewModel : RecordedTasksListViewModel by activityViewModels()


//    receive argument task index from the bundle on previous page
        val taskIndex = arguments?.getInt("taskIndex")
//        Log.d("TaskAddedFragmentTaskIndex", "taskIndex: $taskIndex")

//    using the selected task, add the task to the view model using the GenericTaskListRepository
        if (taskIndex != null) {
//          search the task by index and add this task to the recorded tasks list
            val task = newTaskViewModel.getGenericTaskListRepository().getTaskByIndex()
//            to get the points is (multiplier * 100) * abs (1-random) - if chad is true, then add the points, else subtract the points
            val points = ((task.taskCompletionMultiplier * 100) * Math.abs(1 - Math.random()) * if (task.taskIsChad) 1 else -1)
            val pointsRounded = Math.round(points).toInt()
            val recordedTaskDataObj : RecordedTasksDataModel = RecordedTasksDataModel(task, pointsRounded, task.taskIsChad)

//            add the task to the recorded tasks list
            recordedTasksListViewModel.getRecordedTasksListRepository().addRecordedTask(recordedTaskDataObj)
        }



//        inflate the layout for this fragment
        _binding = FragmentTaskAddedBinding.inflate(inflater, container, false)
        val root: View = binding.root

//    finding the button to continue to the next page
        val continueButton = binding.btnContinueToListPrevTasks

//    add click listener to the button
        continueButton.setOnClickListener {

            // Navigate to the recorded task page
            findNavController().navigate(R.id.action_navigation_task_added_to_navigation_list_prev_tasks)
        }


    return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}