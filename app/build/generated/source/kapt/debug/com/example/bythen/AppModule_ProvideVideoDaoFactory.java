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
public final class AppModule_ProvideVideoDaoFactory implements Factory<VideoDao> {
  private final Provider<AppDatabase> databaseProvider;

  public AppModule_ProvideVideoDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public VideoDao get() {
    return provideVideoDao(databaseProvider.get());
  }

  public static AppModule_ProvideVideoDaoFactory create(Provider<AppDatabase> databaseProvider) {
    return new AppModule_ProvideVideoDaoFactory(databaseProvider);
  }

  public static VideoDao provideVideoDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideVideoDao(database));
  }
}
