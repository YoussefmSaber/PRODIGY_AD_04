package com.saber.tictactoe.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TicTacToeApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TicTacToeApplication)
            modules(TicTacToeModule)
        }
    }
}