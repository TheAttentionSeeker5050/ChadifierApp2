package com.example.chadifierapp2.ui.add_task

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chadifierapp2.databinding.FragmentAddNewTaskBinding

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


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}