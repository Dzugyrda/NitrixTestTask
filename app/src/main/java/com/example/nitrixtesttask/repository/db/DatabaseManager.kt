package com.example.nitrixtesttask.repository.db

import android.content.Context
import androidx.room.Room

object DatabaseManager {

    private lateinit var instance: VideoDatabase

    fun initDataBase(appContext: Context) {
       instance = Room.databaseBuilder(
            appContext,
            VideoDatabase::class.java,
            "videos_db.db"
        ).build()
    }

    fun getDb() = instance
}