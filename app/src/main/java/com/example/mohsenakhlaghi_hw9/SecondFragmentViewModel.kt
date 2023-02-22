package com.example.mohsenakhlaghi_hw9

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SecondFragmentViewModel : ViewModel() {
    val name2 = MutableLiveData<String>()
    val pass2 = MutableLiveData<String>()
}