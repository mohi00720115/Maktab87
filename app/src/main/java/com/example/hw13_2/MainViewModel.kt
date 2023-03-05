package com.example.hw13_2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val name = MutableLiveData<String>()
    val number = MutableLiveData<String>()
    var status = true
    fun check(): String {
        return if (name.value.isNullOrEmpty() || number.value.isNullOrEmpty()) {
            status = false
            "اطلاعاتو وارد کنید"
        } else {
            status = true
            "تکمیل شد"
        }
    }
}