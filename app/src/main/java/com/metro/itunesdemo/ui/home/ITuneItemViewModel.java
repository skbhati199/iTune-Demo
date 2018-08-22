package com.metro.itunesdemo.ui.home;

import android.content.Context;
import android.databinding.ObservableField;
import android.view.View;

import com.metro.itunesdemo.data.remote.model.Result;

public class ITuneItemViewModel {

    private final Result result;
    private final ItuneItemViewModelListener mListener;

    public final ObservableField<String> author;

    public final ObservableField<Integer> trackId;

    public final ObservableField<String> date;

    public final ObservableField<String> title;

    public final ObservableField<String> imageUrl;


    public ITuneItemViewModel(Result result, ItuneItemViewModelListener listener) {
        this.result = result;
        this.mListener = listener;

        imageUrl = new ObservableField<>(result.getArtworkUrl100());
        title = new ObservableField<>(result.getCollectionName());
        author = new ObservableField<>(result.getArtistName());
        date = new ObservableField<>(result.getReleaseDate());
        trackId = new ObservableField<>(result.getTrackId());
    }

    public void onItemClick(View view) {
        mListener.onItemClick(view.getContext(), result.getTrackId());
    }

    public interface ItuneItemViewModelListener {
        void onItemClick(Context context, int trackId);
    }
}
