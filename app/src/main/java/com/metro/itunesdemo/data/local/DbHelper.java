package com.metro.itunesdemo.data.local;

import com.metro.itunesdemo.data.remote.model.Result;

import java.util.List;

import io.reactivex.Observable;


public interface DbHelper {

    Observable<Result> getResultByTrackId(int trackId);

    Observable<Boolean> saveResultList(List<Result> resultList);

    Observable<Boolean> isEmpty();


}
