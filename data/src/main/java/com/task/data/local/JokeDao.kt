package com.task.data.local

import androidx.room.*

@Dao
interface JokeDao {

    @Query("SELECT * FROM jokes ORDER BY id ASC")
    suspend fun getJokes():List<JokeModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveJoke(joke:JokeModel)

    @Delete
    suspend fun removeJoke(joke:JokeModel)
}