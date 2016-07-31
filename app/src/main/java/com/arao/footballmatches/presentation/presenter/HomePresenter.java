package com.arao.footballmatches.presentation.presenter;

import com.arao.footballmatches.data.entity.League;
import com.arao.footballmatches.data.repository.DataCallback;
import com.arao.footballmatches.data.repository.MatchRepository;
import com.arao.footballmatches.presentation.view.HomeView;

import java.util.List;

import javax.inject.Inject;

import static com.arao.footballmatches.data.entity.MatchesFilter.ALL;

public class HomePresenter implements DataCallback<List<League>> {

    private final MatchRepository matchRepository;

    private HomeView homeView;

    public HomePresenter(MatchRepository matchRepository) {
        this.matchRepository = matchRepository;
    }

    public void init(HomeView homeView) {
        this.homeView = homeView;

        matchRepository.matches(ALL, this);
    }

    @Override
    public void onSuccess(List<League> result) {
        homeView.displayLeagues(result);
    }

    @Override
    public void onError() {
        homeView.displayError();
    }
}
