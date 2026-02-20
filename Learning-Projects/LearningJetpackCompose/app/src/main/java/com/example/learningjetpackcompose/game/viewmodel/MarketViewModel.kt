package com.example.learningjetpackcompose.game.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MarketViewModel : ViewModel() {
    var goldAmount by mutableStateOf(0)
        private set

    val canBuySword: Boolean
        get() = goldAmount >= 50

    fun mineGold() {
        goldAmount += 10
    }

    fun buySword() {
        if (canBuySword) {
            goldAmount -= 50
        }
    }
}