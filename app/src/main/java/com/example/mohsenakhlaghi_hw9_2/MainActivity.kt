package com.example.mohsenakhlaghi_hw9_2

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import java.util.*

class MainActivity : AppCompatActivity() {

    @SuppressLint("ResourceType", "CommitPrefEdits")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //region findViewByIds
        val etFullName = findViewById<EditText>(R.id.etFullName)
        val etUsername = findViewById<EditText>(R.id.etUserName)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val etRePassword = findViewById<EditText>(R.id.etRePassword)
        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
        val radioFemale = findViewById<RadioButton>(R.id.radioFemale)
        val radioMale = findViewById<RadioButton>(R.id.radioMale)
        val btnRegister = findViewById<Button>(R.id.btnRegister)
        val btnShowInfo = findViewById<Button>(R.id.btnShowInfo)
        val btnHideInfo = findViewById<Button>(R.id.btnHideInfo)
        val scrollView = findViewById<ScrollView>(R.id.scrollView)
        //LinearLayout
        val linearShowInfo = findViewById<View>(R.id.linearShowInfo)
        val tvFullName = findViewById<TextView>(R.id.tvFullName)
        val tvUserName = findViewById<TextView>(R.id.tvUserName)
        val tvEmail = findViewById<TextView>(R.id.tvEmail)
        val tvPassword = findViewById<TextView>(R.id.tvPassword)
        val tvRePassword = findViewById<TextView>(R.id.tvRePassword)
        //endregion
        val sharedPreferences = getSharedPreferences("FULL_NAME", Context.MODE_PRIVATE)
        val sEdit = sharedPreferences.edit()
        val list = listOf<TextView>(etFullName, etUsername, etEmail, etPassword, etRePassword)

        btnRegister.setOnClickListener {
            if (list.any { it.text.toString() == "" }) {
                Toast.makeText(this, "لطفا تمام اطلاعات را وارد کنید", Toast.LENGTH_SHORT).show()
            } else {
                if ((radioFemale.isChecked == false && radioMale.isChecked == false)) {
                    Toast.makeText(this, "جنسیت را انتخاب کنید", Toast.LENGTH_SHORT).show()
                } else {
                    if (etPassword.text.toString() == etRePassword.text.toString()) {
                        sEdit.putString("FULL_NAME", etFullName.text.toString())
                        sEdit.putString("USER_NAME", etUsername.text.toString())
                        sEdit.putString("EMAIL", etEmail.text.toString())
                        sEdit.putString("PASSWORD", etPassword.text.toString())
                        sEdit.putString("RE-PASSWORD", etRePassword.text.toString())
                    } else Toast.makeText(this, "رمز و تکرار رمز یکسان نیست!", Toast.LENGTH_SHORT).show()
                    sEdit.apply()       //Save
//                        linearShowInfo.visibility = View.INVISIBLE
                }
            }

        }


        btnShowInfo.setOnClickListener {
            sharedPreferences.getString("PASSWORD", null)
            sharedPreferences.getString("RE-PASSWORD", null)
            if (tvPassword.text.toString() == tvRePassword.text.toString()) {
                tvFullName.text = sharedPreferences.getString("FULL_NAME", null)
                tvUserName.text = sharedPreferences.getString("USER_NAME", null)
                tvEmail.text = sharedPreferences.getString("EMAIL", null)
                tvPassword.text = sharedPreferences.getString("PASSWORD", null)
                tvRePassword.text = sharedPreferences.getString("RE-PASSWORD", null)
            } else Toast.makeText(this, "رمز و تکرار رمز یکسان نیست!", Toast.LENGTH_SHORT).show()
            linearShowInfo.visibility = View.VISIBLE

        }

        btnHideInfo.setOnClickListener {
            linearShowInfo.visibility = View.INVISIBLE
            scrollView.fullScroll(ScrollView.FOCUS_UP)      //این کد اسکرول ویو رو به اول برمی گردونه
        }


    }


}
