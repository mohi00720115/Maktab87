package com.example.mohsenakhlaghi_hw10_geoquiz

import android.content.ContentValues.TAG
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mohsenakhlaghi_hw10_geoquiz.Cheater.status

object Cheater {
    var status = false
}

class FirstViewModel : ViewModel() {

    private val questionList = arrayListOf(
        "2 + 3 = 7",
        "55 * 3 = 1",
        "3 + 6 = 9",
        "سرعت هواپیما از کشتی بیشتره؟",
        "8 / 4 = 2",
        "آیا ماست سیاهه؟",
        "پدرت همون برادر عموته؟",
        "آیا مرد، زن است؟"
    )

//    var isAnswer = arrayListOf(false, false, false, false, false, false, false, false)

    private val answerList = arrayListOf(
        false, false, true, true, true, false, true, false
    )

    val userAnswerList = mutableListOf("", "", "", "", "", "", "", "")

    private var scoreList = booleanArrayOf(
        false, false, false, false, false, false, false, false
    )

    var cheatStatus = Cheater
    var questionNumber = 0

    //    var currentQuestion = " "
    var currentAnswer = false
    private var score = 0
    val str1 = MutableLiveData(questionList[questionNumber])

    fun checkAnswer(answer: Boolean): Boolean {
        return if (!cheatStatus.status && answer == currentAnswer) {
            scoreList[questionNumber] = true
            true
        } else false
    }

    fun nextQuestion() {
        if (questionNumber < questionList.size - 1) {
            questionNumber++
            str1.value = questionList[questionNumber]
            currentAnswer = answerList[questionNumber]
            cheatStatus.status = false
        }
    }

    fun prevQuestion() {
        if (questionNumber > 0) {
            questionNumber--
            str1.value = questionList[questionNumber]
            currentAnswer = answerList[questionNumber]
            cheatStatus.status = false
        }
    }

    fun calcScore() {
        for (i in scoreList) {
            if (i) score++
        }
    }

/*    private var btnTrue = true          //همه دکمه ها پیشفرض true هستن
    private var btnFalse = true         //همه دکمه ها پیشفرض true هستن
    var btnCheat = true         //همه دکمه ها پیشفرض true هستن
    var btnPrev = true          //همه دکمه ها پیشفرض true هستن
    var btnNext = true          //همه دکمه ها پیشفرض true هستن

    private val clickList = booleanArrayOf(
        false,      //btnTrue
        false,      //btnFalse
        false,      //btnCheat
        true,       //btnPrev
        false       //btnNext
    )        //چرخش دکمه های صفحه برای تغییر وضعیت

    fun answerLock() {      //قفل کردن دکمه های درست و غلط
        btnTrue = false
        clickList[0] = false
        btnFalse = false
        clickList[1] = false
    }

    fun answerUnlock() {        //زمانی که برمی گردیم به حالت قبل یا بعد، دکمه ها آنلاک میشن
        btnTrue = true
        clickList[0] = true
        btnFalse = true
        clickList[1] = true
    }*/

    fun scoreShowFalse(): String {      //فانکشن جواب غلطه و امتیازت برابره با...
        score = 0
        calcScore()
        return " جواب نادرست است وامتیاز شما برابر است با $score"
    }

    fun scoreShowTrue(): String {       ////فانکشن جواب درسته و امتیازت برابره با...
        score = 0
        calcScore()
        return " جواب درست است و امتیاز شما برابر است با $score"
    }

}