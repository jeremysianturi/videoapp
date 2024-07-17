package com.example.bythen.utils;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import androidx.core.content.ContextCompat;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\t"}, d2 = {"Lcom/example/bythen/utils/PermissionsUtil;", "", "()V", "hasCameraPermission", "", "context", "Landroid/content/Context;", "hasReadExternalStoragePermission", "hasWriteExternalStoragePermission", "app_debug"})
public final class PermissionsUtil {
    @org.jetbrains.annotations.NotNull
    public static final com.example.bythen.utils.PermissionsUtil INSTANCE = null;
    
    private PermissionsUtil() {
        super();
    }
    
    public final boolean hasCameraPermission(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return false;
    }
    
    public final boolean hasWriteExternalStoragePermission(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return false;
    }
    
    public final boolean hasReadExternalStoragePermission(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return false;
    }
}