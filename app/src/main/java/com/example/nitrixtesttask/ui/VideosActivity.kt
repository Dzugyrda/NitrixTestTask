package com.example.nitrixtesttask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.nitrixtesttask.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}