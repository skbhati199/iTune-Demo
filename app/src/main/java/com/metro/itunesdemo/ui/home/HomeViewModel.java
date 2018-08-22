package com.metro.itunesdemo.ui.home;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;
import android.util.Log;

import com.metro.itunesdemo.data.DataManager;
import com.metro.itunesdemo.data.remote.model.Result;
import com.metro.itunesdemo.ui.base.BaseViewModel;
import com.metro.itunesdemo.utils.rx.SchedulerProvider;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;

public class HomeViewModel extends BaseViewModel<HomeNavigator> {

    private static final String TAG = HomeViewModel.class.getSimpleName();
    public ObservableList<Result> blogObservableArrayList = new ObservableArrayList<>();

    private final MutableLiveData<List<Result>> tracksListLiveData;

    protected HomeViewModel(DataManager mDataManager, SchedulerProvider mSchedulerProvider) {
        super(mDataManager, mSchedulerProvider);
        tracksListLiveData = new MutableLiveData<>();
        fetchBlogs();
    }

    public void fetchBlogs() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getFileJson()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(responseResults -> {
                    Log.d(TAG, responseResults.getResultCount().toString());
                    if (responseResults.getResults() != null) {
                        saveResultList(responseResults.getResults());
                        tracksListLiveData.setValue(responseResults.getResults());
                    }
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }


    public MutableLiveData<List<Result>> getListLiveData() {
        return tracksListLiveData;
    }

    public void addItems(List<Result> searchModel) {
        blogObservableArrayList.clear();
        blogObservableArrayList.addAll(searchModel);
    }

    public void saveResultList(List<Result> list) {
        getCompositeDisposable().add(getDataManager().saveResultList(list)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }));
    }
}
