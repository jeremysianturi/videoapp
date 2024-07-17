package com.example.bythen;

import android.Manifest;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;
import androidx.activity.ComponentActivity;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.RequiresApi;
import androidx.core.content.FileProvider;
import com.example.bythen.utils.PermissionsUtil;
import dagger.hilt.android.AndroidEntryPoint;
import java.io.File;
import java.io.IOException;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0015J\b\u0010\u001d\u001a\u00020\u0019H\u0002R\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\b0\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\b0\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R/\u0010\u000b\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u00058B@BX\u0082\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001e"}, d2 = {"Lcom/example/bythen/MainActivity;", "Landroidx/activity/ComponentActivity;", "()V", "recordVideo", "Landroidx/activity/result/ActivityResultLauncher;", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "requestCameraPermission", "", "requestReadPermission", "<set-?>", "videoUri", "getVideoUri", "()Landroid/net/Uri;", "setVideoUri", "(Landroid/net/Uri;)V", "videoUri$delegate", "Landroidx/compose/runtime/MutableState;", "viewModel", "Lcom/example/bythen/VideoRecorderViewModel;", "getViewModel", "()Lcom/example/bythen/VideoRecorderViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "checkReadPermissionAndRecord", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "startRecordingVideo", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint
public final class MainActivity extends androidx.activity.ComponentActivity {
    private final kotlin.Lazy viewModel$delegate = null;
    private final androidx.compose.runtime.MutableState videoUri$delegate = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> requestCameraPermission = null;
    private final androidx.activity.result.ActivityResultLauncher<java.lang.String> requestReadPermission = null;
    private final androidx.activity.result.ActivityResultLauncher<android.net.Uri> recordVideo = null;
    
    public MainActivity() {
        super();
    }
    
    private final com.example.bythen.VideoRecorderViewModel getViewModel() {
        return null;
    }
    
    private final android.net.Uri getVideoUri() {
        return null;
    }
    
    private final void setVideoUri(android.net.Uri p0) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    @java.lang.Override
    protected void onCreate(@org.jetbrains.annotations.Nullable
    android.os.Bundle savedInstanceState) {
    }
    
    private final void checkReadPermissionAndRecord() {
    }
    
    private final void startRecordingVideo() {
    }
}