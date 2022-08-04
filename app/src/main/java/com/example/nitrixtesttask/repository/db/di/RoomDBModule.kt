package com.example.nitrixtesttask.repository.db.di

import android.content.Context
import androidx.room.Room
import com.example.nitrixtesttask.repository.db.VideoDao
import com.example.nitrixtesttask.repository.db.VideoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class RoomDBModule {

    @Provides
    @Singleton
    fun provideVideoDao(appDatabase: VideoDatabase): VideoDao {
        return appDatabase.getVideoDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): VideoDatabase {
        return Room.databaseBuilder(
            appContext,
            VideoDatabase::class.java,
            "videos_db.db"
        ).build()
    }


}