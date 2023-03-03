package com.example.quizandroid.activity2.task

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quizandroid.R
import com.example.quizandroid.activity2.RecyclerView
import com.example.quizandroid.databinding.FragmentCreateTaskBinding
import com.example.quizandroid.databinding.FragmentDoingBinding

class TaskFragment : Fragment(R.layout.fragment_create_task) {
    private lateinit var binding: FragmentCreateTaskBinding
    val vmTask: TaskViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!          //باید بنویسیش
        binding.lifecycleOwner = this                   //باید بنویسیش
        binding.viewModelTask = vmTask                  //باید بنویسیش


        binding.btnClick.setOnClickListener {
            when {
                binding.radioTodo.isChecked -> {
                    vmTask.initializeStatusTodo()
                    Toast.makeText(requireContext(), vmTask.createTask(), Toast.LENGTH_SHORT).show()
//                    vmTask.createTask()
                }
                binding.radioDoing.isChecked -> {
                    vmTask.initializeStatusDoing()
                    Toast.makeText(requireContext(), vmTask.createTask(), Toast.LENGTH_SHORT).show()
//                    vmTask.createTask()
                }
                binding.radioDone.isChecked -> {
                    vmTask.initializeStatusDone()
                    Toast.makeText(requireContext(), vmTask.createTask(), Toast.LENGTH_SHORT).show()

                }
            }
        }


    }
}