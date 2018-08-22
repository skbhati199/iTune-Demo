package com.metro.itunesdemo.data;

import android.content.Context;

import com.google.gson.Gson;
import com.metro.itunesdemo.data.local.DbHelper;
import com.metro.itunesdemo.data.remote.ApiHelper;
import com.metro.itunesdemo.data.remote.model.Result;
import com.metro.itunesdemo.data.remote.model.SearchModel;
import com.metro.itunesdemo.di.scope.ApplicationScope;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

@ApplicationScope
public class AppDataManager implements DataManager{

    private final Context mContext;
    private final DbHelper dbHelper;
    private final ApiHelper apiHelper;
    private final Gson mGson;

    @Inject
    public AppDataManager(Context context, DbHelper dbHelper, ApiHelper apiHelper, Gson gson) {
        mContext = context;
        this.dbHelper = dbHelper;
        this.apiHelper = apiHelper;
        this.mGson = gson;
    }

    @Override
    public Observable<SearchModel> getFileJson() {
        return apiHelper.getFileJson();
    }

    @Override
    public Observable<SearchModel> getParser() {
        return  null;
    }

    @Override
    public Observable<Result> getSeedDetails(int trackId) {
        return dbHelper.getResultByTrackId(trackId);
    }

    @Override
    public Observable<Boolean> saveResult(List<Result> results) {
        return dbHelper.saveResultList(results);
    }

    @Override
    public Observable<Result> getResultByTrackId(int trackId) {
        return dbHelper.getResultByTrackId(trackId);
    }

    @Override
    public Observable<Boolean> saveResultList(List<Result> resultList) {
        return dbHelper.saveResultList(resultList);
    }

    @Override
    public Observable<Boolean> isEmpty() {
        return dbHelper.isEmpty();
    }
}
