package com.metro.itunesdemo.data.remote;

import com.metro.itunesdemo.data.remote.model.SearchModel;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Streaming;

public interface ApiService {

    @Streaming
    @GET("/search?term=Michael+jackson")
    Observable<SearchModel> getFile();
}
