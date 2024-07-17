package com.example.bythen;

import android.net.Uri;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0019\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/example/bythen/VideoRepository;", "", "videoDao", "Lcom/example/bythen/VideoDao;", "videoUploader", "Lcom/example/bythen/VideoUploader;", "(Lcom/example/bythen/VideoDao;Lcom/example/bythen/VideoUploader;)V", "getAllVideos", "", "Lcom/example/bythen/VideoEntity;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadVideo", "", "videoUri", "Landroid/net/Uri;", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class VideoRepository {
    private final com.example.bythen.VideoDao videoDao = null;
    private final com.example.bythen.VideoUploader videoUploader = null;
    
    @javax.inject.Inject
    public VideoRepository(@org.jetbrains.annotations.NotNull
    com.example.bythen.VideoDao videoDao, @org.jetbrains.annotations.NotNull
    com.example.bythen.VideoUploader videoUploader) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object uploadVideo(@org.jetbrains.annotations.NotNull
    android.net.Uri videoUri, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.lang.Boolean> continuation) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object getAllVideos(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super java.util.List<com.example.bythen.VideoEntity>> continuation) {
        return null;
    }
}