package com.metro.itunesdemo.ui.details;

import com.metro.itunesdemo.data.remote.model.Result;

public interface DetailsNavigator {
    void handle(Throwable throwable);

    void updateResult(Result result);
}
