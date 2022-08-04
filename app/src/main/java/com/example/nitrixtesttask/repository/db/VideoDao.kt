package com.example.nitrixtesttask.repository.db

import androidx.room.*
import com.example.nitrixtesttask.repository.db.model.VideoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface VideoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(videosEntity: List<VideoEntity>)

    @Query("SELECT * FROM videos")
    fun observeAllVideos(): Flow<List<VideoEntity>>

    @Query("SELECT * FROM videos")
    suspend fun getAllVideos(): List<VideoEntity>

    @Query("DELETE FROM videos")
    suspend fun deleteAllVideos()
}