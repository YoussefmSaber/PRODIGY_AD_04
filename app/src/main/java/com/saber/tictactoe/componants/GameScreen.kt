package com.saber.tictactoe.componants

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saber.tictactoe.ui.theme.`0-Player-Background`
import com.saber.tictactoe.ui.theme.`0-Player-Color`
import com.saber.tictactoe.ui.theme.`Board-Background`
import com.saber.tictactoe.ui.theme.`X-Player-Background`
import com.saber.tictactoe.ui.theme.`X-Player-Color`
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
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth(0.7F)
        ) {
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = if (currentPlayer == "X") `X-Player-Background` else Color(
                        0xFF003049
                    )
                )
            ) {
                Text(
                    "Player X", modifier = Modifier.padding(8.dp), fontSize = 18.sp,
                    color = if (currentPlayer == "X") `X-Player-Color` else Color.White
                )
            }
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = if (currentPlayer == "O") `0-Player-Background` else Color(
                        0xFF003049
                    )
                )
            ) {
                Text(
                    "Player O", modifier = Modifier.padding(8.dp),
                    color = if (currentPlayer == "O") `0-Player-Color` else Color.White
                )
            }
        }
        Spacer(Modifier.height(16.dp))
        Box(
            modifier = Modifier
                .background(`Board-Background`, shape = RoundedCornerShape(12.dp))
                .padding(16.dp)
        ) {
            Board(value = board) { row, col ->
                viewModel.makeMove(row, col)
            }
        }
        Spacer(Modifier.height(16.dp))
        Card(colors = CardDefaults.cardColors(containerColor = if (winner != null) Color(0xFFBDE2D2) else Color.Transparent)) {
            Text(
                if (winner != null) "Winner: $winner" else "",
                color = Color(0xFF00c096),
                fontSize = 16.sp,
                modifier = Modifier.padding(8.dp)
            )
        }

        Spacer(Modifier.height(32.dp))
        if (winner != null)
            Button(onClick = {
                viewModel.resetBoard()
            }) {
                Text("Reset Game")
            }
    }
}