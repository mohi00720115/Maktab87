package com.example.tictoktoe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {


    private var str = ""
    private lateinit var tv: TextView
    lateinit var btnStart: Button
    lateinit var buttonChoose: Button
    val randomPlayer = (1..2).random()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnStart = findViewById(R.id.btn_start)
        buttonChoose = findViewById(R.id.btn_choose)
        tv = findViewById(R.id.textView_players)

        str = "Player $randomPlayer"

        buttonChoose.setOnClickListener {
            tv.text = str
            buttonChoose.isClickable = false
        }

        btnStart.setOnClickListener {
            if (tv.text.equals("Random Players")) {
                Toast.makeText(this, "اول بازیکن رو انتخاب کن", Toast.LENGTH_SHORT).show()
            } else {
                val intnt = Intent(this, MainActivity::class.java)
                if (randomPlayer == 1) intnt.putExtra("Player1", 1)
                else intnt.putExtra("Player1", 2)
                startActivity(intnt)
            }

        }


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        val a = tv.text
        outState.putString("KEY_PLAYER", a.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        tv.text = savedInstanceState.getString("KEY_PLAYER")
        buttonChoose.isClickable = false

    }

/*

    override fun onStart() {
        super.onStart()
        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show()
    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
    }

    override fun onPause() {
        super.onPause()
        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show()
    }

    override fun onStop() {
        super.onStop()
        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show()
    }

    override fun onRestart() {
        super.onRestart()
        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show()
    }

 */

}