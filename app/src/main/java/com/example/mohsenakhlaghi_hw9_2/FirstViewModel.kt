package com.example.mohsenakhlaghi_hw9_2

import android.content.ContentValues.TAG
import android.text.TextUtils.isEmpty
import android.util.Log
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstViewModel : ViewModel() {
    var fullName = ""
    var userName = ""
    var email = ""
    var password = ""
    var rePassword = ""
    var radioMale = false
    var radioFeMale = false

    fun check(): String {
        val list = mutableListOf(fullName, userName, email, password, rePassword)
        return if (list.any { it.isEmpty() }) {
            "اطلاعات اشتباه است"
        } else if (!radioMale && !radioFeMale) {
            "جنسیت را انتخاب کنید"
        } else if (password != rePassword) {
            "رمز و تکرار رمز یکسان نیست!"
        } else "اطلاعات منتقل شد"


    }

}