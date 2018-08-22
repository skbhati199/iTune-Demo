package com.metro.itunesdemo.ui.home;

import com.metro.itunesdemo.ui.adapter.ITuneRecyclerViewAdapter;

public class ITuneEmptyItemViewModel {
    private final ITuneEmptyItemViewModelListener listener;

    public ITuneEmptyItemViewModel(ITuneEmptyItemViewModelListener listener) {
        this.listener = listener;
    }

    public void onRetryClick() {
        listener.onRetryClick();
    }

    public interface ITuneEmptyItemViewModelListener {
        void onRetryClick();

    }
}
