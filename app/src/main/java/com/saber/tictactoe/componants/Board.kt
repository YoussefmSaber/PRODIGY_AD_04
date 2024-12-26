package com.saber.tictactoe.componants

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun Board(value: Array<Array<String>>, onCellClick: (row: Int, col: Int) -> Unit) {
    Column(modifier = Modifier.background(Color.Transparent)) {
        for (row in value.indices) {
            Row {
                for (col in value[row].indices) {
                    Cell(
                        value = value[row][col],
                        onClick = { onCellClick(row, col) }
                    )
                }
            }
        }
    }
}