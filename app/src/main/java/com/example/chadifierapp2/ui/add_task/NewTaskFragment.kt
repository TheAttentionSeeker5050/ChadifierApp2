package com.example.chadifierapp2.ui.add_task

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chadifierapp2.databinding.FragmentAddNewTaskBinding
import kotlinx.coroutines.launch

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

        val viewModel: NewTaskViewModel by viewModels()




//        add click listener to the button
        recordTaskButton.setOnClickListener {
            addTaskButtonOnClickAction(
                newTaskViewModel.getGenericTaskListRepository()
            )
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}