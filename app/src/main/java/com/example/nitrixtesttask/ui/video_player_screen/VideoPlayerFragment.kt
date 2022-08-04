package com.example.nitrixtesttask.ui.video_player_screen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.nitrixtesttask.R
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.video_fragment.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class VideoPlayerFragment : Fragment(R.layout.video_player_fragment) {

    private val videoPlayerViewModel: VideoPlayerViewModel by viewModels()

    @Inject
    lateinit var exoPLayer: ExoPlayer

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        playerView.player = exoPLayer
        lifecycleScope.launch {
            videoPlayerViewModel.viewState.collect { videoPlayerViewState ->
                when {
                    videoPlayerViewState.isLoading -> {}
                    videoPlayerViewState.videos.videoMediaItems.isNotEmpty() -> {
                        addVideos(
                            videoPlayerViewState.videos.videoMediaItems,
                            videoPlayerViewState.videos.currentMediaItemPosition
                        )
                        exoPLayer.prepare()
                        exoPLayer.playWhenReady = true
                    }
                }

            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        exoPLayer.stop()
    }

    private fun addVideos(mediaItems: List<MediaItem>, playItemPosition: Int) {
        exoPLayer.addMediaItems(mediaItems)
        exoPLayer.seekToDefaultPosition(playItemPosition)
    }


}