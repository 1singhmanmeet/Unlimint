package com.task.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "jokes")
data class JokeModel(
    @ColumnInfo(name = "joke") val joke:String,
    @PrimaryKey(autoGenerate = true)
    var id:Int=0
)