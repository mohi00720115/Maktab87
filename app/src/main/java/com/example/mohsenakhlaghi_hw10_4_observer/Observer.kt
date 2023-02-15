package com.example.mohsenakhlaghi_hw10_4_observer

import android.content.ContentValues.TAG
import android.util.Log

////کلاس کوچکه اینه
class Observer(val shenase: String) {

    fun printShenase(num: Int) {
        Log.e(TAG, "$shenase printShenase: $num")
    }

}

//کلاس بزرگه اینه
class Observable {
    var listObserver = mutableListOf<Observer>()
    var listNumber = (1..100).toMutableList()

    //Follow
    fun register(observer: Observer) {
        listObserver.add(observer)
    }

    //onFollow
    fun unregister(observer: Observer) {
        listObserver.remove(observer)
    }

    //Notification
    private fun printLog(number: Int) {
        for (observer in listObserver) {
            observer.printShenase(number)
        }
    }

    //رو اعداد پیمایش می کنه و تابع پرینت لاگ رو توش صدا می کنه
    fun iterateInNumberList() {
        val index = listNumber.size
        for (i in 0 until index) {
            printLog(listNumber[0])
            listNumber.removeAt(0)
            Thread.sleep(1500)      //سه ثانیه (1.5) مکث
        }
    }

}