package com.arao.footballmatches.injection.components;

import com.arao.footballmatches.injection.modules.HomeModule;
import com.arao.footballmatches.presentation.view.activity.HomeActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {HomeModule.class})
public interface HomeComponent {

    void resolveDependenciesFor(HomeActivity activity);

}
