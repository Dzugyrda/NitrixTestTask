package com.example.nitrixtesttask.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nitrixtesttask.repository.VideosRepository

class VideosViewModelProviderFactory(
    private val videosRepository: VideosRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return VideosViewModel() as T
    }
}