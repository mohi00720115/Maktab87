package com.example.mohsenakhlaghi_hw9

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstFragmentViewModel : ViewModel() {
    val name = MutableLiveData<String>()
    val pass = MutableLiveData<String>()
}