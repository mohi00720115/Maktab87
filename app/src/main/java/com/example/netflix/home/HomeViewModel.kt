package com.example.netflix.home

import androidx.lifecycle.ViewModel
import com.example.netflix.image.ImageDataClass
import com.example.netflix.R

class HomeViewModel : ViewModel() {

    private val imageListDC = arrayListOf<ImageDataClass>(
        ImageDataClass("SM0", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SM1", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SM2", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SM3", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SM4", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SM5", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SM6", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SM7", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SM8", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SM9", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SM10", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SM11", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SM12", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SM13", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SM14", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SM15", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SM16", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SM17", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SM18", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SM19", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SM20", R.drawable.sp, R.drawable.hearth, false)
    )
    val imageListOfMovie = arrayListOf<ImageDataClass>()
    val listLikes = mutableListOf<ImageDataClass>()

    init {
        imageListOfMovie.addAll(imageListDC)
    }

    fun like(position: Int) {
        listLikes.add(imageListOfMovie[position])
        imageListOfMovie[position].isFavorite = true
    }

    fun disLike(position: Int) {
        listLikes.remove(imageListOfMovie[position])
        imageListOfMovie[position].isFavorite = false
    }

    fun likeOrDislike(position: Int) {
        when {
            imageListOfMovie[position].isFavorite -> {
                disLike(position)
                return
            }
            else -> {
                like(position)
            }
        }
    }

}