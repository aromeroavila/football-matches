package com.arao.footballmatches.presentation.presenter;

import com.arao.footballmatches.data.DataCallback;
import com.arao.footballmatches.data.entity.League;
import com.arao.footballmatches.data.entity.Match;
import com.arao.footballmatches.data.entity.MatchFilter;
import com.arao.footballmatches.data.repository.MatchRepository;
import com.arao.footballmatches.presentation.view.LeaguesView;

import java.util.List;

public class MatchesPresenter implements DataCallback<List<League>> {

    private final MatchRepository matchRepository;

    private LeaguesView leaguesView;

    public MatchesPresenter(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public void initWithFilter(LeaguesView leaguesView, MatchFilter filter) {
        this.leaguesView = leaguesView;
        matchRepository.matches(filter, this);
    }

    public void initWithMatch(LeaguesView leaguesView, Match match) {
        this.leaguesView = leaguesView;
        matchRepository.matchesFromTournament(Integer.toString(match.getTournamentId()), this);
    }

    @Override
    public void onSuccess(List<League> result) {
        leaguesView.displayLeagues(result);
    }

    @Override
    public void onError() {
        leaguesView.displayError();
    }
}
