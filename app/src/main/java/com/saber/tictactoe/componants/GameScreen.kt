package com.saber.tictactoe.componants

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.saber.tictactoe.ui.theme.`Board-Background`
import com.saber.tictactoe.viewmodel.TicTacToeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun GameScreen(viewModel: TicTacToeViewModel = koinViewModel()) {

    val board by viewModel.board.collectAsState()
    val currentPlayer by viewModel.currentPlayer.collectAsState()
    val winner by viewModel.winner.collectAsState()
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Text("Current Player: $currentPlayer")
        Box(
            modifier = Modifier
                .background(`Board-Background`, shape = RoundedCornerShape(12.dp))
                .padding(16.dp)
        ) {
            Board(value = board) { row, col ->
                viewModel.makeMove(row, col)
            }
        }
        Text("Winner: $winner")
    }
}