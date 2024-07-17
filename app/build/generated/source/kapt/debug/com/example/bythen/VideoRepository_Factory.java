package com.example.bythen;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class VideoRepository_Factory implements Factory<VideoRepository> {
  private final Provider<VideoDao> videoDaoProvider;

  private final Provider<VideoUploader> videoUploaderProvider;

  public VideoRepository_Factory(Provider<VideoDao> videoDaoProvider,
      Provider<VideoUploader> videoUploaderProvider) {
    this.videoDaoProvider = videoDaoProvider;
    this.videoUploaderProvider = videoUploaderProvider;
  }

  @Override
  public VideoRepository get() {
    return newInstance(videoDaoProvider.get(), videoUploaderProvider.get());
  }

  public static VideoRepository_Factory create(Provider<VideoDao> videoDaoProvider,
      Provider<VideoUploader> videoUploaderProvider) {
    return new VideoRepository_Factory(videoDaoProvider, videoUploaderProvider);
  }

  public static VideoRepository newInstance(VideoDao videoDao, VideoUploader videoUploader) {
    return new VideoRepository(videoDao, videoUploader);
  }
}
