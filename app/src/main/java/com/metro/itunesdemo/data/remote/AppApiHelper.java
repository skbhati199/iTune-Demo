package com.metro.itunesdemo.data.remote;

import android.content.Context;

import com.metro.itunesdemo.data.remote.model.SearchModel;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

public class AppApiHelper implements ApiHelper {

    private final ApiService apiService;

    public AppApiHelper(ApiService apiService){
        this.apiService = apiService;
    }

    @Override
    public Observable<SearchModel> getFileJson() {
        return apiService.getFile();
    }
}
