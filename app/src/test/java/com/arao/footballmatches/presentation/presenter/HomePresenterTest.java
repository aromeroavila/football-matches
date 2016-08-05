package com.arao.footballmatches.presentation.presenter;

import com.arao.footballmatches.data.entity.League;
import com.arao.footballmatches.data.repository.MatchRepository;
import com.arao.footballmatches.presentation.view.LeaguesView;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static com.arao.footballmatches.data.entity.MatchesFilter.ALL;
import static org.mockito.Mockito.verify;

public class HomePresenterTest {

    @Rule public final MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock private MatchRepository matchRepository;
    @Mock private LeaguesView leaguesView;
    @Mock private List<League> leagueList;

    @InjectMocks private HomePresenter homePresenter;

    @Test
    public void shouldGetMatchesFromRepositoryWithGivenFilter_whenInitialising() {
        homePresenter.init(leaguesView, ALL);

        verify(matchRepository).matches(ALL, homePresenter);
    }

    @Test
    public void shouldUpdateUiWithData_whenSuccessfulResponseFromRepo() {
        homePresenter.init(leaguesView, ALL);

        homePresenter.onSuccess(leagueList);

        verify(leaguesView).displayLeagues(leagueList);
    }

    @Test
    public void shouldDisplayErrorOnUi_whenErrorReceivedFromRepo() throws Exception {
        homePresenter.init(leaguesView, ALL);

        homePresenter.onError();

        verify(leaguesView).displayError();
    }

}