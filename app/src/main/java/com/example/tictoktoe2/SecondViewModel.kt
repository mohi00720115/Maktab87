package com.example.tictoktoe2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

enum class StatusPlayerFourRow {
    PLAYER1, PLAYER2
}

class SecondViewModel : ViewModel() {

    val listPlace = mutableListOf(
        arrayListOf("", "", "", "", ""),
        arrayListOf("", "", "", "", ""),
        arrayListOf("", "", "", "", ""),
        arrayListOf("", "", "", "", ""),
        arrayListOf("", "", "", "", "")
    )

    val listPlaceLiveData = MutableLiveData(listPlace)
    var statusPlayer = StatusPlayerFourRow.PLAYER1
    var Player1Name = "X"
    var Player2Name = "O"


    //اسم بازیکنی که می خواد بازی کنه رو میریزی تو یه تکست ویو
    val player = MutableLiveData(Player1Name)

    //تغییر وضعیت بازیکن-یک ب یک عوض میشه
    fun changeStatus() {
        statusPlayer = if (statusPlayer == StatusPlayerFourRow.PLAYER1) {
            player.value = Player2Name
            StatusPlayerFourRow.PLAYER2
        } else {
            player.value = Player1Name
            StatusPlayerFourRow.PLAYER1
        }
    }

    //شماره ستون رو می گیره که از صفر شروع میشه که با ایندکس ها اوکی باشه
    fun chooseColumn(column: Int) {
        listPlace[column] = chooseInColumn(listPlace[column])
        listPlaceLiveData.value = listPlace
    }

    //داخل محتویات ستون میره و چک می کنه تو اولین ایندکسی که تو اون ستون خالیه کدومه و انو برمی گردونه
    fun chooseInColumn(list: ArrayList<String>): ArrayList<String> {
        for (i in list.indices) {
            if (list[i] == "") {
                list[i] = choose()
                return list
            }
        }
        return list
    }

    //نوبت بازیکنا رو چک می کنه و تغییرشون میده
    fun choose(): String {
        return if (statusPlayer == StatusPlayerFourRow.PLAYER1) {
            changeStatus()
            Player1Name
        } else {
            changeStatus()
            Player2Name
        }
    }


}