package com.example.nitrixtesttask.repository

import android.util.Log
import androidx.room.withTransaction
import com.example.nitrixtesttask.repository.api.VideosApi
import com.example.nitrixtesttask.repository.api.model.toEntity
import com.example.nitrixtesttask.repository.db.model.VideoEntity
import com.example.nitrixtesttask.repository.db.VideoDao
import com.example.nitrixtesttask.repository.db.VideoDatabase
import kotlinx.coroutines.flow.Flow
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VideosRepository @Inject constructor(
    private val videosDao: VideoDao,
    private val appDb: VideoDatabase,
    private val videosApi: VideosApi
) {

    suspend fun fetchVideos(): Boolean {
        try {
            val apiResult = videosApi.getAllVideos()
            if (apiResult.isSuccessful) {
                val data = apiResult.body() ?: emptyList()
                appDb.withTransaction {
                    videosDao.deleteAllVideos()
                    videosDao.insertAll(data.map { videoResponseItem ->
                        videoResponseItem.toEntity()
                    })
                }
            }
        } catch (ex: Exception) {
            Log.d("RETROFIT", ex.toString())
        }
        return false//apiResult.isSuccessful
    }

    fun observeVideos(): Flow<List<VideoEntity>> = videosDao.observeAllVideos()

    suspend fun getVideos(): List<VideoEntity> = videosDao.getAllVideos()
}