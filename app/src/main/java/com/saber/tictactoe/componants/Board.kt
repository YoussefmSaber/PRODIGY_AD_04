package com.saber.tictactoe.componants

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Board(value: Array<Array<String>>, onCellClick: (row: Int, col: Int) -> Unit) {
    Column {
        for (row in value.indices) {
            Row {
                for (col in value[row].indices) {
                    Box(modifier = Modifier.padding(4.dp)) {
                        Cell(
                            value = value[row][col],
                            onClick = { onCellClick(row, col) }
                        )
                    }
                }
            }
        }
    }
}