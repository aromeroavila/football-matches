package com.arao.footballmatches.injection.modules;

import android.content.Context;
import android.content.res.Resources;

import com.arao.footballmatches.presentation.FootballMatchesApplication;
import com.arao.footballmatches.presentation.navigation.Navigator;

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

    @Provides
    Navigator navigator() {
        return new Navigator();
    }

}
