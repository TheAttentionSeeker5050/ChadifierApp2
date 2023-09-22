package com.example.chadifierapp2.ui.recorded_tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chadifierapp2.R
import com.example.chadifierapp2.databinding.FragmentListRecordedTasksBinding

class RecordedTasksListFragment : Fragment() {

    private var _binding: FragmentListRecordedTasksBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val recordedTasksListViewModel: RecordedTasksListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


//        delete all the fragments in the back stack
        findNavController().popBackStack(R.id.navigation_list_prev_tasks, false)

//        inflate binding
        _binding = FragmentListRecordedTasksBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val noRecordedTasksText = binding.recordedTaskNoDataMsg

//        check if there is data in the list to no data text view
        if (recordedTasksListViewModel.getRecordedTaskData().isEmpty()) {
            noRecordedTasksText.visibility = View.VISIBLE
        } else {
            noRecordedTasksText.visibility = View.GONE
        }

////        add text to the no data text view
//        noRecordedTasksText.text = "No recorded tasks yet."


//        get the recycler list in the layout that will hold the items
        val taskListRecyclerView : RecyclerView = binding.rvRecordedTasksList

//        now initiate and bind the adapter
        val taskListItemAdapter = RecordedTaskListItemAdapter(
            recordedTasksListViewModel.getRecordedTaskData(),
            recordedTasksListViewModel
        )

        taskListRecyclerView.adapter = taskListItemAdapter
        taskListRecyclerView.layoutManager =
            LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}