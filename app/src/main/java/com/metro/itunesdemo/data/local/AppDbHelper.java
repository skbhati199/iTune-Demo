package com.metro.itunesdemo.data.local;

import com.metro.itunesdemo.data.remote.model.Result;
import com.metro.itunesdemo.di.scope.ApplicationScope;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;

import io.reactivex.Observable;

@ApplicationScope
public class AppDbHelper implements DbHelper {

    private final AppDatabase appDatabase;

    @Inject
    public AppDbHelper(AppDatabase appDatabase){
        this.appDatabase = appDatabase;
    }

    @Override
    public Observable<Result> getResultByTrackId(int trackId) {
        return Observable.fromCallable(new Callable<Result>() {
            @Override
            public Result call() throws Exception {
                return appDatabase.resultDao().getTrackById(trackId);
            }
        });
    }

    @Override
    public Observable<Boolean> saveResultList(List<Result> resultList) {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                appDatabase.resultDao().insertAll(resultList);
                return true;
            }
        });
    }

    @Override
    public Observable<Boolean> isEmpty() {
        return Observable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return appDatabase.resultDao().loadAll().isEmpty();
            }
        });
    }
}

