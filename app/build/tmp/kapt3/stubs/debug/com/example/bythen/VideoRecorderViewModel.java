package com.example.bythen;

import android.net.Uri;
import androidx.lifecycle.ViewModel;
import dagger.hilt.android.lifecycle.HiltViewModel;
import javax.inject.Inject;
import kotlinx.coroutines.flow.StateFlow;

@dagger.hilt.android.lifecycle.HiltViewModel
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\u000e\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/bythen/VideoRecorderViewModel;", "Landroidx/lifecycle/ViewModel;", "videoRepository", "Lcom/example/bythen/VideoRepository;", "(Lcom/example/bythen/VideoRepository;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/example/bythen/VideoState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "startRecording", "", "stopRecording", "uploadVideo", "videoUri", "Landroid/net/Uri;", "app_debug"})
public final class VideoRecorderViewModel extends androidx.lifecycle.ViewModel {
    private final com.example.bythen.VideoRepository videoRepository = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<com.example.bythen.VideoState> _state = null;
    @org.jetbrains.annotations.NotNull
    private final kotlinx.coroutines.flow.StateFlow<com.example.bythen.VideoState> state = null;
    
    @javax.inject.Inject
    public VideoRecorderViewModel(@org.jetbrains.annotations.NotNull
    com.example.bythen.VideoRepository videoRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<com.example.bythen.VideoState> getState() {
        return null;
    }
    
    public final void startRecording() {
    }
    
    public final void stopRecording() {
    }
    
    public final void uploadVideo(@org.jetbrains.annotations.NotNull
    android.net.Uri videoUri) {
    }
}