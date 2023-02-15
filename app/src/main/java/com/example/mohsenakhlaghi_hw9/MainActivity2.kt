package com.example.mohsenakhlaghi_hw9

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val editTextUserName2 = findViewById<TextView>(R.id.editText_UserName2)
        val editTextPassword2 = findViewById<TextView>(R.id.editText_Password2)
        val btnSingUp2 = findViewById<Button>(R.id.btn_singUp2)

        editTextUserName2.text = intent?.getStringExtra("KEY_USERNAME")
        editTextPassword2.text = intent?.getStringExtra("KEY_PASSWORD")

        btnSingUp2.setOnClickListener {
            if (editTextUserName2.text.toString().length < 2 || editTextPassword2.text.toString().length < 2) {
                Toast.makeText(this, "اطلاعات خالیه", Toast.LENGTH_SHORT).show()
            } else {
                setResult(RESULT_OK,
                    Intent()
                        .putExtra("KEY_USERNAME", editTextUserName2.text.toString())
                        .putExtra("KEY_PASSWORD", editTextPassword2.text.toString())
                )
                finish()
            }
        }


    }
}