package com.example.mohsenakhlaghi_hw10_4_observer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class TestActivity : AppCompatActivity() {

    private lateinit var tv: TextView
    private lateinit var et: EditText
    private lateinit var save: Button
    private lateinit var show: Button

    val obj = Alaki()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)

        tv = findViewById(R.id.tv)
        et = findViewById(R.id.et)
        save = findViewById(R.id.btn_save)
        show = findViewById(R.id.btn_show)

//        val shared = SharedPreferences
        var list = mutableListOf<String>()

        save.setOnClickListener {
            val giveStr = obj.giveStr(et)
            tv.text = giveStr
        }

        show.setOnClickListener {
//            tv.text = list..toString()
        }


    }
}

class Alaki {

    fun giveStr(str1: EditText): String {
        return str1.text.toString()
    }

}