package com.example.Calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.Calculator.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val math = Math()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //region findViewByIds
        val btn0 = findViewById<Button>(R.id.btn0)
        val btn1 = findViewById<Button>(R.id.btn1)
        val btn2 = findViewById<Button>(R.id.btn2)
        val btn3 = findViewById<Button>(R.id.btn3)
        val btn4 = findViewById<Button>(R.id.btn4)
        val btn5 = findViewById<Button>(R.id.btn5)
        val btn6 = findViewById<Button>(R.id.btn6)
        val btn7 = findViewById<Button>(R.id.btn7)
        val btn8 = findViewById<Button>(R.id.btn8)
        val btn9 = findViewById<Button>(R.id.btn9)
        val btnAdd = findViewById<Button>(R.id.btn_add)
        val btnMinus = findViewById<Button>(R.id.btn_minus)
        val btnMultiply = findViewById<Button>(R.id.btn_multiply)
        val btnDivision = findViewById<Button>(R.id.btn_Division)
        val btnEquals = findViewById<Button>(R.id.btn_equals)
        val btnDel = findViewById<Button>(R.id.btn_del)
        val btnDot = findViewById<Button>(R.id.btn_dot)
        val btnHistory = findViewById<Button>(R.id.btn_History)
        val tvShowNumber = findViewById<TextView>(R.id.tvShowNumber)
        val textView = findViewById<TextView>(R.id.textView)
        //endregion

        val btnNumList = listOf(btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9)
        for (i in btnNumList) {
            i.setOnClickListener {
                math.clickNumberButton(i.text.toString().toDouble())
                tvShowNumber.text = math.firstNum.toString()
            }
        }

        val operatorButton = arrayOf(btnAdd, btnMinus, btnMultiply, btnDivision)
        for (btn in operatorButton) {
            btn.setOnClickListener {
                math.clickOperatorButton(btn.text.toString())
                tvShowNumber.text = btn.text.toString()
                textView.text = math.resFirstNumber.toString()
                btnDot.isClickable = true

            }
        }

        btnEquals.setOnClickListener {
            math.clickEqualsButton()
            if (math.finalResult == 0.0) {
                tvShowNumber.text = "Cannot divide by zero"
            } else {
                tvShowNumber.text = math.finalResult.toString()
                textView.text = ""
            }
        }

        btnDot.setOnClickListener {
            math.isDot = true
        }

        btnDel.setOnClickListener {
            math.clickDelButton()
            tvShowNumber.text = ""
            textView.text = ""
        }

        val resultActivity =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { res ->
                if (res.resultCode == RESULT_OK) {
                    val value = res.data
                    if (value != null) {
                        math.strSplit(value.getStringExtra("KEY_PUTNUMBER").toString())
                        tvShowNumber.text = math.finalResult.toString()
                    }
                }
            }

        btnHistory.setOnClickListener {
            val intnt = Intent(this, History::class.java)
                .putExtra("KEY_RESULT", math.list)
            resultActivity.launch(intnt)

        }


    }


}