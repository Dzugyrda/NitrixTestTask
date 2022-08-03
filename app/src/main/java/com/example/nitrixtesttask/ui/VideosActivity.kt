package com.example.nitrixtesttask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.nitrixtesttask.R
import com.example.nitrixtesttask.api.VideosApi
import com.example.nitrixtesttask.db.VideoDatabase
import com.example.nitrixtesttask.repository.VideosRepository

class VideosActivity : AppCompatActivity() {

    lateinit var viewModel: VideosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val videosRepository = VideosRepository(VideoDatabase(this))
        val viewModelProviderFactory = VideosViewModelProviderFactory(videosRepository)
        viewModel =
            ViewModelProvider(this, viewModelProviderFactory).get(VideosViewModel::class.java)
    }
}