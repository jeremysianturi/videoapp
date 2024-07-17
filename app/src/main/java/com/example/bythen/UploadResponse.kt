package com.example.bythen

data class UploadResponse(
    val public_id: String,
    val version: Int,
    val width: Int,
    val height: Int,
    val format: String,
    val url: String,
    val secure_url: String
)
