package com.example.learningjetpackcompose.game.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {
    var currentHealth by mutableStateOf(100)
        private set

    val isCharacterDead: Boolean
        get() = currentHealth <= 0

    val maxHealth: Int
        get() = 100

    fun takeDamage(damageAmount: Int) {
        if (!isCharacterDead) currentHealth -= damageAmount
    }

    fun heal(healAmount: Int) {
        if (!isCharacterDead) {
            currentHealth = (currentHealth + healAmount).coerceAtMost(maxHealth)
        }
    }
}