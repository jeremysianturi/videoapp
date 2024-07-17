package com.example.bythen;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class AppModule_ProvideVideoRepositoryFactory implements Factory<VideoRepository> {
  private final Provider<VideoDao> videoDaoProvider;

  private final Provider<VideoUploader> videoUploaderProvider;

  public AppModule_ProvideVideoRepositoryFactory(Provider<VideoDao> videoDaoProvider,
      Provider<VideoUploader> videoUploaderProvider) {
    this.videoDaoProvider = videoDaoProvider;
    this.videoUploaderProvider = videoUploaderProvider;
  }

  @Override
  public VideoRepository get() {
    return provideVideoRepository(videoDaoProvider.get(), videoUploaderProvider.get());
  }

  public static AppModule_ProvideVideoRepositoryFactory create(Provider<VideoDao> videoDaoProvider,
      Provider<VideoUploader> videoUploaderProvider) {
    return new AppModule_ProvideVideoRepositoryFactory(videoDaoProvider, videoUploaderProvider);
  }

  public static VideoRepository provideVideoRepository(VideoDao videoDao,
      VideoUploader videoUploader) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideVideoRepository(videoDao, videoUploader));
  }
}
