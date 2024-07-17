package com.example.bythen;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Response;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J?\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\b\b\u0001\u0010\t\u001a\u00020\b2\b\b\u0001\u0010\n\u001a\u00020\bH\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/example/bythen/CloudinaryService;", "", "uploadVideo", "Lretrofit2/Response;", "Lcom/example/bythen/UploadResponse;", "file", "Lokhttp3/MultipartBody$Part;", "uploadPreset", "Lokhttp3/RequestBody;", "publicId", "apiKey", "(Lokhttp3/MultipartBody$Part;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lokhttp3/RequestBody;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface CloudinaryService {
    
    @org.jetbrains.annotations.Nullable
    @retrofit2.http.POST(value = "dk3lhojel/video/upload")
    @retrofit2.http.Multipart
    public abstract java.lang.Object uploadVideo(@org.jetbrains.annotations.NotNull
    @retrofit2.http.Part
    okhttp3.MultipartBody.Part file, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Part(value = "upload_preset")
    okhttp3.RequestBody uploadPreset, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Part(value = "public_id")
    okhttp3.RequestBody publicId, @org.jetbrains.annotations.NotNull
    @retrofit2.http.Part(value = "api_key")
    okhttp3.RequestBody apiKey, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.bythen.UploadResponse>> continuation);
}