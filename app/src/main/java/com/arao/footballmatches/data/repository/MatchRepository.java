package com.arao.footballmatches.data.repository;

import com.arao.footballmatches.data.DataCallback;
import com.arao.footballmatches.data.entity.League;
import com.arao.footballmatches.data.entity.MatchFilter;

import java.util.List;

public interface MatchRepository {

    void matches(MatchFilter filter, DataCallback<List<League>> callback);

    void matchesFromTournament(String tournamentId, DataCallback<List<League>> callback);

}
