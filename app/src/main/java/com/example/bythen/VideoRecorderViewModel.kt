package com.example.bythen

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

@HiltViewModel
class VideoRecorderViewModel @Inject constructor(
    private val videoRepository: VideoRepository
) : ViewModel() {

    private val _state = MutableStateFlow(VideoState())
    val state: StateFlow<VideoState> = _state

    fun startRecording() {
        _state.value = _state.value.copy(isRecording = true)
    }

    fun stopRecording() {
        _state.value = _state.value.copy(isRecording = false)
    }

    fun uploadVideo(videoUri: Uri) {
        viewModelScope.launch {
            _state.value = _state.value.copy(isUploading = true)
            val success = videoRepository.uploadVideo(videoUri)
            _state.value = _state.value.copy(isUploading = false)

            if (!success) {
                _state.value = _state.value.copy(errorMessage = "Upload failed")
            }
        }
    }
}
