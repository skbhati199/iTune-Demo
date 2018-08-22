package com.metro.itunesdemo;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.metro.itunesdemo.di.app.components.AppComponent;
import com.metro.itunesdemo.di.app.components.DaggerAppComponent;

import javax.inject.Inject;

import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;

public class DemoApp extends Application implements HasActivityInjector {

    @Inject
    DispatchingAndroidInjector<Activity> activityDispatchingAndroidInjector;
    private static AppComponent component;

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .application(this)
                .build();

        component.inject(this);
    }


    public static AppComponent getComponent() {
        return component;
    }


    /**
     * Returns an {@link AndroidInjector} of {@link Activity}s.
     */
    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityDispatchingAndroidInjector;
    }
}
