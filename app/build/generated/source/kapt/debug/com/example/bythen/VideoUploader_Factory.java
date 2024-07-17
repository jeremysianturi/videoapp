package com.example.bythen;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class VideoUploader_Factory implements Factory<VideoUploader> {
  private final Provider<Context> contextProvider;

  private final Provider<CloudinaryService> serviceProvider;

  public VideoUploader_Factory(Provider<Context> contextProvider,
      Provider<CloudinaryService> serviceProvider) {
    this.contextProvider = contextProvider;
    this.serviceProvider = serviceProvider;
  }

  @Override
  public VideoUploader get() {
    return newInstance(contextProvider.get(), serviceProvider.get());
  }

  public static VideoUploader_Factory create(Provider<Context> contextProvider,
      Provider<CloudinaryService> serviceProvider) {
    return new VideoUploader_Factory(contextProvider, serviceProvider);
  }

  public static VideoUploader newInstance(Context context, CloudinaryService service) {
    return new VideoUploader(context, service);
  }
}
