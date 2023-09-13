package com.example.chadifierapp2.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.chadifierapp2.R
import com.example.chadifierapp2.databinding.FragmentHomeBinding
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.txtHomeUserLevel
//        profileViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        val displayChadPoints: TextView = binding.txtHomeUserPoints
        val displayChadLevel: TextView = binding.txtHomeUserLevel
        homeViewModel.uiState.asLiveData().observe(viewLifecycleOwner) {
            displayChadPoints.text = String.format("Amount of Chad Points: ${it.chadPoints}")
            displayChadLevel.text = String.format("Current Chad Level ${it.chadLevel}")
        }

        val viewModel: HomeViewModel by viewModels()
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.uiState.collect {
//                  update ui elements

                }

            }
        }


//        button navigate to add new task
        val newTaskButton: Button = binding.btnHomeAddNewTask
        newTaskButton.setOnClickListener{
//            Log.d("BUTTONS", "Clicked on the new task button")
            findNavController().navigate(R.id.action_navigation_home_to_navigation_new_task)

        }





        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}