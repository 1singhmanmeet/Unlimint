package com.task.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.task.domain.repository.JokesRepo

@Database(entities = [JokeModel::class], version = 1, exportSchema = false)
abstract class JokesDatabase:RoomDatabase() {

    abstract fun jokesDao():JokeDao

    companion object{
        private var instance: JokesDatabase? = null

        fun getInstance(context: Context): JokesDatabase {
            if(instance == null)
                instance = Room.databaseBuilder(context.applicationContext, JokesDatabase::class.java,
                    "jokes_database")
                    .fallbackToDestructiveMigration()
                    .build()

            return instance!!

        }
    }
}