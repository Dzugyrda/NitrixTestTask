package com.example.nitrixtesttask.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nitrixtesttask.repository.VideosRepository

class VideosViewModelProviderFactory(
    val videosRepository: VideosRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return VideosViewModel(videosRepository) as T
    }
}