package com.example.mohsenakhlaghi_hw10_geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

object GeoQuiz : AppCompatActivity() {

    val questionList = arrayListOf<String>(
        "2 + 3 = 7",
        "55 * 3 = 1",
        "3 + 6 = 9",
        "سرعت هواپیما از کشتی بیشتره؟",
        "8 / 4 = 2",
        "آیا ماست سیاهه؟",
        "پدرت همون برادر عموته؟",
        "یک مرد، مونث است"
    )

    private val answerList = arrayListOf<Boolean>(
        false,
        false,
        true,
        true,
        true,
        false,
        true,
        false
    )

    var scoreList = booleanArrayOf(
        false, false, false, false
    )

    var cheatStatus = false
    var questionNumber = 0
    var currentQuestion = " "
    var currentAnswer = false
    var score = 0
    val lastQuestionNumber = questionList.size

    fun checkAnswer(answer: Boolean): Boolean {
        return if (!cheatStatus && answer == currentAnswer) {
            scoreList[questionNumber - 1] = true
            true
        } else false
    }

    fun nextQuestion() {
        currentQuestion = questionList[questionNumber]
        currentAnswer = answerList[questionNumber]
        questionNumber++
        cheatStatus = false
    }

    fun prevQuestion() {
        questionNumber -= 2
        currentQuestion = questionList[questionNumber]
        currentAnswer = answerList[questionNumber]
        questionNumber++
        cheatStatus = false
    }

    fun calcScore() {
        for (i in scoreList) {
            if (i) score++
        }
    }


}