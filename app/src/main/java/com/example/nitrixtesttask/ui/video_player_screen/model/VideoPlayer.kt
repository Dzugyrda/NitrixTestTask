package com.example.nitrixtesttask.ui.video_player_screen.model

import com.example.nitrixtesttask.repository.db.model.VideoEntity
import com.google.android.exoplayer2.MediaItem

data class VideoPlayer(
    val videoMediaItems: List<MediaItem> = emptyList(),
    val currentMediaItemPosition: Int = -1,
)

fun VideoEntity.toMediaItem(): MediaItem {
    return MediaItem.fromUri(sources[0])
}