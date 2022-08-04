package com.example.nitrixtesttask.repository.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.nitrixtesttask.ui.videos_list.model.VideoItem


@Entity(
    tableName = "videos"
)
data class VideoEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val description: String,
    val sources: List<String>,
    val subtitle: String,
    val thumb: String,
    val title: String
)

fun VideoEntity.toVideoItem(): VideoItem {
    return VideoItem(
        id = id ?: -1,
        description = description,
        title = title,
        subtitle = subtitle,
        prevImageUrl = thumb
    )
}