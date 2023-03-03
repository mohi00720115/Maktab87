package com.example.quizandroid.activity1.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    val name = MutableLiveData<String>()
    val pass = MutableLiveData<String>()

/*    private val showMessage = MutableLiveData<String>()

    fun checkText() {
        if (name.value?.isEmpty() == true) {
            showMessage.value = "نام کاربری را وارد کنید"
        } else {
            showMessage.value = ""
        }
    }*/

}