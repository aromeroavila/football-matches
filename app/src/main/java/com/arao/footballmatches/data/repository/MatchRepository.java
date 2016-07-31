package com.arao.footballmatches.data.repository;

import com.arao.footballmatches.data.DataCallback;
import com.arao.footballmatches.data.entity.League;
import com.arao.footballmatches.data.entity.MatchesFilter;

import java.util.List;

public interface MatchRepository {

    void matches(MatchesFilter filter, DataCallback<List<League>> callback);

    void matchesFromTournament(String tournamentId, DataCallback<List<League>> callback);

}
