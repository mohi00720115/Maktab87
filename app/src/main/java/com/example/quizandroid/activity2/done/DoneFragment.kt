package com.example.quizandroid.activity2.done

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.quizandroid.R
import com.example.quizandroid.activity2.RecyclerView
import com.example.quizandroid.activity2.task.TaskData
import com.example.quizandroid.activity2.task.TaskViewModel
import com.example.quizandroid.databinding.FragmentDoingBinding
import com.example.quizandroid.databinding.FragmentDoneBinding

class DoneFragment : Fragment(R.layout.fragment_done) {
    private lateinit var binding: FragmentDoneBinding
    val vmDone : TaskViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.doneViewModel = vmDone

        //recyclerView
        val adapter = RecyclerView(vmDone.listDone as ArrayList<TaskData>)
        binding.recyclerViewDone.adapter = adapter
        binding.recyclerViewDone.layoutManager = GridLayoutManager(requireContext(), 3)


    }
}