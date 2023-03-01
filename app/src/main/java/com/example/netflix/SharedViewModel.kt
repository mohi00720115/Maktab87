package com.example.netflix

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.netflix.image.ImageDataClass

class SharedViewModel : ViewModel() {

/*
    val movieList = listOf<ImageDataClass>(
        ImageDataClass("SpiderMan", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SpiderMan", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SpiderMan", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SpiderMan", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SpiderMan", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SpiderMan", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SpiderMan", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SpiderMan", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SpiderMan", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SpiderMan", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SpiderMan", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SpiderMan", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SpiderMan", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SpiderMan", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SpiderMan", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SpiderMan", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SpiderMan", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SpiderMan", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SpiderMan", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SpiderMan", R.drawable.sp, R.drawable.hearth, false),
    )

    var arrayListOfMovies: ArrayList<ImageDataClass> = ArrayList()

    val _favoritesList = MutableLiveData<List<ImageDataClass>>()
    val favoritesList: LiveData<List<ImageDataClass>> = _favoritesList

    fun saveFavoritesItem(favoritesList: ImageDataClass) {
//        _favoritesList.value?.apply {  add(favoritesList)}
        _favoritesList.value = _favoritesList.value?.plus(favoritesList) ?: listOf(favoritesList)
        Log.e(TAG, "favoritesList: $favoritesList")
        Log.e(TAG, "this.favoritesList.value?.size: ${this.favoritesList.value?.size}")
    }

    fun removeFavoritesItem(favoritesList: ImageDataClass) {
        _favoritesList.value?.apply {
//            remove(favoritesList)
        }
    }
*/

}