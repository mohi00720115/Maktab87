package com.example.mohsenakhlaghi_hw9_2

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondViewModel : ViewModel() {
    var fullName = ""
    var userName = ""
    var email = ""
    var password = ""
    var rePassword = ""
    private val list = mutableListOf(fullName, userName, email, password, rePassword)

}