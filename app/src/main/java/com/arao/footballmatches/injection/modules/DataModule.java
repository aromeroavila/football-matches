package com.arao.footballmatches.injection.modules;

import com.arao.footballmatches.data.net.ApiMatchRepository;
import com.arao.footballmatches.data.repository.MatchRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {

    @Provides
    MatchRepository matchRepository(ApiMatchRepository apiMatchRepository) {
        return apiMatchRepository;
    }

//    @Provides
//    MatchRepository matchRepository(MockMatchRepository mockMatchRepository) {
//        return mockMatchRepository;
//    }

}
