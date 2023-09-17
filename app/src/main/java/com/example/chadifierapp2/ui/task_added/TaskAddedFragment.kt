package com.example.chadifierapp2.ui.task_added

import android.icu.text.MessagePattern.ArgType
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.chadifierapp2.R
import com.example.chadifierapp2.databinding.FragmentTaskAddedBinding
import com.example.chadifierapp2.ui.add_task.NewTaskFragment
import com.example.chadifierapp2.ui.add_task.NewTaskViewModel

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



//    receive argument task index from the bundle on previous page
        val taskIndex = arguments?.getInt("taskIndex")
//        Log.d("TaskAddedFragmentTaskIndex", "taskIndex: $taskIndex")

//    using the selected task, add the task to the view model using the GenericTaskListRepository
        if (taskIndex != null) {

        }



//        inflate the layout for this fragment
        _binding = FragmentTaskAddedBinding.inflate(inflater, container, false)
        val root: View = binding.root

//    finding the button to continue to the next page
        val continueButton = binding.btnContinueToListPrevTasks

//    add click listener to the button
        continueButton.setOnClickListener {
//        navigate to the next page
            findNavController().navigate(R.id.action_navigation_task_added_to_navigation_list_prev_tasks)
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}