package com.metro.itunesdemo.di.app.components;

import android.app.Application;


import com.metro.itunesdemo.DemoApp;
import com.metro.itunesdemo.di.app.modules.AppModule;
import com.metro.itunesdemo.di.app.modules.NetworkModule;
import com.metro.itunesdemo.di.builder.ActivityBuilder;
import com.metro.itunesdemo.di.scope.ApplicationScope;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by Skbhati
 * on Date 23-12-2017 : Time 02:14 PM.
 */
@ApplicationScope
@Component(modules = {AndroidInjectionModule.class,
        AppModule.class,
        NetworkModule.class,
        ActivityBuilder.class})
public interface AppComponent {
    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(Application application);

        AppComponent build();
    }


    void inject(DemoApp app);
}
