package com.example.nitrixtesttask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nitrixtesttask.R
import com.example.nitrixtesttask.api.VideosApi
import com.example.nitrixtesttask.repository.VideosRepository

class VideosActivity : AppCompatActivity() {

    lateinit var viewModel: VideosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}