package com.arao.footballmatches.injection.modules;

import com.arao.footballmatches.data.repository.MatchRepository;
import com.arao.footballmatches.presentation.presenter.HomePresenter;
import com.arao.footballmatches.presentation.presenter.MatchDetailPresenter;
import com.arao.footballmatches.presentation.view.adapter.HomeFragmentAdapterFactory;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    @Provides
    HomePresenter homePresenter(MatchRepository matchRepository) {
        return new HomePresenter(matchRepository);
    }

    @Provides
    MatchDetailPresenter matchDetailPresenter(MatchRepository matchRepository) {
        return new MatchDetailPresenter(matchRepository);
    }

    @Provides
    HomeFragmentAdapterFactory homeFragmentAdapterFactory() {
        return new HomeFragmentAdapterFactory();
    }

}
