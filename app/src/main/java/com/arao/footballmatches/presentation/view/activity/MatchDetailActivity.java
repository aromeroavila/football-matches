package com.arao.footballmatches.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.arao.footballmatches.R;
import com.arao.footballmatches.data.entity.Match;
import com.arao.footballmatches.data.entity.Result;
import com.arao.footballmatches.data.entity.Team;
import com.arao.footballmatches.injection.components.ActivityComponent;
import com.arao.footballmatches.injection.components.ActivityComponentProvider;
import com.arao.footballmatches.presentation.FootballMatchesApplication;
import com.arao.footballmatches.presentation.presenter.MatchDetailPresenter;
import com.arao.footballmatches.presentation.view.fragment.MatchDetailFragment;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MatchDetailActivity extends AppCompatActivity implements ActivityComponentProvider, AppBarLayout.OnOffsetChangedListener {

    private static final String INTENT_EXTRA_MATCH = "intent_extra_match";
    private static final String MATCH_SCORE_SEPARATOR = " - ";

    private static final float PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR = 0.05f;
    private static final int ALPHA_ANIMATIONS_DURATION = 150;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.app_bar)
    AppBarLayout appBarLayout;
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @BindView(R.id.inner_toolbar)
    Toolbar innerToolbar;
    @BindView(R.id.expanded_title)
    TextView expandedTitle;
    @BindView(R.id.collapsed_title)
    TextView collapsedTitle;
    @BindView(R.id.team1_logo)
    ImageView team1Logo;
    @BindView(R.id.team2_logo)
    ImageView team2Logo;

    @Inject
    MatchDetailPresenter matchDetailPresenter;
    @Inject
    Picasso picasso;

    private ActivityComponent activityComponent;
    private Match match;
    private int maxScroll;

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

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (maxScroll == 0) {
            maxScroll = appBarLayout.getTotalScrollRange();
        }

        float percentage = (float) Math.abs(verticalOffset) / (float) maxScroll;
        handleToolbarTitleVisibility(percentage);
    }

    private void handleToolbarTitleVisibility(float percentage) {
        if (percentage < PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {
            expandedTitle.animate().alpha(1).setDuration(ALPHA_ANIMATIONS_DURATION);
        } else {
            expandedTitle.animate().alpha(0).setDuration(ALPHA_ANIMATIONS_DURATION);
        }

        if (percentage < 0.70) {
            innerToolbar.setBackgroundResource(android.R.color.transparent);
        } else {
            innerToolbar.setBackgroundResource(R.color.colorPrimary);
        }
    }

    private void resolveDependencies() {
        activityComponent = FootballMatchesApplication
                .getApplication()
                .getAppComponent()
                .homeComponent();
        activityComponent.resolveDependenciesFor(this);
    }

    private void initToolbar() {
        Team homeTeam = match.getHomeTeam();
        Team awayTeam = match.getAwayTeam();

        toolbar.setTitle(match.getName());
        expandedTitle.setText(match.getName());
        expandedTitle.setAlpha(1);
        collapsedTitle.setText(getMatchScore(homeTeam, awayTeam));
        appBarLayout.addOnOffsetChangedListener(this);

        picasso.load(homeTeam.getLogoUrl()).into(team1Logo);
        picasso.load(awayTeam.getLogoUrl()).into(team2Logo);
    }

    @NonNull
    private String getMatchScore(Team homeTeam, Team awayTeam) {
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
