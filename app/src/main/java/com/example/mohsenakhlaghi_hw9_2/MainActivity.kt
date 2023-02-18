package com.example.mohsenakhlaghi_hw9_2

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import com.example.mohsenakhlaghi_hw9_2.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityMainBinding

    @SuppressLint("ResourceType", "CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("FULL_NAME", Context.MODE_PRIVATE)
        val sEdit = sharedPreferences.edit()

        supportFragmentManager.commit {
            setReorderingAllowed(true)
            add<FirstFragment>(R.id.container_view)
            addToBackStack(null)
        }

    }

}
