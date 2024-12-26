package com.saber.tictactoe.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TicTacToeViewModel : ViewModel() {

    // Board is a StateFlow, which will notify composables of changes
    private val _board = MutableStateFlow(Array(3) { Array(3) { "" } })
    val board: StateFlow<Array<Array<String>>> = _board

    private val _currentPlayer = MutableStateFlow("X")
    val currentPlayer: StateFlow<String> = _currentPlayer

    private val _winner = MutableStateFlow<String?>(null)
    val winner: StateFlow<String?> = _winner

    fun makeMove(row: Int, col: Int) {
        if (_board.value[row][col].isEmpty() && _winner.value == null) {
            val newBoard = _board.value.copyOf()
            newBoard[row][col] = _currentPlayer.value
            _board.value = newBoard
            checkWinner()
            togglePlayer()
        }
    }

    private fun togglePlayer() {
        _currentPlayer.value = if (_currentPlayer.value == "X") "O" else "X"
    }

    private fun checkWinner() {
        val board = _board.value
        val n = board.size

        // Check rows
        for (i in 0 until n) {
            if (board[i][0].isNotEmpty() && board[i].all { it == board[i][0] }) {
                _winner.value = board[i][0]
                return
            }
        }

        // Check columns
        for (j in 0 until n) {
            if (board[0][j].isNotEmpty() && (0 until n).all { board[it][j] == board[0][j] }) {
                _winner.value = board[0][j]
                return
            }
        }

        // Check diagonals
        if (board[0][0].isNotEmpty() && (0 until n).all { board[it][it] == board[0][0] }) {
            _winner.value = board[0][0]
            return
        }
        if (board[0][n - 1].isNotEmpty() && (0 until n).all { board[it][n - 1 - it] == board[0][n - 1] }) {
            _winner.value = board[0][n - 1]
            return
        }

        // Check for draw
        if (board.all { row -> row.all { it.isNotEmpty() } }) {
            _winner.value = "Draw"
        }

    }
}