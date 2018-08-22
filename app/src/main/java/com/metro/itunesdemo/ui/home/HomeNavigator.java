package com.metro.itunesdemo.ui.home;

import com.metro.itunesdemo.data.remote.model.Result;

import java.util.List;

public interface HomeNavigator {
    void handleError(Throwable throwable);

    void updateItem(List<Result> items);
}
