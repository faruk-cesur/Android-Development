package com.example.learningjetpackcompose.game.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.learningjetpackcompose.game.ui.components.StatelessMarketUI
import com.example.learningjetpackcompose.game.viewmodel.GameViewModel
import com.example.learningjetpackcompose.game.viewmodel.MarketViewModel

@Composable
fun MarketScreen() {
    val viewModel: MarketViewModel = viewModel()

    StatelessMarketUI(
        viewModel.goldAmount,
        onMineClick = { viewModel.mineGold() },
        onBuySwordClick = { viewModel.buySword() },
        viewModel.canBuySword
    )
}

@Preview
@Composable
fun PreviewMarketScreen() {
    MarketScreen()
}