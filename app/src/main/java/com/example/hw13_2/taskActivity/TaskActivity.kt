package com.example.hw13_2.taskActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.hw13_2.MainActivity.Companion.NAME_KEY
import com.example.hw13_2.MainActivity.Companion.TASK_NUM_KEY
import com.example.hw13_2.R
import com.example.hw13_2.databinding.ActivityTaskBinding

class TaskActivity : AppCompatActivity() {
    companion object {
        const val NAME_EXTRA = "NAME_EXTRA"
        const val NUMBER_OF_TASK_EXTRA = "NUMBER_OF_TASK"
    }

    private lateinit var binding: ActivityTaskBinding
    private val vmTask: TaskViewModel by viewModels()
    private var numberOfTask = 0
    private var nameExtra = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_task)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_task)

        nameExtra = intent.getStringExtra(NAME_KEY).toString()
        numberOfTask = intent.getIntExtra(TASK_NUM_KEY, 0)

        supportFragmentManager.commit {
            val bundle = bundleOf(NAME_EXTRA to nameExtra, NUMBER_OF_TASK_EXTRA to numberOfTask)
            setReorderingAllowed(true)
            replace<TaskFragment>(R.id.container_view, args = bundle)
        }

    }
}