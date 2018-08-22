package com.metro.itunesdemo.data.remote;


import com.metro.itunesdemo.data.remote.model.SearchModel;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

public interface ApiHelper {

    Observable<SearchModel> getFileJson();
}
