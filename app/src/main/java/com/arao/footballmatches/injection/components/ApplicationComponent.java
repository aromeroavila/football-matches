package com.arao.footballmatches.injection.components;

import com.arao.footballmatches.injection.modules.ApplicationModule;
import com.arao.footballmatches.injection.modules.NetModule;
import com.arao.footballmatches.injection.scopes.PerApplication;

import dagger.Component;

@PerApplication
@Component(modules = {ApplicationModule.class, NetModule.class})
public interface ApplicationComponent {

    ActivityComponent homeComponent();

}
