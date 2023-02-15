package com.example.mohsenakhlaghi_hw10_4_observer

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer

class MainActivity : AppCompatActivity() {
        private val observerAsli = Observable()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d(TAG, "onCreate: ")

        val obj1 = Observer("Mohsen")
        val obj2 = Observer("Pooriya")
        val obj3 = Observer("Alireza")
//        val obj4 = Observer("Ehsan")
//        val obj5 = Observer("Sina")

        observerAsli.register(obj1)
        observerAsli.register(obj2)
        observerAsli.register(obj3)
        observerAsli.iterateInNumberList()


    }

    override fun onPause() {
        Log.d(TAG, "onPause: ")
        observerAsli.iterateInNumberList()
        super.onPause()
    }

    override fun onResume() {
        Log.d(TAG, "onResume: ")
        super.onResume()
    }




}
