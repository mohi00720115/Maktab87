package com.example.quizandroid.activity2.doing

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quizandroid.R
import com.example.quizandroid.activity2.RecyclerView
import com.example.quizandroid.activity2.task.TaskData
import com.example.quizandroid.activity2.task.TaskViewModel
import com.example.quizandroid.databinding.FragmentDoingBinding
import com.example.quizandroid.databinding.FragmentSignUpBinding

class DoingFragment : Fragment(R.layout.fragment_doing) {
    private lateinit var binding: FragmentDoingBinding
    val vmDoing : TaskViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.doingViewModel = vmDoing
        //recyclerView
        val adapter = RecyclerView(vmDoing.listDone as ArrayList<TaskData>)
        binding.recyclerViewDoing.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.recyclerViewDoing.adapter = adapter

    }
}