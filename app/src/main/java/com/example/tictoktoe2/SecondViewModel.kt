package com.example.tictoktoe2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class StatusPlayerFourRow {
    PLAYER1, PLAYER2
}

class SecondViewModel : ViewModel() {

    private var listPlace = ArrayList<String>()     //همون لیست 25 تاییه که میدیم به ریسایکلر تا دکمه هاشو بسازه
    private var rowAndColumn = 5        //سطر و ستون

    //فانکشنی برای تغییر جدول و چیدمان بازی
    fun changeRowAndColumn(createRowAndColumn: Int) {
        rowAndColumn = createRowAndColumn
    }

    //یه لیست می سازه از 25 تا استرینگ خالی--> که این لیست به آداپتر پاس داده میشه
    fun fetchData(createRowAndColumn: Int) {
        for (i in 0 until createRowAndColumn * createRowAndColumn) {
            listPlace.add("")
        }
    }

    //اول میاد اینو چک می کنه کهخ ببینه لیستمون چندتاس
    init {
        fetchData(rowAndColumn)
    }

    val listChoosePlayerOne = mutableSetOf<Int>()       //بازکن اول که انتخاب میشه ریخته میشه تو یک لیست
    val listChoosePlayerTwo = mutableSetOf<Int>()       //بازکن دوم که انتخاب میشه ریخته میشه تو یک لیست
    var statusPlayer = StatusPlayerFourRow.PLAYER1
    var namePlayerOne = "X"
    var namePlayerTwo = "O"
    val player = MutableLiveData(namePlayerOne)
    var status = arrayListOf(false)         //برای قفل کردن همه ی دکمه ها در شرایطی که بازیکنی برنده میشه و چون ارری لیسته باید رفرنس تایپ باشه که ریسایکلر پونتر بزنه بهش ینی فضای اتکش آدرسو میگیره تغییراتو اعمال می کنه

    //گتر همون لیستیه که پاس می دادیم به ریسایکلر و تو فرگمنت می گیریمش
    fun getListPlace(): ArrayList<String> {
        return listPlace
    }

    //تغییر بازیکن بصورت یک به یک
    fun changeStatus() {
        statusPlayer = if (statusPlayer == StatusPlayerFourRow.PLAYER1) {
            player.value = namePlayerTwo
            StatusPlayerFourRow.PLAYER2
        } else {
            player.value = namePlayerOne
            StatusPlayerFourRow.PLAYER1
        }
    }

    //نمایش میده جایی که کاربر کلیک می کنه مستقیم میره پایین ترینو پر می کنه
    fun choosePlace(place: Int): ArrayList<String> {
        var location = place % rowAndColumn + ((rowAndColumn - 1) * rowAndColumn)
        //فور کی زنیم که خونه های پر رو پر نکنه یکی بره بعدیش
        for (index in 0 until rowAndColumn) {
            if (listPlace[location] == "") {
                listPlace[location] = choose(location)      //اسم بازیکنو می ریزه توش
                break
            } else location -= rowAndColumn
        }
        return listPlace
    }

    //قراردادن اسم بازیکنی که روی دکمه کلیک شده و قراره پر بشه
    fun choose(place: Int): String {
        return if (statusPlayer == StatusPlayerFourRow.PLAYER1) {
            changeStatus()
            listChoosePlayerOne.add(place)
            if (check(listChoosePlayerOne)) {
                status[0] = true
                player.value = "$namePlayerOne Win"
            }
            namePlayerOne
        } else {
            changeStatus()
            listChoosePlayerTwo.add(place)
            if (check(listChoosePlayerTwo)) {
                status[0] = true
                player.value = "$namePlayerTwo Win"
            }
            namePlayerTwo
        }
    }

    //حالات مختلف برنده شدنو چک می کنه
    fun check(listChoose: MutableSet<Int>): Boolean {
        return when {
            winVertical(listChoose) -> {
                true
            }
            winHorizontal(listChoose) -> {
                true
            }
            winDiagonal(listChoose) -> {
                true
            }
            else -> winDiagonalRevers(listChoose)
        }
    }

    //حالت برد در حالت عمودی (زیرهم)
    fun winVertical(listChoose: MutableSet<Int>): Boolean {
        //آی ستون و جی ردیفه
        for (i in 0 until rowAndColumn) {
            var count = 0       //شمارنده
            for (j in i until rowAndColumn * rowAndColumn step 5) {
                when (j) {
                    in listChoose -> {
                        count++
                        when (count) {
                            4 -> return true
                        }
                    }
                    else -> {
                        count = 0
                    }
                }
            }
        }
        return false
    }

    //حالت برد در حالت افقی (کنارهم)
    fun winHorizontal(listChoose: MutableSet<Int>): Boolean {
        for (i in 0 until rowAndColumn * rowAndColumn step 5) {
            var count = 0
            for (j in i..i + 4) {
                when (j) {
                    in listChoose -> {
                        count++
                        when (count) {
                            4 -> return true
                        }
                    }
                    else -> {
                        count = 0
                    }
                }
            }
        }
        return false
    }

    //حالات برد بصورت مورب چپ به راست
    fun winDiagonal(listChoose: MutableSet<Int>): Boolean {
        for (i in 0 until rowAndColumn * rowAndColumn) {
            var count = 0
            var step = rowAndColumn
            var num = 0
            var number: Int
            for (_i in 0 until rowAndColumn * 2 - 1) {
                if (num >= rowAndColumn * (rowAndColumn - 1)) {
                    step = 1
                }
                number = num
                for (j in 0..num / (rowAndColumn - 1)) {
                    when (number) {
                        in listChoose -> {
                            count++
                            when (count) {
                                4 -> {
                                    return true
                                }
                            }
                        }
                        else -> {
                            count = 0
                        }
                    }
                    number -= rowAndColumn - 1
                }
                num += step
            }
        }
        return false
    }

    //حالات برد بصورت مورب راست به چپ
    fun winDiagonalRevers(listChoose: MutableSet<Int>): Boolean {
        for (i in 0 until rowAndColumn * rowAndColumn) {
            var count = 0
            var step = rowAndColumn
            var num = rowAndColumn - 1
            var number: Int
            for (_i in 0 until rowAndColumn * 2 - 1) {
                if (num >= rowAndColumn * (rowAndColumn - 1)) {
                    step = -1
                }
                number = num
                for (j in 0..num / (rowAndColumn - 1)) {
                    when (number) {
                        in listChoose -> {
                            count++
                            when (count) {
                                4 -> {
                                    return true
                                }
                            }
                        }
                        else -> {
                            count = 0
                        }
                    }
                    number -= rowAndColumn + 1
                }
                num += step
            }
        }
        return false
    }

}