package com.example.nitrixtesttask.repository

import com.example.nitrixtesttask.api.RetrofitInstance
import com.example.nitrixtesttask.db.VideoDatabase
import com.example.nitrixtesttask.models.Video
import com.example.nitrixtesttask.models.VideoResponse
import retrofit2.Response

class VideosRepository(
    val db: VideoDatabase
) {

    suspend fun getAllVideos(): Response<VideoResponse> {
        return RetrofitInstance.videosApi.getAllVideos()
    }

    suspend fun upsert(video: Video) = db.getVideoDao().upsert(video)

    fun getSavedVideos() = db.getVideoDao().getAllVideos()

    suspend fun deleteVideo(video: Video) = db.getVideoDao().deleteVideo(video)

}