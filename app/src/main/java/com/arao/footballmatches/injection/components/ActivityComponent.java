package com.arao.footballmatches.injection.components;

import com.arao.footballmatches.injection.modules.ActivityModule;
import com.arao.footballmatches.injection.modules.DataModule;
import com.arao.footballmatches.presentation.view.activity.HomeActivity;
import com.arao.footballmatches.presentation.view.activity.MatchDetailActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {DataModule.class, ActivityModule.class})
public interface ActivityComponent {

    void resolveDependenciesFor(HomeActivity homeActivity);

    void resolveDependenciesFor(MatchDetailActivity matchDetailActivity);

    LeaguesFragmentComponent leaguesFragmentComponent();

}
