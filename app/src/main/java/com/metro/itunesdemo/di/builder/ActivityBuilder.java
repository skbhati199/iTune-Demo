package com.metro.itunesdemo.di.builder;


import com.metro.itunesdemo.ui.details.DetailsActivity;
import com.metro.itunesdemo.ui.details.DetailsActivityModule;
import com.metro.itunesdemo.ui.home.HomeActivity;
import com.metro.itunesdemo.ui.home.HomeActivityModule;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * Created by Skbhati
 * on Date 23-12-2017 : Time 02:20 PM.
 */
@Module
public abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = {HomeActivityModule.class})
    abstract HomeActivity bindHomeActivity();

    @ContributesAndroidInjector(modules = {DetailsActivityModule.class})
    abstract DetailsActivity bindDetailsActivity();
}


