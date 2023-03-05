package com.example.hw13_2.taskActivity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskViewModel:ViewModel() {
    val name = MutableLiveData<String>()
    val task = MutableLiveData<TaskEnum>()
    val list = MutableLiveData<TaskData>()

}