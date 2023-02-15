package com.example.mohsenakhlaghi_hw10_4_observer

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import kotlin.concurrent.thread

////کلاس کوچکه اینه
class Observer(val shenase: String) {

    fun printShenase(num: Int) {
        Log.e(TAG, "$shenase printShenase: $num")
    }

}

//کلاس بزرگه اینه
class Observable : DefaultLifecycleObserver {
    private var flag = true
    private var index = 1
    private var listObserver = mutableListOf<Observer>()
    private var listNumber = (1..100).toMutableList()

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
    private fun iterateInNumberList() {
        //یه ترد داریم که میاد تو حلقه while اولین ایندکس لیست رو که گرفت چاپ کرد پاک می کنه
        thread {
            //در اینجا flag ما true هستش
            while (flag) {
                printLog(listNumber[0])
                listNumber.removeAt(0)
                if (index == listNumber.size - 1) {
                    break
                }
                index++
                Thread.sleep(3000)
            }
        }
    }

    override fun onResume(owner: LifecycleOwner) {
        flag = true
        iterateInNumberList()
        super.onResume(owner)
    }

    override fun onPause(owner: LifecycleOwner) {
        flag = false
        super.onPause(owner)
    }

}