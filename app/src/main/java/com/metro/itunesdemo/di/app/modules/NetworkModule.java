package com.metro.itunesdemo.di.app.modules;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.metro.itunesdemo.data.remote.ApiHelper;
import com.metro.itunesdemo.data.remote.ApiService;
import com.metro.itunesdemo.data.remote.AppApiHelper;
import com.metro.itunesdemo.di.scope.ApiInfo;
import com.metro.itunesdemo.di.scope.ApplicationScope;
import com.metro.itunesdemo.utils.AppConstants;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by SKBHATI on 3/13/2018.
 */

@Module
public class NetworkModule {

    @Provides
    @ApiInfo
    String provideEndPoint() {
        return AppConstants.HTTPS_URL;
    }

    @Provides
    @ApplicationScope
    ApiHelper provideApiHelper(ApiService service){
        return new AppApiHelper(service);
    }

    @Provides
    @ApplicationScope
    ApiService providerApiService(Retrofit retrofit){
        return retrofit.create(ApiService.class);
    }


    @Provides
    @ApplicationScope
    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient, @ApiInfo String endPoint){
     return new Retrofit.Builder()
             .baseUrl(endPoint)
             .addConverterFactory(GsonConverterFactory.create(gson))
             .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
             .client(okHttpClient)
             .build();
    }

    @Provides
    @ApplicationScope
    Cache provideHttpCache(Context context) {
        int cacheSize = 10 * 1024 * 1024;
        Cache cache = new Cache(context.getCacheDir(), cacheSize);
        return cache;
    }

    @Provides
    @ApplicationScope
    Gson provideJson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }

    @Provides
    @ApplicationScope
    OkHttpClient provideOkhttpClient(Cache cache) {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.cache(cache);
        return client.build();
    }
}
