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

    companion object {
        @Volatile
        private var instance: VideoDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                VideoDatabase::class.java,
                "videos_db.db"
            ).build()

    }
}