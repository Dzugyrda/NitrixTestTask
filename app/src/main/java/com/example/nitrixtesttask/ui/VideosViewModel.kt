package com.example.nitrixtesttask.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nitrixtesttask.models.Video
import com.example.nitrixtesttask.models.VideoResponse
import com.example.nitrixtesttask.repository.VideosRepository
import kotlinx.coroutines.launch

data class VideosViewState(
    val videos: VideoResponse? = null,
    val isSuccess: Boolean = false,
    val isError: Boolean = false,
    val isLoading: Boolean = false
)

class VideosViewModel(
    val videosRepository: VideosRepository
) : ViewModel() {

    val viewState = MutableLiveData(
        VideosViewState(isLoading = true)
    )

    init {
        viewModelScope.launch {
            val videosResponseResult = videosRepository.getAllVideos()
            when {
                videosResponseResult.isSuccessful -> {
                    viewState.postValue(
                        VideosViewState(
                            videos = videosResponseResult.body(),
                            isSuccess = true
                        )
                    )
                }
                !videosResponseResult.isSuccessful -> {
                    viewState.postValue(
                        VideosViewState(isError = true)
                    )
                }
            }

        }
    }

    fun saveVideo(video: Video) = viewModelScope.launch {
        videosRepository.upsert(video)
    }

    fun getSavedVideos() = videosRepository.getSavedVideos()

    fun deleteVideo(video: Video) = viewModelScope.launch {
        videosRepository.deleteVideo(video)
    }
}


