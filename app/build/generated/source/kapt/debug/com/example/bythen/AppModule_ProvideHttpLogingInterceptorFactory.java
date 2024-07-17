package com.example.bythen;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import okhttp3.logging.HttpLoggingInterceptor;

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
public final class AppModule_ProvideHttpLogingInterceptorFactory implements Factory<HttpLoggingInterceptor> {
  @Override
  public HttpLoggingInterceptor get() {
    return provideHttpLogingInterceptor();
  }

  public static AppModule_ProvideHttpLogingInterceptorFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static HttpLoggingInterceptor provideHttpLogingInterceptor() {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideHttpLogingInterceptor());
  }

  private static final class InstanceHolder {
    private static final AppModule_ProvideHttpLogingInterceptorFactory INSTANCE = new AppModule_ProvideHttpLogingInterceptorFactory();
  }
}
