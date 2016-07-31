package com.arao.footballmatches.presentation.presenter;

import com.arao.footballmatches.data.entity.League;
import com.arao.footballmatches.data.repository.DataCallback;
import com.arao.footballmatches.data.repository.MatchRepository;
import com.arao.footballmatches.presentation.view.LeaguesView;

import java.util.List;

import static com.arao.footballmatches.data.entity.MatchesFilter.ALL;

public class HomePresenter implements DataCallback<List<League>> {

    private final MatchRepository matchRepository;

    private LeaguesView leaguesView;

    public HomePresenter(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public void init(LeaguesView homeView) {
        this.leaguesView = homeView;

        matchRepository.matches(ALL, this);
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
