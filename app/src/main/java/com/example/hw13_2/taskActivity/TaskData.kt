package com.example.hw13_2.taskActivity

data class TaskData(val name: String, val task: TaskEnum)

enum class TaskEnum{
    TODO,DOING,DONE
}