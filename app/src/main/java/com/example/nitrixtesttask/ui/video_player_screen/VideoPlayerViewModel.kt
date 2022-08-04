package com.example.nitrixtesttask.ui.video_player_screen

import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.nitrixtesttask.repository.VideosRepository
import com.example.nitrixtesttask.ui.video_player_screen.model.VideoPlayer
import com.example.nitrixtesttask.ui.video_player_screen.model.toMediaItem
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class VideoPlayerViewState(
    val videos: VideoPlayer = VideoPlayer(),
    val isLoading: Boolean = true,
)


@HiltViewModel
class VideoPlayerViewModel @Inject constructor(
    private val videosRepository: VideosRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val videoId = savedStateHandle.get<Int>("id")
    val _viewState: MutableStateFlow<VideoPlayerViewState> = MutableStateFlow(VideoPlayerViewState())
    val viewState: StateFlow<VideoPlayerViewState>
        get() = _viewState

    init {
        viewModelScope.launch {
            var currentVideoPosition = 0
            val videoMediaItems = videosRepository.getVideos().mapIndexed { index, videoEntity ->
                if (videoId == videoEntity.id)
                    currentVideoPosition = index
                videoEntity.toMediaItem()
            }
            _viewState.value = VideoPlayerViewState(
                isLoading = false,
                videos = VideoPlayer(
                    videoMediaItems = videoMediaItems,
                    currentMediaItemPosition = currentVideoPosition,
                )
            )
        }
    }

}