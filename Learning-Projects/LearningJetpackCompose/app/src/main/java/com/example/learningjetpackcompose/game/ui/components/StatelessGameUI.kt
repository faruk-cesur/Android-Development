package com.example.learningjetpackcompose.game.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun StatelessGameUI(health: Int, onDamageClick: () -> Unit, isCharacterDead: Boolean) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
            .padding(16.dp)
    ) {
        Text(
            text = if (isCharacterDead) "Character is DEAD!" else "Health: $health",
            modifier = Modifier.padding(16.dp),
            fontSize = 32.sp,
            color = if (isCharacterDead) Color.Red else Color.Black
        )

        Button(onClick = onDamageClick, enabled = health > 0) {
            Text("DAMAGE", fontSize = 24.sp)
        }
    }
}