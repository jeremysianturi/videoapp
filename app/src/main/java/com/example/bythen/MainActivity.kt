package com.example.bythen

import android.Manifest
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.core.content.FileProvider
import com.example.bythen.utils.PermissionsUtil
import dagger.hilt.android.AndroidEntryPoint
import java.io.File
import java.io.IOException

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: VideoRecorderViewModel by viewModels()
    private var videoUri by mutableStateOf<Uri?>(null)

    private val requestCameraPermission = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
        Log.d("MainActivity", "Camera permission granted: $isGranted")
        if (isGranted) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
                checkReadPermissionAndRecord()
            } else {
                startRecordingVideo()
            }
        }
    }

    private val requestReadPermission = registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
        Log.d("MainActivity", "Read permission granted: $isGranted")
        if (isGranted) {
            startRecordingVideo()
        } else {
            Log.d("MainActivity", "Read permission denied")
        }
    }

//    private val recordVideo = registerForActivityResult(ActivityResultContracts.CaptureVideo()) { uri: Uri? ->
//        Log.d("MainActivity", "Video recorded successfully: $uri")
//        uri?.let {
//            videoUri = it
//            Toast.makeText(this, "Successfully took the video", Toast.LENGTH_SHORT).show()
//        }
//    }

    private val recordVideo = registerForActivityResult(ActivityResultContracts.CaptureVideo()) { isSuccess ->
        Log.d("MainActivity", "Video recorded successfully: $isSuccess")
        if (isSuccess) {
            Toast.makeText(this, "Successfull take the video", Toast.LENGTH_SHORT).show()
        }
    }

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "onCreate called")

        setContent {
            MaterialTheme {
                Surface {
                    VideoRecorderScreen(
                        viewModel = viewModel,
                        videoUri = videoUri,
                        onRecordVideo = {
                            Log.d("MainActivity", "onRecordVideo called $videoUri")
                            if (PermissionsUtil.hasCameraPermission(this)) {

                                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
                                    checkReadPermissionAndRecord()
                                } else {
                                    startRecordingVideo()
                                }
                            } else {
                                requestCameraPermission.launch(Manifest.permission.CAMERA)
                            }
                        },
                        onUploadVideo = {
                            Log.d("MainActivity", "onUploadVideo called $videoUri")
                            if (videoUri != null) {
                                videoUri?.let {
                                    viewModel.uploadVideo(it)
                                }
                            } else {
                                Toast.makeText(this, "Video has not been selected", Toast.LENGTH_LONG).show()
                            }
                        }
                    )
                }
            }
        }
    }

    private fun checkReadPermissionAndRecord() {
        Log.d("MainActivity", "checkReadPermissionAndRecord called")
        if (PermissionsUtil.hasReadExternalStoragePermission(this)) {
            startRecordingVideo()
        } else {
            requestReadPermission.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
        }
    }

    private fun startRecordingVideo() {
        Log.d("MainActivity", "startRecordingVideo called")
        val appSpecificExternalDir = getExternalFilesDir(Environment.DIRECTORY_MOVIES)

        // Ensure the directory exists
        appSpecificExternalDir?.let {
            if (!it.exists()) {
                it.mkdirs()  // Create the directory if it does not exist
            }

            val videoFile = File(it, "my_video.mp4")
            try {
                if (!videoFile.exists()) {
                    videoFile.createNewFile()
                }
                videoUri = FileProvider.getUriForFile(this, "${packageName}.provider", videoFile)
                Log.d("MainActivity", "Video URI: $videoUri")
                recordVideo.launch(videoUri)
            } catch (e: IOException) {
                e.printStackTrace()
                Log.e("MainActivity", "Error creating video file", e)
            }
        } ?: run {
            Log.e("MainActivity", "External storage is not available")
        }
    }
}