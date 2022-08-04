package com.example.nitrixtesttask.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nitrixtesttask.repository.db.model.VideoEntity
import com.example.nitrixtesttask.repository.VideosRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class VideosViewState(
    val videos: List<VideoEntity> = emptyList(),
    val isSuccess: Boolean = false,
    val isError: Boolean = false,
    val isLoading: Boolean = true
)

class VideosViewModel() : ViewModel() {

    private val videosRepository: VideosRepository = VideosRepository()

    val viewState: StateFlow<VideosViewState> = videosRepository.observeVideos()
        .map { videos ->
            VideosViewState(videos = videos)
        }
        .stateIn(viewModelScope, SharingStarted.Eagerly, VideosViewState())

    init {
        viewModelScope.launch {
            videosRepository.fetchVideos()
        }
    }
}


