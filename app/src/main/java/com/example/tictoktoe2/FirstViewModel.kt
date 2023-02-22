package com.example.tictoktoe2

import androidx.lifecycle.ViewModel

enum class WinOrLose() {
    DRAW
}

enum class Players {
    PLAYER1WIN, PLAYER2WIN
}

class FirstViewModel: ViewModel() {

    var select = 0
    var status = true
    val player1 = mutableListOf<Int>()
    //    val player1 = MutableLiveData<Int>()
    val player2 = mutableListOf<Int>()
//    val player2 = MutableLiveData<Int>()

    var statusA = true
    var statusB = true

    val winState = mutableListOf(
        listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9),
        listOf(1, 4, 7), listOf(2, 5, 8), listOf(3, 6, 9),
        listOf(1, 5, 9), listOf(3, 5, 7)
    )
    var turnCounter = 0


    fun reset() {
        this.status = true
        this.turnCounter = 1
        this.player1.removeAll(player1)
        this.player2.removeAll(player2)
    }

    fun nextTurn(select: Int) {
        if (turnCounter % 2 == 0) {
            this.player1.add(select)
        }
        if (turnCounter % 2 == 1) {
            this.player2.add(select)
        }
        this.turnCounter++
        if (turnCounter > 9) {
            status = false
        }
    }

    fun checkWin(playerList: List<Int>): Boolean {
        var result = false
        var num = 0
        for (i in winState) {
            for (j in i) {
                if (playerList.contains(j)) {
                    num++
                }
            }
            if (num == 3) {
                result = true
                break
            } else {
                num = 0
            }
        }
        return result

    }
}