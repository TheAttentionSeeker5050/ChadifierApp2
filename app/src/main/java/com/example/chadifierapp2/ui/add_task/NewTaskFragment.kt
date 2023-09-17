package com.example.chadifierapp2.ui.add_task

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavType
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chadifierapp2.R
import com.example.chadifierapp2.data.add_task.GenericTaskModel
import com.example.chadifierapp2.databinding.FragmentAddNewTaskBinding
import java.io.Serializable

class NewTaskFragment : Fragment() {

    private var _binding: FragmentAddNewTaskBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val newTaskViewModel =
            ViewModelProvider(this).get(NewTaskViewModel::class.java)


        _binding = FragmentAddNewTaskBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        get the list in the layout that will hold the items
        val recyclerView: RecyclerView = binding.rvRecyclerView

        // populate the recycler view elements using adapter
        val listItemsAdapter = NewTaskListItemAdapter(newTaskViewModel.taskList, newTaskViewModel.getGenericTaskListRepository())
        recyclerView.adapter = listItemsAdapter
        recyclerView.layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)

//        get the add button
        val recordTaskButton: Button = binding.btnAddNewTask

//        add click listener to the button
        recordTaskButton.setOnClickListener {


            //    get the selected task index
            val selectedTaskIndex = newTaskViewModel.getGenericTaskListRepository()
                .getSelectedTaskIndex()


            //    if the selected task index is not -1, perform add action
            if (selectedTaskIndex != -1) {
                val taskSelected = newTaskViewModel.getGenericTaskListRepository()
                    .getTaskByIndex(selectedTaskIndex)
                Log.i("NewTaskFragment", "Task selected: ${taskSelected.taskName}")



                //        navigate to the next fragment
                //        next fragment is task added fragment, and bundle up the task index as argument
                val bundle = Bundle()
                bundle.putInt("taskIndex", selectedTaskIndex)
                findNavController().navigate(R.id.action_navigation_new_task_to_navigation_task_added, bundle)

            }

        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}