package com.example.chadifierapp2.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.chadifierapp2.R
import com.example.chadifierapp2.databinding.FragmentHomeBinding
import com.example.chadifierapp2.ui.user_profile.ProfileViewModel
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val userProfileViewModel : ProfileViewModel by activityViewModels()



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        findNavController().popBackStack(R.id.navigation_home, false)

        val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root



        val displayChadPoints: TextView = binding.txtHomeUserPoints
        val displayChadLevel: TextView = binding.txtHomeUserLevel
        val displayUsername: TextView = binding.txtHomeUserName


        homeViewModel.uiState.asLiveData().observe(viewLifecycleOwner) {

            displayUsername.text = String.format("${it.username}")
            displayChadPoints.text = String.format("${resources.getString(R.string.label_total_points)} ${it.chadPoints}")
            displayChadLevel.text = String.format("${resources.getString(R.string.label_chad_level)} ${it.chadLevel}")
        }


        val viewModel: HomeViewModel by viewModels()
//        update the elements in the ui when navigating back to this fragment
        viewModel.uiState.value.chadLevel = userProfileViewModel.getUserLevel()
        viewModel.uiState.value.chadPoints = userProfileViewModel.getTotalChadPoints()
        viewModel.uiState.value.username = userProfileViewModel.getUserName()


        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.uiState.collect {
//                  update ui elements
                    displayUsername.text = String.format("${it.username}")
                    displayChadPoints.text = String.format("${resources.getString(R.string.label_total_points)} ${it.chadPoints}")
                    displayChadLevel.text = String.format("${resources.getString(R.string.label_chad_level)} ${it.chadLevel}")
                }

            }
        }


//        button navigate to add new task
        val newTaskButton: Button = binding.btnHomeAddNewTask
        newTaskButton.setOnClickListener{
            findNavController().navigate(R.id.action_navigation_home_to_navigation_new_task)

        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}