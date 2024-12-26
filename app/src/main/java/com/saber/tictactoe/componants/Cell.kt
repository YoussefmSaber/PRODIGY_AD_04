package com.saber.tictactoe.componants

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.saber.tictactoe.ui.theme.`0-Player-Background`
import com.saber.tictactoe.ui.theme.`0-Player-Color`
import com.saber.tictactoe.ui.theme.`Cell-Background`
import com.saber.tictactoe.ui.theme.`Cell-Border`
import com.saber.tictactoe.ui.theme.`X-Player-Background`
import com.saber.tictactoe.ui.theme.`X-Player-Color`

@Composable
fun Cell(value: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier
            .clickable(onClick = onClick, enabled = value.isEmpty())
            .size(80.dp)
            .border(
                1.dp, shape = RoundedCornerShape(12.dp), color = when (value) {
                    "X" -> `X-Player-Color`
                    "O" -> `0-Player-Color`
                    else -> `Cell-Border`
                }
            )
            .background(
                color =
                when (value) {
                    "X" -> `X-Player-Background`
                    "O" -> `0-Player-Background`
                    else -> `Cell-Background`
                },
                shape = RoundedCornerShape(12.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            value,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            color = if (value == "X") `X-Player-Color` else `0-Player-Color`
        )
    }
}