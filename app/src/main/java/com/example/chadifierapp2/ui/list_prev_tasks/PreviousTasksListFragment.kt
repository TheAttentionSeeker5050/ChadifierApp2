package com.example.chadifierapp2.ui.list_prev_tasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.chadifierapp2.databinding.FragmentListRecordedTasksBinding

class PreviousTasksListFragment : Fragment() {

    private var _binding: FragmentListRecordedTasksBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val prevTasksListViewModel =
            ViewModelProvider(this).get(PreviousTasksListViewModel::class.java)

        _binding = FragmentListRecordedTasksBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textListRecTasks
        prevTasksListViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}