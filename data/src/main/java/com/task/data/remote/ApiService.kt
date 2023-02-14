package com.task.data.remote

import retrofit2.http.GET

interface ApiService {

    @GET("/api")
    suspend fun getJokes(): String
}