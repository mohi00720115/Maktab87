package com.example.jalase41

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class FirstViewModel : ViewModel() {
    private val _listCity = MutableLiveData<ArrayList<CityDataClass>>()
    val listCity: LiveData<ArrayList<CityDataClass>> = _listCity

    fun setList(listCity: ArrayList<CityDataClass>) {
//        _listCity.value = listCity
        _listCity.postValue(listCity)
        // 2 تا کد بالا عملکرد یکسانی دارن
    }

}