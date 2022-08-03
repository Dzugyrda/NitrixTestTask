package com.example.nitrixtesttask.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.nitrixtesttask.models.Video

@Dao
interface VideoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(video: Video): Long

    @Query("SELECT * FROM videos")
    fun getAllVideos(): LiveData<List<Video>>

    @Delete
    suspend fun deleteVideo(video: Video)
}