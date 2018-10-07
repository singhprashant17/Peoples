package com.peoples.di;

import com.peoples.BuildConfig;
import com.peoples.webservice.ApiCallMethods;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class WebServiceModule {
    String baseUrl;

    public WebServiceModule(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Provides
    @Singleton
    Retrofit provideRetrofit(OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build();
    }

    @Provides
    @Singleton
    Interceptor[] provideInterceptors() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY
                : HttpLoggingInterceptor.Level.NONE);
        return new Interceptor[]{interceptor};
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(Interceptor... interceptor) {
        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        if (interceptor != null) {
            for (Interceptor interceptor1 : interceptor) {
                httpClient.addInterceptor(interceptor1);
            }
        }
        return httpClient.build();
    }

    @Provides
    @Singleton
    ApiCallMethods providesGitHubInterface(Retrofit retrofit) {
        return retrofit.create(ApiCallMethods.class);
    }
}
