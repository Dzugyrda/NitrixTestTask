package com.example.nitrixtesttask.repository.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.nitrixtesttask.repository.db.model.VideoEntity


@Database(
    entities = [VideoEntity::class],
    version = 1
)

@TypeConverters(Converters::class)
abstract class VideoDatabase : RoomDatabase() {

    abstract fun getVideoDao(): VideoDao

}