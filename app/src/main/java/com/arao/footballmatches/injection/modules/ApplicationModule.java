package com.arao.footballmatches.injection.modules;

import android.content.Context;
import android.content.res.Resources;

import com.arao.footballmatches.presentation.FootballMatchesApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final FootballMatchesApplication application;

    public ApplicationModule(FootballMatchesApplication application) {
        this.application = application;
    }

    @Provides
    Resources resources() {
        return application.getResources();
    }

    @Provides
    Context appContext() {
        return application;
    }

}
