package com.arao.footballmatches.presentation;

import android.app.Application;

import com.arao.footballmatches.injection.components.ApplicationComponent;
import com.arao.footballmatches.injection.components.DaggerApplicationComponent;
import com.arao.footballmatches.injection.modules.ApplicationModule;

public class FootballMatchesApplication extends Application {

    private static FootballMatchesApplication instance;

    private ApplicationComponent appComponent;

    public FootballMatchesApplication() {
        instance = this;
    }

    public static FootballMatchesApplication getApplication() {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        this.appComponent
                = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getAppComponent() {
        return appComponent;
    }
}
