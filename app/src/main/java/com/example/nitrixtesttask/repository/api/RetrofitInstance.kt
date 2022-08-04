package com.example.nitrixtesttask.repository.api

import com.example.nitrixtesttask.repository.api.Constants.Companion.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .build()
            )
            .build()
    }

    val videosApi: VideosApi by lazy {
        retrofit.create(VideosApi::class.java)
    }
}