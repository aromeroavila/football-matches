package com.arao.footballmatches.presentation.presenter;

import com.arao.footballmatches.data.entity.League;
import com.arao.footballmatches.data.entity.Match;
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
import static org.mockito.Mockito.when;

public class MatchesPresenterTest {

    @Rule public final MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock private MatchRepository matchRepository;
    @Mock private LeaguesView leaguesView;
    @Mock private List<League> leagueList;
    @Mock private Match match;

    @InjectMocks private MatchesPresenter homePresenter;

    @Test
    public void shouldGetMatchesFromRepositoryWithGivenFilter_whenInitialisingWithFilter() {
        homePresenter.initWithFilter(leaguesView, ALL);

        verify(matchRepository).matches(ALL, homePresenter);
    }

    @Test
    public void shouldGetMatchesFromRepositoryWithGivenFilter_whenInitialisingWithMatch() {
        when(match.getTournamentId()).thenReturn(123);

        homePresenter.initWithMatch(leaguesView, match);

        verify(matchRepository).matchesFromTournament("123", homePresenter);
    }

    @Test
    public void shouldUpdateUiWithData_whenSuccessfulResponseFromRepo() {
        homePresenter.initWithFilter(leaguesView, ALL);

        homePresenter.onSuccess(leagueList);

        verify(leaguesView).displayLeagues(leagueList);
    }

    @Test
    public void shouldDisplayErrorOnUi_whenErrorReceivedFromRepo() {
        homePresenter.initWithFilter(leaguesView, ALL);

        homePresenter.onError();

        verify(leaguesView).displayError();
    }

}