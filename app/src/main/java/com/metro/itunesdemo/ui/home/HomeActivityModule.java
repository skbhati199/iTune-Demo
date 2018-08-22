package com.metro.itunesdemo.ui.home;

import android.arch.lifecycle.ViewModelProvider;
import android.support.v7.widget.LinearLayoutManager;

import com.metro.itunesdemo.ViewModelProviderFactory;
import com.metro.itunesdemo.data.DataManager;
import com.metro.itunesdemo.ui.adapter.ITuneRecyclerViewAdapter;
import com.metro.itunesdemo.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;

@Module
public class HomeActivityModule {
    @Provides
    HomeViewModel provideHomeViewModel(DataManager dataManager, SchedulerProvider schedulerProvider){
        return new HomeViewModel(dataManager, schedulerProvider);
    }

    @Provides
    ITuneRecyclerViewAdapter provideBlogAdapter() {
        return new ITuneRecyclerViewAdapter(new ArrayList<>());
    }


    @Provides
    ViewModelProvider.Factory mainViewModelProvider(HomeViewModel mainViewModel) {
        return new ViewModelProviderFactory<>(mainViewModel);
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(HomeActivity activity) {
        return new LinearLayoutManager(activity);
    }
}
