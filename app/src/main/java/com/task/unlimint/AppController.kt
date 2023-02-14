package com.task.unlimint

import android.app.Application
import android.util.Log
import com.task.unlimint.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AppController:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(org.koin.core.logger.Level.DEBUG)
            androidContext(this@AppController)
            modules(listOf(AppModule,NetworkModule,DatabaseModule))
        }
    }
}