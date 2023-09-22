package com.example.chadifierapp2.ui.task_added

import android.icu.text.MessagePattern.ArgType
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
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
import com.example.chadifierapp2.ui.user_profile.ProfileViewModel

//create a fragment for the task added page
class TaskAddedFragment : Fragment() {
//    this fragment will be used to display the task added page
    private var _binding: FragmentTaskAddedBinding? = null

    val binding get() = _binding!!



    //        get the view models from the main activity
    private val newTaskViewModel : NewTaskViewModel by activityViewModels()
    private val recordedTasksListViewModel : RecordedTasksListViewModel by activityViewModels()
    private val userProfileViewModel : ProfileViewModel by activityViewModels()
    private val taskAddedViewModel : TaskAddedViewModel by activityViewModels()


//    override the fragment methods
    override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
    ): View {
        super.onCreateView(inflater, container, savedInstanceState)


//        get the arguments passed from the previous fragment


        val recordedTaskRepository = recordedTasksListViewModel
            .getRecordedTasksListRepository()


//        inflate the layout for this fragment
        _binding = FragmentTaskAddedBinding.inflate(inflater, container, false)
        val root: View = binding.root

//    display the results in the layout
//    get the element in the Fragment by id
        var msgPointsEarned = binding.txtPointsEarned
        var msgChadLevel = binding.txtCurrentLevel
        var msgTotalPoints = binding.txtTotalPoints


//    userProfileViewModel.addChadPoints(recordedTaskRepository.getRecordedTasksData().last().pointsEarned)
        userProfileViewModel.addChadPoints(taskAddedViewModel.getPointsEarned())

//    change the contents of the text views using string resources
//        msgPointsEarned.text = "Points Earned: "+ recordedTaskRepository.getRecordedTasksData().last().pointsEarned
        msgPointsEarned.text = resources.getString(R.string.label_points_earned) + taskAddedViewModel.getPointsEarned().toString()
        msgChadLevel.text = resources.getString(R.string.label_chad_level) + userProfileViewModel.getUserLevel().toString()
        msgTotalPoints.text = resources.getString(R.string.label_total_points) + userProfileViewModel.getTotalChadPoints().toString()

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