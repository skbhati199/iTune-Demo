package com.metro.itunesdemo.ui.details;

import com.metro.itunesdemo.data.DataManager;
import com.metro.itunesdemo.data.remote.model.Result;
import com.metro.itunesdemo.ui.base.BaseViewModel;
import com.metro.itunesdemo.utils.rx.SchedulerProvider;

import io.reactivex.functions.Consumer;

public class DetailsViewModel extends BaseViewModel<DetailsNavigator> {
    public DetailsViewModel(DataManager mDataManager, SchedulerProvider mSchedulerProvider) {
        super(mDataManager, mSchedulerProvider);
    }

    public void getFilterData(int trackId) {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager().getResultByTrackId(trackId)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<Result>() {
                    @Override
                    public void accept(Result result) throws Exception {
                        setIsLoading(false);
                        getNavigator().updateResult(result);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        setIsLoading(false);
                        getNavigator().handle(throwable);
                    }
                }));
    }
}
