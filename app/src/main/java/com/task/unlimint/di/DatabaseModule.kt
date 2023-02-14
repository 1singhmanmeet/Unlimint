package com.task.unlimint.di

import android.content.Context
import com.task.data.local.JokeDao
import com.task.data.local.JokesDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val DatabaseModule= module {
    single { createDatabase(androidContext()) }
    single { createUseCaseDao(get())}
}

fun createDatabase(context: Context):JokesDatabase{
    return JokesDatabase.getInstance(context)
}

fun createUseCaseDao(jokesDatabase: JokesDatabase):JokeDao{
    return jokesDatabase.jokesDao()
}