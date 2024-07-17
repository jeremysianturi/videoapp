package com.example.bythen

import android.content.Context
import android.net.Uri
import android.util.Log
import android.widget.Toast
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

class VideoUploader @Inject constructor(
    @ApplicationContext private val context: Context,
    private val service: CloudinaryService
) {
    suspend fun uploadVideo(videoUri: Uri): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val videoFile = uriToFile(context, videoUri)
                if (videoFile != null) {
                    val requestBody = RequestBody.create("video/mp4".toMediaTypeOrNull(), videoFile)
                    val multipartBody = MultipartBody.Part.createFormData("file", videoFile.name, requestBody)

                    val uploadPreset = RequestBody.create("text/plain".toMediaTypeOrNull(), "ml_default")
                    val publicId = RequestBody.create("text/plain".toMediaTypeOrNull(), generatePublicId())
                    val apiKey = RequestBody.create("text/plain".toMediaTypeOrNull(), "764292367668433")

                    /* val videoFile = File(videoUri.path!!)
                val requestBody = RequestBody.create(MediaType.parse("video/mp4"), videoFile)
                val multipartBody = MultipartBody.Part.createFormData("file", videoFile.name, requestBody)*/

                    val response = service.uploadVideo(
                        file = multipartBody,
                        uploadPreset = uploadPreset,
                        publicId = publicId,
                        apiKey = apiKey
                    )

                    Log.d("Debug-test","data ::"+response.body())

                    if (response.isSuccessful) {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(context, "Upload successful!", Toast.LENGTH_LONG).show()
                        }
                        true
                    } else {
                        withContext(Dispatchers.Main) {
                            Toast.makeText(context, "Upload failed!", Toast.LENGTH_LONG).show()
                        }
                        false
                    }

                } else {
                    withContext(Dispatchers.Main) {
                        Toast.makeText(context, "Failed to convert URI to file.", Toast.LENGTH_LONG).show()
                    }
                    false
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Toast.makeText(context, "The Error: ${e.message}", Toast.LENGTH_LONG).show()
                }
                Log.d("TAG","The Error => ${e.message}")
                false
            }
        }
    }

    private fun generatePublicId(): String {
        val timestamp = System.currentTimeMillis()
        val dateFormat = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault())
        val date = Date(timestamp)
        return "video_${dateFormat.format(date)}"
    }

    private fun uriToFile(context: Context, uri: Uri): File? {
        val content = context.contentResolver
        val fileName = "${generatePublicId()}.mp4"
        val tempFile = File(context.cacheDir, fileName)

        try {
            content.openInputStream(uri)?.use { inputStream ->
                FileOutputStream(tempFile).use { outputStream ->
                    inputStream.copyTo(outputStream)
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }
        return tempFile
    }
}