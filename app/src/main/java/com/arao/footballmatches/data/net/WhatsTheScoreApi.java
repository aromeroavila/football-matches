package com.arao.footballmatches.data.net;

import com.arao.footballmatches.data.entity.League;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

interface WhatsTheScoreApi {

    @GET("match/")
    Call<List<League>> allLeagues();

    @GET("match/")
    Call<List<League>> leaguesWithFilter(@Query("status") String status);

    @GET("match/")
    Call<List<League>> leaguesFromTournament(@Query("tournamentId") String tournamentId);

}
