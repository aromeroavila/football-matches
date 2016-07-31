package com.arao.footballmatches.injection.modules;

import com.arao.footballmatches.data.repository.MatchRepository;
import com.arao.footballmatches.presentation.presenter.HomePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    @Provides
    HomePresenter homePresenter(MatchRepository matchRepository) {
        return new HomePresenter(matchRepository);
    }

}
