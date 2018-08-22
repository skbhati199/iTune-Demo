package com.metro.itunesdemo.di.app.modules;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;


import com.metro.itunesdemo.data.AppDataManager;
import com.metro.itunesdemo.data.DataManager;
import com.metro.itunesdemo.data.local.AppDatabase;
import com.metro.itunesdemo.data.local.AppDbHelper;
import com.metro.itunesdemo.data.local.DbHelper;
import com.metro.itunesdemo.di.scope.ApplicationScope;
import com.metro.itunesdemo.di.scope.DatabaseInfo;
import com.metro.itunesdemo.utils.AppConstants;
import com.metro.itunesdemo.utils.rx.AppSchedulerProvider;
import com.metro.itunesdemo.utils.rx.SchedulerProvider;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Skbhati
 * on Date 23-12-2017 : Time 02:16 PM.
 */

@Module
public class AppModule {

    @Provides
    @ApplicationScope
    Context provideContext(Application application) {
        return application;
    }

    @Provides
    @ApplicationScope
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @ApplicationScope
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApplicationScope
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }


    @Provides
    @ApplicationScope
    AppDatabase provideAppDatabase(@DatabaseInfo String dbName, Context context) {
        return Room.databaseBuilder(context, AppDatabase.class, dbName).fallbackToDestructiveMigration()
                .build();
    }
}
