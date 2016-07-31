package com.arao.footballmatches.presentation;

import android.app.Application;

import com.arao.footballmatches.injection.components.AppComponent;
import com.arao.footballmatches.injection.components.DaggerAppComponent;
import com.arao.footballmatches.injection.modules.ApplicationModule;

public class FootballMatchesApplication extends Application {

    private static FootballMatchesApplication instance;

    private AppComponent appComponent;

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
                = DaggerAppComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
