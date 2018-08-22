package com.metro.itunesdemo.data;

import com.metro.itunesdemo.data.local.DbHelper;
import com.metro.itunesdemo.data.remote.ApiHelper;
import com.metro.itunesdemo.data.remote.model.Result;
import com.metro.itunesdemo.data.remote.model.SearchModel;

import java.util.List;

import io.reactivex.Observable;

public interface DataManager extends ApiHelper, DbHelper {

    Observable<SearchModel> getParser();

    Observable<Result> getSeedDetails(int trackId);

    Observable<Boolean> saveResult(List<Result> results);
}
