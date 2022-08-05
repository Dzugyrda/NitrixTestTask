package com.example.nitrixtesttask.ui.videos_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nitrixtesttask.repository.VideosRepository
import com.example.nitrixtesttask.repository.db.model.toVideoItem
import com.example.nitrixtesttask.ui.videos_list.model.VideoItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

data class VideosViewState(
    val videos: List<VideoItem> = emptyList(),
    val isLoading: Boolean = true
)

@HiltViewModel
class VideosViewModel @Inject constructor(
    private val videosRepository: VideosRepository
) : ViewModel() {


    var viewState: StateFlow<VideosViewState> = videosRepository.observeVideos()
        .map { videosEntity ->
            VideosViewState(
                videos = videosEntity.map { videoEntity ->
                    videoEntity.toVideoItem()
                },
                isLoading = false
            )
        }
        .stateIn(viewModelScope, SharingStarted.Eagerly, VideosViewState())

    init {
        viewModelScope.launch {
            videosRepository.fetchVideos()
        }
    }
}


