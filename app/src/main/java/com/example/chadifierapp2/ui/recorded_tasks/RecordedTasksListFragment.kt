package com.example.chadifierapp2.ui.recorded_tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
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


        _binding = FragmentListRecordedTasksBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textListRecTasks
        recordedTasksListViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }


        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}