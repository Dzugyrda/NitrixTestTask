package com.example.nitrixtesttask.api

import com.example.nitrixtesttask.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    val videosApi: VideosApi by lazy {
        retrofit.create(VideosApi::class.java)
    }
}