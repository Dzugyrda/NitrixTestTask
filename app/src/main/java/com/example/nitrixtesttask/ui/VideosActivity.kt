package com.example.nitrixtesttask.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.nitrixtesttask.R
import com.example.nitrixtesttask.repository.db.VideoDatabase
import com.example.nitrixtesttask.repository.VideosRepository

class VideosActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}