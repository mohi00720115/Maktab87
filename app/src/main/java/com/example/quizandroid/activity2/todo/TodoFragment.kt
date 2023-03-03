package com.example.quizandroid.activity2.todo

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
import com.example.quizandroid.databinding.FragmentTodoBinding

class TodoFragment : Fragment(R.layout.fragment_todo) {
    private lateinit var binding: FragmentTodoBinding
    val vmTodo : TaskViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.lifecycleOwner = this
        binding.todoViewModel = vmTodo

        //recyclerView
        val adapter = RecyclerView(vmTodo.listDone as ArrayList<TaskData>)
        binding.recyclerViewTodo.layoutManager = GridLayoutManager(requireContext(), 3)
        binding.recyclerViewTodo.adapter = adapter

    }
}