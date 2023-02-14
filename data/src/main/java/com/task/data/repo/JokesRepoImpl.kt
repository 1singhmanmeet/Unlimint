package com.task.data.repo

import com.task.data.local.JokeDao
import com.task.data.local.JokeModel
import com.task.data.remote.ApiService
import com.task.domain.repository.JokesRepo


class JokesRepoImpl(private val apiService: ApiService, private val jokeDao: JokeDao) : JokesRepo {
    override suspend fun getJokes(isFirst: Boolean): List<String> {

        try {
            if (isFirst) {
                return jokeDao.getJokes().map { it.joke }
            }
            val newJoke = apiService.getJokes()
            val jokesList=jokeDao.getJokes()
            if(jokesList.size==10){
                jokeDao.removeJoke(jokesList.first())
            }
            jokeDao.saveJoke(JokeModel(newJoke))
            return jokeDao.getJokes().map { it.joke }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return emptyList()
    }
}