package com.example.netflix.comingSoon

import androidx.lifecycle.ViewModel
import com.example.netflix.R
import com.example.netflix.image.ImageDataClass

class ComingSoonViewModel : ViewModel() {

    private val imageListDC = arrayListOf<ImageDataClass>(
        ImageDataClass("SM0", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SM1", R.drawable.sp, R.drawable.hearth, false),
        ImageDataClass("SM2", R.drawable.sp, R.drawable.hearth, false)
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