package com.example.hw13_2.taskActivity

import android.content.ContentValues.TAG
import android.content.res.Configuration
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.hw13_2.R
import com.example.hw13_2.databinding.FragmentTaskBinding
import java.lang.NullPointerException


class TaskFragment : Fragment(R.layout.fragment_task) {
    private lateinit var binding: FragmentTaskBinding
    val vmTask: TaskViewModel by viewModels()
    private var numberOfTask = 0
    private var nameExtra = ""
    private val createListItems = arrayListOf<TaskData>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
//        binding.lifecycleOwner = this
//        binding.viewModelTask = vmTask

        try {
            nameExtra = arguments?.getString("NAME_EXTRA").toString()
            numberOfTask = arguments?.getInt("NUMBER_OF_TASK")!!
            Log.e(TAG, "nameExtra22: ${arguments?.getString("NAME_EXTRA").toString()}")
            Log.e(TAG, "numberOfTask22: ${arguments?.getInt("NUMBER_OF_TASK")}")

        } catch (e: NullPointerException) {
            Log.e(TAG, "nameExtraCATCH: ${arguments?.getString("NAME_EXTRA").toString()}")
            Log.e(TAG, "numberOfTaskCATCH: ${arguments?.getInt("NUMBER_OF_TASK")}")
        }


        //recyclerView
        val adapter = RecyclerTask(createTaskList())
        binding.recyclerViewTask.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.recyclerViewTask.adapter = adapter

        binding.btnAdd.setOnClickListener {
            createListItems.add(TaskData(nameExtra, randomStatus()))
            adapter.notifyDataSetChanged()

        }


    }

    /**
     * برای مدیریت تغییر تعداد آیتم های ریسایکلر در حالات چرخش صفحه
     */
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (newConfig.orientation == 2) {
            binding.recyclerViewTask.layoutManager = GridLayoutManager(requireContext(), 3)
        } else {
            binding.recyclerViewTask.layoutManager = GridLayoutManager(requireContext(), 1)
        }
    }

    /**
     * نمایش تسک ها به صورت رندوم
     */
    private fun randomStatus(): TaskEnum {
        return TaskEnum.values().random()
    }

    /**
     * پاس دادن آیتم های مورد نیاز برای ریسایکلرویو
     */
    private fun createTaskList(): ArrayList<TaskData> {
        for (i in 0 until numberOfTask) {
            createListItems.add(TaskData(nameExtra, randomStatus()))
        }
        return createListItems
    }
}
