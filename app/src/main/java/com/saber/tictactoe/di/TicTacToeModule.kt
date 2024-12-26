package com.saber.tictactoe.di

import com.saber.tictactoe.viewmodel.TicTacToeViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val TicTacToeModule = module {
    viewModel { TicTacToeViewModel() }
}