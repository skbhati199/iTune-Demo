package com.metro.itunesdemo.ui.details;

import android.databinding.ObservableField;

import com.metro.itunesdemo.data.DataManager;
import com.metro.itunesdemo.data.remote.model.Result;
import com.metro.itunesdemo.ui.base.BaseViewModel;
import com.metro.itunesdemo.utils.rx.SchedulerProvider;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import io.reactivex.functions.Consumer;

public class DetailsViewModel extends BaseViewModel<DetailsNavigator> {

    public final ObservableField<String> trackName = new ObservableField<>();
    public final ObservableField<String> collectionName = new ObservableField<>();
    public final ObservableField<String> releaseDate = new ObservableField<>();
    public final ObservableField<String> ratingBar = new ObservableField<>();

    public final ObservableField<String> imageUrl = new ObservableField<>();

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
                        imageUrl.set(result.getArtworkUrl100());
                        trackName.set(result.getArtistName());
                        collectionName.set(result.getCollectionName());
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                        releaseDate.set(format.format(result.getReleaseDate()));
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
