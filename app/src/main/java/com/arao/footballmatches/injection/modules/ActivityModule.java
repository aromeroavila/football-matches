package com.arao.footballmatches.injection.modules;

import com.arao.footballmatches.data.repository.MatchRepository;
import com.arao.footballmatches.presentation.presenter.MatchesPresenter;
import com.arao.footballmatches.presentation.view.adapter.HomeFragmentAdapterFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    @Provides
    MatchesPresenter homePresenter(MatchRepository matchRepository) {
        return new MatchesPresenter(matchRepository);
    }

    @Provides
    HomeFragmentAdapterFactory homeFragmentAdapterFactory() {
        return new HomeFragmentAdapterFactory();
    }

}
