package com.example.bythen

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.util.Log
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.TextButton
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.example.bythen.utils.PermissionsUtil
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.ui.PlayerView
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VideoRecorderScreen(
    viewModel: VideoRecorderViewModel,
    videoUri: Uri?,
    onRecordVideo: () -> Unit,
    onUploadVideo: () -> Unit
) {
    val state by viewModel.state.collectAsState()
    val context = LocalContext.current

    val coroutineScope = rememberCoroutineScope()
    var showRationale by remember { mutableStateOf(false) }
    var permissionRequested by remember { mutableStateOf(false) }
    var permissionGranted by remember { mutableStateOf(PermissionsUtil.hasReadExternalStoragePermission(context)) }

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted: Boolean ->
        permissionGranted = isGranted
        if (!isGranted) {
            showRationale = true
        } else {
            showRationale = false
            permissionRequested = false
        }
    }



    val exoPlayer = remember {
        ExoPlayer.Builder(context).build().apply {
            videoUri?.let {
                val mediaItem = MediaItem.fromUri(it)
                setMediaItem(mediaItem)
                prepare()
            }
        }
    }

    DisposableEffect(Unit) {
        onDispose {
            exoPlayer.release()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Video Recorder") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            if (state.isRecording) {
                Button(onClick = { viewModel.stopRecording() }) {
                    Text(text = "Stop Recording")
                }
            } else {
                Button(onClick = onRecordVideo) {
                    Text(text = "Start Recording")
                }
//                Button(onClick = {
//                    if (!PermissionsUtil.hasCameraPermission(context)) {
//                        launcher.launch(Manifest.permission.CAMERA)
//                        Log.d("debug-bus","masuk")
//                    } else {
//                        Log.d("debug-bus","out")
//                        onRecordVideo
//                    }
//                }) {
//                    Text(text = "Start Recording")
//                }
            }


            if (showRationale) {
                AlertDialog(
                    onDismissRequest = { showRationale = false },
                    title = { androidx.compose.material.Text(text = "Izin Diperlukan") },
                    text = { androidx.compose.material.Text(text = "Aplikasi memerlukan izin kamera untuk melanjutkan. Silakan berikan izin di pengaturan.") },
                    confirmButton = {
                        TextButton(onClick = {
                            showRationale = false
                            coroutineScope.launch {
                                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS).apply {
                                    data = Uri.fromParts("package", context.packageName, null)
                                }
                                context.startActivity(intent)
                            }
                        }) {
                            androidx.compose.material.Text(text = "Oke")
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = { showRationale = false }) {
                            androidx.compose.material.Text(text = "Batal")
                        }
                    }
                )
            }



            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onUploadVideo,
                enabled = !state.isUploading
            ) {
                Text(text = "Upload Video")
            }

            if (state.isUploading) {
                Spacer(modifier = Modifier.height(16.dp))
                CircularProgressIndicator()
            }

            state.errorMessage?.let {
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = it, color = MaterialTheme.colorScheme.error)
            }

            Spacer(modifier = Modifier.height(16.dp))

            videoUri?.let {
                AndroidView(
                    factory = {
                        PlayerView(context).apply {
                            player = exoPlayer
                        }
                    },
                    update = {
                        exoPlayer.setMediaItem(MediaItem.fromUri(videoUri))
                        exoPlayer.prepare()
                        exoPlayer.playWhenReady = true
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                )
            } ?: run {
                Text("No video recorded yet.")
            }
        }
    }
}