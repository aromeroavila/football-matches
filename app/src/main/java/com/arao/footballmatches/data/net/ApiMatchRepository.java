package com.arao.footballmatches.data.net;

import com.arao.footballmatches.data.entity.League;
import com.arao.footballmatches.data.entity.MatchesFilter;
import com.arao.footballmatches.data.repository.DataCallback;
import com.arao.footballmatches.data.repository.MatchRepository;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Retrofit;

public class ApiMatchRepository implements MatchRepository {

    private final Retrofit retrofit;
    private final CallbackConverterFactory callbackConverterFactory;

    @Inject
    ApiMatchRepository(Retrofit retrofit, CallbackConverterFactory callbackConverterFactory) {
        this.retrofit = retrofit;
        this.callbackConverterFactory = callbackConverterFactory;
    }

    @Override
    public void matches(MatchesFilter filter, DataCallback<List<League>> callback) {
        WhatsTheScoreApi service = retrofit.create(WhatsTheScoreApi.class);
        Call<List<League>> leaguesCall;

        switch (filter) {
            case ALL:
                leaguesCall = service.allLeagues();
                break;
            default:
                leaguesCall = service.leaguesWithFilter(filter.toString());
                break;
        }

        leaguesCall.enqueue(callbackConverterFactory.getRetrofitCallbackConverter(callback));
    }

    @Override
    public void matchesFromTournament(String tournamentId, DataCallback<List<League>> callback) {
        WhatsTheScoreApi service = retrofit.create(WhatsTheScoreApi.class);
        Call<List<League>> leaguesCall = service.leaguesFromTournament(tournamentId);
        leaguesCall.enqueue(callbackConverterFactory.getRetrofitCallbackConverter(callback));
    }
}
