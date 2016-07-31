package com.arao.footballmatches.injection.components;

import com.arao.footballmatches.injection.modules.ApplicationModule;
import com.arao.footballmatches.injection.modules.DataModule;

import dagger.Component;

@Component(modules = {ApplicationModule.class, DataModule.class})
public interface AppComponent {

    HomeComponent homeComponent();

}
