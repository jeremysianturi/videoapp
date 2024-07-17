package com.example.bythen

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.bythen.utils.PermissionsUtil
import kotlinx.coroutines.launch
import android.provider.Settings

@Composable
fun PermissionRequestScreen() {
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

//    LaunchedEffect(key1 = Unit) {
//        if (!permissionGranted&& !permissionRequested) {
//            launcher.launch(Manifest.permission.READ_EXTERNAL_STORAGE)
//        }
//    }

    Column(modifier = Modifier.padding(16.dp)) {
        if (permissionGranted) {
            Text(text = "Izin Kamera telah diberikan")
        } else {
            Text(text = "Izin Kamera belum diberikan")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { launcher.launch(Manifest.permission.CAMERA) }) {
                Text(text = "Minta Izin Kamera")
            }

            if (showRationale) {
                AlertDialog(
                    onDismissRequest = { showRationale = false },
                    title = { Text(text = "Izin Diperlukan") },
                    text = { Text(text = "Aplikasi memerlukan izin kamera untuk melanjutkan. Silakan berikan izin di pengaturan.") },
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
                            Text(text = "Oke")
                        }
                    },
                    dismissButton = {
                        TextButton(onClick = { showRationale = false }) {
                            Text(text = "Batal")
                        }
                    }
                )
            }
        }
    }
}