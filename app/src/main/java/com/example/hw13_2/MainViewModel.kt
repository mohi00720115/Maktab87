package com.example.hw13_2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val name = MutableLiveData<String>()
    val numberOfTask = MutableLiveData<String>()
    var status = true

    /**
     * این تابع چک می کنه که مقادیر نام و تسک خالی نباشد
     */
    fun check(): String {
        return if (name.value.isNullOrEmpty() || numberOfTask.value.isNullOrEmpty()) {
            status = false
            "اطلاعاتو وارد کنید"
        } else {
            status = true
            "تکمیل شد"
        }
    }
}