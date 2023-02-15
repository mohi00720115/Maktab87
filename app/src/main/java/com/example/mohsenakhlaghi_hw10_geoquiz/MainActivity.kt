package com.example.mohsenakhlaghi_hw10_geoquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.mohsenakhlaghi_hw10_geoquiz.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //    val quiz = GeoQuiz()
    private val quiz = GeoQuiz

    private val clickList = booleanArrayOf(
        false,      //btnTrue
        false,      //btnFalse
        false,      //btnCheat
        true,       //btnPrev
        false       //btnNext
    )        //چرخش دکمه های صفحه برای تغییر وضعیت

    private lateinit var tvQuiz: TextView
    private lateinit var btnFalse: Button
    private lateinit var btnTrue: Button
    private lateinit var btnCheat: Button
    private lateinit var btnNext: Button
    private lateinit var btnPrev: Button
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        btnFalse = findViewById(R.id.btn_false)
        btnTrue = findViewById(R.id.btn_true)
        btnCheat = findViewById(R.id.btn_cheat)
        btnNext = findViewById(R.id.btn_next)
        btnPrev = findViewById(R.id.btn_prev)
        tvQuiz = findViewById(R.id.tv_quiz)


        fun answerLock() {      //قفل کردن دکمه های درست و غلط
            btnTrue.isClickable = false
            clickList[0] = false
            btnFalse.isClickable = false
            clickList[1] = false
        }

        fun answerUnlock() {        //زمانی که برمی گردیم به حالت قبل یا بعد، دکمه ها آنلاک میشن
            btnTrue.isClickable = true
            clickList[0] = true
            btnFalse.isClickable = true
            clickList[1] = true
        }

        fun scoreShowFalse() {      //فانکشن جواب غلطه و امتیازت برابره با...
            quiz.calcScore()
            Toast.makeText(
                this,
                " جواب نادرست است و امتیاز شما برابر است با${quiz.score} ",
                Toast.LENGTH_LONG
            ).show()
            quiz.score = 0
        }

        fun scoreShowTrue() {       ////فانکشن جواب درسته و امتیازت برابره با...
            quiz.calcScore()
            Toast.makeText(
                this,
                " جواب درست است و امتیاز شما برابر است با${quiz.score} ",
                Toast.LENGTH_LONG
            ).show()
            quiz.score = 0
        }


        btnCheat.setOnClickListener {
            val cheatData = Intent(this, CheatActivity::class.java)
            cheatData.putExtra("answer", quiz.currentAnswer)
            startActivity(cheatData)
        }

        btnFalse.setOnClickListener {
            if (quiz.checkAnswer(false)) scoreShowTrue()
            else scoreShowFalse()
            answerLock()
        }

        btnTrue.setOnClickListener {
            if (quiz.checkAnswer(true)) scoreShowTrue()
            else scoreShowFalse()
            answerLock()

        }

        btnPrev.setOnClickListener {
            if (quiz.cheatStatus) {
                Toast.makeText(this, "Cheating is wrong", Toast.LENGTH_SHORT).show()
            }
            quiz.prevQuestion()
            tvQuiz.text = quiz.currentQuestion
            answerUnlock()
            btnNext.isClickable = true
            clickList[3] = true
            if (quiz.questionNumber == 1) {
                btnPrev.isClickable = false
                clickList[4] = false
            }
        }

        btnNext.setOnClickListener {
            if (quiz.cheatStatus) {
                Toast.makeText(this, "Cheating is wrong", Toast.LENGTH_SHORT).show()
            }
            quiz.nextQuestion()
            tvQuiz.text = quiz.currentQuestion
            answerUnlock()
            if (quiz.questionNumber > 1) {
                btnPrev.isClickable = true
                clickList[4] = true
            }
            btnCheat.isClickable = true
            clickList[2] = true
            if (quiz.questionNumber == quiz.lastQuestionNumber) {
                btnNext.isClickable = false
                clickList[3] = false
            }

        }

        btnPrev.isClickable = false
        clickList[4] = false
        btnCheat.isClickable = false
        clickList[2] = false
        answerLock()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("ANSWER", quiz.currentAnswer)
        outState.putString("QUESTION", quiz.currentQuestion)
        outState.putInt("NUMBER", quiz.questionNumber)
        outState.putBooleanArray("CLICK", clickList)
        outState.putBooleanArray("SCORE", quiz.scoreList)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        quiz.currentAnswer = savedInstanceState.getBoolean("ANSWER")
        quiz.questionNumber = savedInstanceState.getInt("NUMBER")
        quiz.currentQuestion = savedInstanceState.getString("QUESTION").toString()
        tvQuiz.text = quiz.currentQuestion
        btnTrue.isClickable = savedInstanceState.getBooleanArray("CLICK")?.get(0) ?: false
        btnFalse.isClickable = savedInstanceState.getBooleanArray("CLICK")?.get(1) ?: false
        btnFalse.isClickable = savedInstanceState.getBooleanArray("CLICK")?.get(2) ?: false
        btnFalse.isClickable = savedInstanceState.getBooleanArray("CLICK")?.get(3) ?: false
        btnFalse.isClickable = savedInstanceState.getBooleanArray("CLICK")?.get(4) ?: false
        quiz.scoreList = savedInstanceState.getBooleanArray("SCORE")!!
    }


}
