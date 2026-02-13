package com.example.learningjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learningjetpackcompose.ui.theme.LearningJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GameScreen()
        }
    }
}

@Composable
fun GameScreen(){
    var health by remember {mutableStateOf(100)}
    var healthText : String

    if (health > 0){
        healthText = "Health: $health"
    }else healthText = "Character is dead!"


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
        .fillMaxSize()
        .background(color = Color.LightGray)) {
        Text(healthText,
            modifier = Modifier
                .padding(16.dp),
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp)

        Button(onClick = { health-= 10 }){
            Text("Damage",modifier = Modifier
                .padding(8.dp),
                fontSize = 24.sp
                )
        }
    }
}

@Preview
@Composable
fun PreviewGameScreen(){
    GameScreen()
}