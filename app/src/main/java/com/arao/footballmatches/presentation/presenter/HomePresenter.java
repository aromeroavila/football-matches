package com.arao.footballmatches.presentation.presenter;

import com.arao.footballmatches.data.DataCallback;
import com.arao.footballmatches.data.entity.League;
import com.arao.footballmatches.data.entity.MatchesFilter;
import com.arao.footballmatches.data.repository.MatchRepository;
import com.arao.footballmatches.presentation.view.LeaguesView;

import java.util.List;

public class HomePresenter implements DataCallback<List<League>> {

    private final MatchRepository matchRepository;

    private LeaguesView leaguesView;

    public HomePresenter(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public void init(LeaguesView leaguesView, MatchesFilter filter) {
        this.leaguesView = leaguesView;

        matchRepository.matches(filter, this);
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
