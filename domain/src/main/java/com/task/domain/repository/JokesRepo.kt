package com.task.domain.repository

import kotlinx.coroutines.flow.Flow

interface JokesRepo {

    suspend fun getJokes(isFirst:Boolean): List<String>
}