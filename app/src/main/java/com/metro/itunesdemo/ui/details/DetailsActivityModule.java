package com.metro.itunesdemo.ui.details;

import com.metro.itunesdemo.data.DataManager;
import com.metro.itunesdemo.utils.rx.SchedulerProvider;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailsActivityModule {

    @Provides
    DetailsViewModel provideDetailsModel(DataManager dataManager, SchedulerProvider schedulerProvider){
        return new DetailsViewModel(dataManager, schedulerProvider);
    }
}
