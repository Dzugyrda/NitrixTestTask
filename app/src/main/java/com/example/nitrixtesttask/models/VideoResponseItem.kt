package com.example.nitrixtesttask.models

data class VideoResponseItem(
    val description: String,
    val sources: List<String>,
    val subtitle: String,
    val thumb: String,
    val title: String
)