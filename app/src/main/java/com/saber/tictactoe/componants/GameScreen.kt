package com.saber.tictactoe.componants

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.saber.tictactoe.viewmodel.TicTacToeViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun GameScreen(viewModel: TicTacToeViewModel = koinViewModel()) {

    val board by viewModel.board.collectAsState()
    val currentPlayer by viewModel.currentPlayer.collectAsState()
    val winner by viewModel.winner.collectAsState()
    Column {
        Text("Current Player: $currentPlayer")
        Board(value = board) { row, col ->
            viewModel.makeMove(row, col)
        }
        Text("Winner: $winner")
    }

}