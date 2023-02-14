package com.task.data.repo

import com.task.data.local.JokeDao
import com.task.data.local.JokeModel
import com.task.data.remote.ApiService
import com.task.domain.repository.JokesRepo


class JokesRepoImpl(private val apiService: ApiService, private val jokeDao: JokeDao) : JokesRepo {
    override suspend fun getJokes(isFirst: Boolean): List<String> {

        try {
            if (isFirst) {
                val savedJokes=jokeDao.getJokes().map { it.joke }
                if(savedJokes.isNotEmpty())
                    return savedJokes
            }
            val newJoke = apiService.getJokes()
            val jokesList=jokeDao.getJokes().toMutableList()
            if(jokesList.size==10){
                jokesList.removeAt(0)
                jokeDao.removeJoke(jokesList.first())
            }
            jokeDao.saveJoke(JokeModel(newJoke))
            val finalList=jokesList.map { it.joke }.toMutableList()
            finalList.add(newJoke)
            return finalList
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return emptyList()
    }
}