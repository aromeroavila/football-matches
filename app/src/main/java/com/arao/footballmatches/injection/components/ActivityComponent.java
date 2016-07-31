package com.arao.footballmatches.injection.components;

import android.support.v7.app.AppCompatActivity;

import com.arao.footballmatches.injection.modules.ActivityModule;
import com.arao.footballmatches.injection.modules.DataModule;

import dagger.Subcomponent;

@Subcomponent(modules = {DataModule.class, ActivityModule.class})
public interface ActivityComponent {

    void resolveDependenciesFor(AppCompatActivity activity);

    LeaguesFragmentComponent leaguesFragmentComponent();

}
