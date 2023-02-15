package com.example.Calculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class History : AppCompatActivity() {
    private lateinit var tv1: TextView
    private lateinit var tv2: TextView
    private lateinit var tv3: TextView
    private lateinit var tv4: TextView
    private lateinit var tv5: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        tv1 = findViewById(R.id.textView1)
        tv2 = findViewById(R.id.textView2)
        tv3 = findViewById(R.id.textView3)
        tv4 = findViewById(R.id.textView4)
        tv5 = findViewById(R.id.textView5)

        //هیستوریمون 5 تا تکست ویو داره که میریزیم تو یک لیست
        val list = mutableListOf(tv1, tv2, tv3, tv4, tv5)
        val listResult = intent?.getStringArrayExtra("KEY_RESULT")
        if (listResult != null) {
            for (i in listResult.indices) {
                list[i].text = listResult[i]
            }
        }

        //ست آنکلیک برای تکست ویو هامون که عددو ببره تو تکست ویو ماشین حسابمون
        list.forEach { tv ->
            tv.setOnClickListener {
                setResult(RESULT_OK,
                    Intent().putExtra("KEY_PUTNUMBER",tv.text.toString())
                )
            finish()
            }
        }


    }
}