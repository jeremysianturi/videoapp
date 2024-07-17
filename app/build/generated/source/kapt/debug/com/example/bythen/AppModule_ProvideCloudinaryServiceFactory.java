package com.example.bythen;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

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
public final class AppModule_ProvideCloudinaryServiceFactory implements Factory<CloudinaryService> {
  private final Provider<Retrofit> retrofitProvider;

  public AppModule_ProvideCloudinaryServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public CloudinaryService get() {
    return provideCloudinaryService(retrofitProvider.get());
  }

  public static AppModule_ProvideCloudinaryServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new AppModule_ProvideCloudinaryServiceFactory(retrofitProvider);
  }

  public static CloudinaryService provideCloudinaryService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideCloudinaryService(retrofit));
  }
}
