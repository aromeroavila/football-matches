package com.arao.footballmatches.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.arao.footballmatches.R;
import com.arao.footballmatches.data.entity.Match;
import com.arao.footballmatches.data.entity.Result;
import com.arao.footballmatches.data.entity.Team;
import com.arao.footballmatches.injection.components.ActivityComponent;
import com.arao.footballmatches.injection.components.ActivityComponentProvider;
import com.arao.footballmatches.presentation.FootballMatchesApplication;
import com.arao.footballmatches.presentation.presenter.MatchDetailPresenter;
import com.arao.footballmatches.presentation.view.fragment.MatchDetailFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MatchDetailActivity extends AppCompatActivity implements ActivityComponentProvider {

    private static final String INTENT_EXTRA_MATCH = "intent_extra_match";
    private static final String MATCH_SCORE_SEPARATOR = " - ";

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.inner_toolbar)
    Toolbar innerToolbar;

    @Inject
    MatchDetailPresenter matchDetailPresenter;

    private ActivityComponent activityComponent;
    private Match match;

    public static Intent getCallingIntent(Context context, Match match) {
        Intent callingIntent = new Intent(context, MatchDetailActivity.class);
        callingIntent.putExtra(INTENT_EXTRA_MATCH, match);
        return callingIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        resolveDependencies();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_detail);
        match = getIntent().getExtras().getParcelable(INTENT_EXTRA_MATCH);
        ButterKnife.bind(this);

        initToolbar();
        loadLeaguesFragment();
    }

    @Override
    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    private void resolveDependencies() {
        activityComponent = FootballMatchesApplication
                .getApplication()
                .getAppComponent()
                .homeComponent();
        activityComponent.resolveDependenciesFor(this);
    }

    private void initToolbar() {
        toolbar.setTitle(match.getName());
        innerToolbar.setTitle(getMatchScore());
    }

    @NonNull
    private String getMatchScore() {
        Team homeTeam = match.getHomeTeam();
        Team awayTeam = match.getAwayTeam();

        Result homeTeamResults = homeTeam.getResults();
        String homeTeamScore = homeTeamResults != null ? homeTeamResults.getRunningScore() : " ";
        Result awayTeamResults = awayTeam.getResults();
        String awayTeamScore = awayTeamResults != null ? awayTeamResults.getRunningScore() : " ";

        return homeTeamScore + MATCH_SCORE_SEPARATOR + awayTeamScore;
    }

    private void loadLeaguesFragment() {
        Fragment matchDetailFragment = MatchDetailFragment.newInstance(match);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.detail_fragment_container, matchDetailFragment);
        transaction.commit();
    }
}
