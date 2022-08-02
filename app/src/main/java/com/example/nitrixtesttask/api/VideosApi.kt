package com.example.nitrixtesttask.api

import com.example.nitrixtesttask.models.VideoResponse
import retrofit2.Response
import retrofit2.http.GET

interface VideosApi {

    @GET("632e4c9f9c86ab2f36392301feaaff4c/raw/c2ec082fb02d673ec988af6511e9c41bb1e6b480/media_json.json")
    suspend fun getAllVideos(): Response<VideoResponse>
}