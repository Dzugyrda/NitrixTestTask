package com.example.nitrixtesttask.models

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(
    tableName = "videos"
)
data class Video(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val description: String,
    val sources: List<String>,
    val subtitle: String,
    val thumb: String,
    val title: String
)