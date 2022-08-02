package com.example.nitrixtesttask.repository

import com.example.nitrixtesttask.api.RetrofitInstance
import com.example.nitrixtesttask.api.VideosApi
import com.example.nitrixtesttask.models.VideoResponse
import retrofit2.Response

class VideosRepository {

    suspend fun getAllVideos(): Response<VideoResponse> {
        return RetrofitInstance.videosApi.getAllVideos()
    }

}