package com.example.quizandroid.activity2

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.navigation.fragment.NavHostFragment
import com.example.quizandroid.R
import com.example.quizandroid.activity2.doing.DoingFragment
import com.example.quizandroid.activity2.done.DoneFragment
import com.example.quizandroid.activity2.task.TaskFragment
import com.example.quizandroid.activity2.todo.TodoFragment
import com.example.quizandroid.databinding.ActivityTaskBinding

class TaskActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_task)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_task)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.container_view2) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.createTaskFragment -> {
                    navController.navigate(R.id.createTaskFragment)
//                    supportFragmentManager.commit {
//                        setReorderingAllowed(true)
//                        replace<TaskFragment>(R.layout.fragment_create_task)
//                    }
                }
                R.id.todoFragment -> {
                    navController.navigate(R.id.todoFragment)
//                    supportFragmentManager.commit {
//                        setReorderingAllowed(true)
//                        replace<TodoFragment>(R.layout.fragment_todo)
//                    }
                }
                R.id.doingFragment -> {
                    navController.navigate(R.id.doingFragment)
//                    supportFragmentManager.commit {
//                        setReorderingAllowed(true)
//                        replace<DoingFragment>(R.layout.fragment_doing)
//                    }
                }
                R.id.doneFragment -> {
                    navController.navigate(R.id.doneFragment)
//                    supportFragmentManager.commit {
//                        setReorderingAllowed(true)
//                        replace<DoneFragment>(R.layout.fragment_done)
//                    }
                }
            }
            true
        }

    }
}