package com.arao.footballmatches.presentation.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.arao.footballmatches.R;
import com.arao.footballmatches.data.entity.League;
import com.arao.footballmatches.data.entity.Match;
import com.arao.footballmatches.injection.components.HomeComponent;
import com.arao.footballmatches.presentation.FootballMatchesApplication;
import com.arao.footballmatches.presentation.navigation.Navigator;
import com.arao.footballmatches.presentation.presenter.HomePresenter;
import com.arao.footballmatches.presentation.view.HomeView;
import com.arao.footballmatches.presentation.view.adapter.LeagueAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class HomeActivity extends AppCompatActivity implements HomeView, MatchClickListener {

    @Inject
    LeagueAdapter leagueAdapter;
    @Inject
    RecyclerView.ItemAnimator itemAnimator;
    @Inject
    RecyclerView.ItemDecoration itemDecoration;
    @Inject
    RecyclerView.LayoutManager layoutManager;
    @Inject
    HomePresenter homePresenter;
    @Inject
    Navigator navigator;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.loading_layout)
    LinearLayout loadingLayout;
    @BindView(R.id.error_view)
    TextView errorView;
    @BindView(R.id.leagues_recycler)
    RecyclerView leaguesRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        resolveDependencies();
        ButterKnife.bind(this);

        initToolbar();
        setupRecyclerView();

        homePresenter.init(this);
    }

    @Override
    public void displayLeagues(List<League> leagues) {
        loadingLayout.setVisibility(GONE);
        errorView.setVisibility(GONE);
        leaguesRecyclerView.setVisibility(VISIBLE);
        leagueAdapter.setData(leagues, this);
    }

    @Override
    public void displayError() {
        errorView.setVisibility(VISIBLE);
        loadingLayout.setVisibility(GONE);
        leaguesRecyclerView.setVisibility(GONE);
    }

    @Override
    public void onMatchClick(Match match) {
        navigator.navigateToUserDetails(this);
    }

    private void resolveDependencies() {
        HomeComponent component = FootballMatchesApplication
                .getApplication()
                .getAppComponent()
                .homeComponent();

        component.resolveDependenciesFor(this);
    }

    private void initToolbar() {
        toolbar.setTitle(R.string.home_toolbar_title);
    }

    private void setupRecyclerView() {
        leaguesRecyclerView.setLayoutManager(layoutManager);
        leaguesRecyclerView.setItemAnimator(itemAnimator);
        leaguesRecyclerView.addItemDecoration(itemDecoration);
        leaguesRecyclerView.setAdapter(leagueAdapter);
    }
}
