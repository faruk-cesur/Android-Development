package com.example.learningjetpackcompose.game.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learningjetpackcompose.game.viewmodel.GameViewModel
import com.example.learningjetpackcompose.game.ui.components.StatelessGameUI


@Composable
fun MainGameScreen() {
    val viewModel: GameViewModel = viewModel()

    StatelessGameUI(
        viewModel.currentHealth,
        onDamageClick = { viewModel.takeDamage(10) },
        viewModel.isCharacterDead
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewMainGameScreen() {
    MainGameScreen()
}