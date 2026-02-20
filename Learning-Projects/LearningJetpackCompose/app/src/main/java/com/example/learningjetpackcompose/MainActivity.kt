package com.example.learningjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainGameScreen()
        }
    }
}

class GameViewModel: ViewModel(){
    var currentHealth by mutableStateOf(100)
        private set

    val isCharacterDead : Boolean
        get() = currentHealth <= 0
    
    val maxHealth: Int
        get() = 100

    fun takeDamage(damageAmount:Int){
        if (!isCharacterDead) currentHealth -= damageAmount
    }

    fun heal(healAmount: Int){
        if (!isCharacterDead) {
            currentHealth = (currentHealth + healAmount).coerceAtMost(maxHealth)
        }
    }
}

@Composable
fun StatelessGameUI(health: Int, onDamageClick:()-> Unit){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
            .padding(16.dp)) {
        Text(
            text = if(health>0)"Health: $health" else "Character is DEAD!",
            modifier = Modifier.padding(16.dp),
            fontSize = 32.sp,
            color = if(health > 0) Color.Black else Color.Red)

        Button(onClick = onDamageClick, enabled = health > 0) {
            Text("DAMAGE", fontSize = 24.sp)
        }
    }
}

@Composable
fun MainGameScreen(){
    val viewModel: GameViewModel = viewModel()

    StatelessGameUI(viewModel.currentHealth, onDamageClick = {viewModel.takeDamage(10)})
}

@Preview(showBackground = true)
@Composable
fun PreviewMainGameScreen(){
    MainGameScreen()
}