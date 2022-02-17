package com.quanticheart.ticTacToe.domain.models

data class Cell(var player: Player?) {

    val isEmpty: Boolean
        get() = player?.value?.isEmpty() == true
}