package com.example.nitrixtesttask.repository.api.model

import com.example.nitrixtesttask.repository.db.model.VideoEntity
import com.google.gson.annotations.SerializedName

data class VideoResponseItem(
    @SerializedName("description") val description: String,
    @SerializedName("sources") val sources: List<String>,
    @SerializedName("subtitle") val subtitle: String,
    @SerializedName("thumb") val thumb: String,
    @SerializedName("title") val title: String
)

fun VideoResponseItem.toEntity(): VideoEntity {
    return VideoEntity(
        description = description,
        sources = sources,
        subtitle = subtitle,
        thumb = thumb,
        title = title
    )
}