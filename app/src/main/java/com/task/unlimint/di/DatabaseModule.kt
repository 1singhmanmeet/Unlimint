package com.task.unlimint.di

import android.content.Context
import com.task.data.local.JokeDao
import com.task.data.local.JokesDatabase
import com.task.data.remote.ApiService
import com.task.data.repo.JokesRepoImpl
import com.task.domain.repository.JokesRepo
import com.task.domain.usecase.JokesUseCase
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

fun createJokesRepo(apiService: ApiService,jokesDatabase: JokesDatabase): JokesRepo {
    return JokesRepoImpl(apiService,jokesDatabase.jokesDao())
}

fun createJokesUseCase(jokesRepo: JokesRepo): JokesUseCase {
    return JokesUseCase(jokesRepo)
}