package com.arao.footballmatches.injection.modules;

import com.arao.footballmatches.data.mock.MockMatchRepository;
import com.arao.footballmatches.data.repository.MatchRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    MatchRepository matchRepository(MockMatchRepository mockMatchRepository) {
        return mockMatchRepository;
    }

}
