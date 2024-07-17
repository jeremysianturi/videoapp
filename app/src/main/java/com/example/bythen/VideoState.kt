package com.example.bythen

data class VideoState(
    val isRecording: Boolean = false,
    val isUploading: Boolean = false,
    val errorMessage: String? = null
)
