package com.example.bythen;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class AppModule_ProvideVideoUploaderFactory implements Factory<VideoUploader> {
  private final Provider<Context> contextProvider;

  private final Provider<CloudinaryService> serviceProvider;

  public AppModule_ProvideVideoUploaderFactory(Provider<Context> contextProvider,
      Provider<CloudinaryService> serviceProvider) {
    this.contextProvider = contextProvider;
    this.serviceProvider = serviceProvider;
  }

  @Override
  public VideoUploader get() {
    return provideVideoUploader(contextProvider.get(), serviceProvider.get());
  }

  public static AppModule_ProvideVideoUploaderFactory create(Provider<Context> contextProvider,
      Provider<CloudinaryService> serviceProvider) {
    return new AppModule_ProvideVideoUploaderFactory(contextProvider, serviceProvider);
  }

  public static VideoUploader provideVideoUploader(Context context, CloudinaryService service) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideVideoUploader(context, service));
  }
}
