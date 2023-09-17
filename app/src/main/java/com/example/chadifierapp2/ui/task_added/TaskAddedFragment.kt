package com.example.chadifierapp2.ui.task_added

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
<<<<<<< HEAD
=======
import androidx.lifecycle.ViewModelProvider
>>>>>>> fix-bugs
import com.example.chadifierapp2.databinding.FragmentTaskAddedBinding

//create a fragment for the task added page
class TaskAddedFragment : Fragment() {
//    this fragment will be used to display the task added page
    private var _binding: FragmentTaskAddedBinding? = null

    val binding get() = _binding!!

<<<<<<< HEAD
//    the view model
    private lateinit var taskAddedViewModel: TaskAddedViewModel
=======
>>>>>>> fix-bugs

//    override the fragment methods
    override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
    ): View {
<<<<<<< HEAD
=======

        val taskAddedViewModel = ViewModelProvider(this)
            .get(TaskAddedViewModel::class.java)
>>>>>>> fix-bugs
//        inflate the layout for this fragment
        _binding = FragmentTaskAddedBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}