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
public final class VideoRecorderViewModel_Factory implements Factory<VideoRecorderViewModel> {
  private final Provider<VideoRepository> videoRepositoryProvider;

  public VideoRecorderViewModel_Factory(Provider<VideoRepository> videoRepositoryProvider) {
    this.videoRepositoryProvider = videoRepositoryProvider;
  }

  @Override
  public VideoRecorderViewModel get() {
    return newInstance(videoRepositoryProvider.get());
  }

  public static VideoRecorderViewModel_Factory create(
      Provider<VideoRepository> videoRepositoryProvider) {
    return new VideoRecorderViewModel_Factory(videoRepositoryProvider);
  }

  public static VideoRecorderViewModel newInstance(VideoRepository videoRepository) {
    return new VideoRecorderViewModel(videoRepository);
  }
}
