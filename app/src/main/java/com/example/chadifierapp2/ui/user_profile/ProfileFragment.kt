package com.example.chadifierapp2.ui.user_profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.example.chadifierapp2.R
import com.example.chadifierapp2.databinding.FragmentProfileBinding
import com.example.chadifierapp2.ui.recorded_tasks.RecordedTasksListViewModel

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val profileViewModel: ProfileViewModel by activityViewModels()
    private val recordedTasksListViewModel: RecordedTasksListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val userTextView: TextView = binding.txtProfileUserName
        val deleteLastWeekEntriesButton: TextView = binding.btnProfileDeleteLastWeekEntries
        val confirmMsgTextView: TextView = binding.txtProfileDeleteMsg
        val confirmDeleteLWEntriesLayout: LinearLayout = binding.llProfileDeleteLastWeekEntriesButtons
        val confirmDeleteLWEntriesButtonYes: Button = binding.btnProfileDeleteLastWeekEntriesYes
        val confirmDeleteLWEntriesButtonNo: Button = binding.btnProfileDeleteLastWeekEntriesNo

//        show the message and the yes and no buttons
//        to confirm the deletion of the last week entries
        deleteLastWeekEntriesButton.setOnClickListener {
//            show message
            confirmMsgTextView.text = resources.getString(R.string.recorded_tasks_confirm_delete)
            confirmMsgTextView.visibility = View.VISIBLE
            confirmDeleteLWEntriesLayout.visibility = View.VISIBLE

            Log.d("ProfileFragment", "Clicked on delete last week entries button")
        }

//        if the user clicks on the yes button, delete the last week entries
        confirmDeleteLWEntriesButtonYes.setOnClickListener {
            recordedTasksListViewModel.deleteLastWeekEntries()
            confirmMsgTextView.text = resources.getString(R.string.recorded_tasks_deleted)
            confirmDeleteLWEntriesLayout.visibility = View.GONE

//            after 4 seconds, hide the message
            confirmMsgTextView.postDelayed({
                confirmMsgTextView.visibility = View.GONE
            }, 4000)
        }

//        if the user clicks on the no button, hide the message
        confirmDeleteLWEntriesButtonNo.setOnClickListener {
            confirmMsgTextView.visibility = View.GONE
            confirmDeleteLWEntriesLayout.visibility = View.GONE
        }

//        change the text of the text view to the user name
        userTextView.text = profileViewModel.getUserName()



        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}