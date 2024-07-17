package com.example.bythen

import android.net.Uri
import javax.inject.Inject

class VideoRepository @Inject constructor(
    private val videoDao: VideoDao,
    private val videoUploader: VideoUploader
) {
    suspend fun uploadVideo(videoUri: Uri): Boolean {
        return videoUploader.uploadVideo(videoUri).also { success ->
            if (success) {
                videoDao.insertVideo(VideoEntity(id = 0, uri = videoUri.toString()))
            }
        }
    }

    suspend fun getAllVideos() = videoDao.getAllVideos()
}