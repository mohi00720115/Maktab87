package com.example.Calculator

import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.math.pow

enum class Op() {
    ADD, MIN, MUL, DIV, NONE
}

class Math {
    //region Variables ☺
    private var operator = Op.NONE
    var firstNum = 0.0
    var resFirstNumber = 0.0
    private var resSecondNumber = 0.0
    var finalResult = 0.0
    var isDot = false
    private var power = -1
    private var isOperatorClick = false

    //ما 5 تا لیست داریم که وقتی میره تو اکتیویتی هیستوری، اعدادو میبره اونور بصورت استرینگ
    var list: Array<String> = arrayOf("", "", "", "", "")
    var index = 0       //این میره تو لیست، ایندکس بعدی
    //endregion

    fun clickNumberButton(numberButton: Double) {
        if (!isDot) {   //اعشار
            firstNum = firstNum * 10.0 + numberButton
        } else {
            //اگه عددی ضربدر 10 به توان منفی 1 بشه یدونه اعشار می گیره.
            firstNum += (numberButton * 10.0.pow(power))  //اعشار
            power-- //یدونه اعشار میره جلوتر
            firstNum = BigDecimal(firstNum).setScale(2, RoundingMode.HALF_UP).toDouble()
        }
    }

    fun clickOperatorButton(operatorButton: String) {
        resFirstNumber = firstNum
        firstNum = 0.0
        power = -1      //اعشار
        isDot = false   //اعشار
        when (operatorButton) {
            "+" -> operator = Op.ADD
            "-" -> operator = Op.MIN
            "*" -> operator = Op.MUL
            "/" -> operator = Op.DIV
            else -> Op.NONE
        }
        isOperatorClick = true
    }

    fun clickEqualsButton() {
        resSecondNumber = firstNum
        when (operator) {
            Op.ADD -> {
                //درصد 4 برای اینه وقتی لیستمون پر شد ارور خارج از باند نده و بیاد آیتم بالایی لیست رو دوباره پر کنه
                list[index % 4] = "$resFirstNumber + $resSecondNumber"
                index++
                finalResult = resFirstNumber + resSecondNumber
            }
            Op.MIN -> {
                list[index % 4] = "$resFirstNumber - $resSecondNumber"
                index++
                finalResult = resFirstNumber - resSecondNumber
            }
            Op.MUL -> {
                list[index % 4] = "$resFirstNumber * $resSecondNumber"
                index++
                finalResult = resFirstNumber * resSecondNumber
            }
            Op.DIV -> {
                list[index % 4] = "$resFirstNumber / $resSecondNumber"
                index++
                if (resSecondNumber == 0.0) finalResult = 0.0 else {
                    finalResult = resFirstNumber / resSecondNumber
                }
            }
        }
        firstNum = finalResult

    }

    //میایم لیست نهایی در تاریخچه رو اسپلیت می کنیم و اعدادش رو محاسبه می کنیم دوباره
    fun strSplit(str: String) {
        val sp = str.split(" ")
        resFirstNumber = sp[0].toDouble()
        resSecondNumber = sp[2].toDouble()
        when (sp[1]) {
            "+" -> finalResult = resFirstNumber + resSecondNumber
            "-" -> finalResult = resFirstNumber - resSecondNumber
            "*" -> finalResult = resFirstNumber * resSecondNumber
            "/" -> finalResult = if (resSecondNumber == 0.0) 0.0 else {
                resFirstNumber / resSecondNumber
            }

        }
    }

    fun clickDelButton() {
        operator = Op.NONE
        firstNum = 0.0
        resFirstNumber = 0.0
        resSecondNumber = 0.0
        isOperatorClick = false
        isDot = false   //اعشار
        power = -1      //اعشار
        finalResult = 0.0
    }

}
