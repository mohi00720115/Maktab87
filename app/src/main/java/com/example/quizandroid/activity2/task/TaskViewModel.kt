package com.example.quizandroid.activity2.task

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {

    val taskName = MutableLiveData<String>()
    val taskSubject = MutableLiveData<String>()
    val taskDate = MutableLiveData<String>()
    private lateinit var status: StateEnum

    val listTodo = mutableListOf<TaskData>()
    val listDoing = mutableListOf<TaskData>()
    val listDone = mutableListOf<TaskData>()

    fun initializeStatusTodo() {
        status = StateEnum.TODO
    }

    fun initializeStatusDoing() {
        status = StateEnum.DOING
    }

    fun initializeStatusDone() {
        status = StateEnum.DONE
    }

    fun createTask(): String {
        return if (taskName.value != "" && taskSubject.value != "" && taskDate.value != "") {
            when (status) {
                StateEnum.TODO -> {
                    listTodo.add(TaskData(taskName.value!!, taskSubject.value!!, taskDate.value!!))
                }
                StateEnum.DOING -> {
                    listDoing.add(TaskData(taskName.value!!, taskSubject.value!!, taskDate.value!!))
                }
                StateEnum.DONE -> {
                    listDone.add(TaskData(taskName.value!!, taskSubject.value!!, taskDate.value!!))
                }
            }
            "ساخته شد"
        } else {
            "اطلاعات را کامل کنید"
        }
    }

    fun clear() {
        taskName.value = ""
        taskSubject.value = ""
        taskDate.value = ""
    }

}