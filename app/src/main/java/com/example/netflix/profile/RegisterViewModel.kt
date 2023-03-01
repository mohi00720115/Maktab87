package com.example.netflix.profile

import android.net.Uri
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.net.URI

class RegisterViewModel : ViewModel() {

    val name = MutableLiveData<String>("")
    val pass = MutableLiveData<String>("")
    val number = MutableLiveData<String>("")
    var uri = MutableLiveData<Uri>()
    

}