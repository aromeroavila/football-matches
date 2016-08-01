package com.arao.footballmatches.injection.components;

import com.arao.footballmatches.injection.modules.LeaguesModule;
import com.arao.footballmatches.presentation.view.fragment.LeaguesFragment;
import com.arao.footballmatches.presentation.view.fragment.MatchDetailFragment;

import dagger.Subcomponent;

@Subcomponent(modules = {LeaguesModule.class})
public interface LeaguesFragmentComponent {

    void resolveDependenciesFor(LeaguesFragment fragment);

    void resolveDependenciesFor(MatchDetailFragment fragment);

}
