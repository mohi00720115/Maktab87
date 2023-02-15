package com.example.mohsenakhlaghi_hw9

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {


    @SuppressLint("ShowToast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextUserName = findViewById<TextView>(R.id.editText_UserName)
        val editTextPassword = findViewById<TextView>(R.id.editText_Password)

        var stringUserName = ""
        editTextUserName.text = stringUserName
        var stringPass = ""
        editTextPassword.text = stringPass
        val btnLogin = findViewById<Button>(R.id.btn_login)


        val resultActivity =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { res ->
                when (res.resultCode) {
                    RESULT_OK -> {
                        val data = res.data
                        if (data != null) {
                            if (data.hasExtra("KEY_USERNAME") && data.hasExtra("KEY_PASSWORD")) {
                                stringUserName = data.getStringExtra("KEY_USERNAME").toString()
                                editTextUserName.text = stringUserName
                                stringPass = data.getStringExtra("KEY_PASSWORD").toString()
                                editTextPassword.text = stringPass
                            }
                        }
                    }
                }
            }

        btnLogin.setOnClickListener {
            if (editTextUserName.text.toString().isEmpty() || editTextPassword.text.toString().isEmpty()
            ) {
                Toast.makeText(this, "اطلاعات خالی می باشد", Toast.LENGTH_SHORT).show()
            } else if (editTextUserName.text.toString() == stringUserName && editTextPassword.text.toString() == stringPass) {
                //SnackBar
                val snackBar = Snackbar.make(it, "اطلاعات صحیح است", Snackbar.LENGTH_LONG)
                snackBar.setBackgroundTint(Color.BLACK)
                snackBar.setTextColor(Color.YELLOW)
                snackBar.setActionTextColor(Color.CYAN)
                snackBar.setAction("UNDO") {
                    Toast.makeText(
                        applicationContext,
                        "Undo action",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                snackBar.show()
            } else {
                Toast.makeText(applicationContext, "اطلاعات صحیح نیست", Toast.LENGTH_SHORT).show()
            }


        }
        val btnSingUp = findViewById<Button>(R.id.btn_singUp)
        btnSingUp.setOnClickListener {
            val intnt = Intent(this, MainActivity2::class.java)
            intnt.putExtra("KEY_USERNAME", editTextUserName.text.toString())
            intnt.putExtra("KEY_PASSWORD", editTextPassword.text.toString())
            resultActivity.launch(intnt)
        }


    }


}