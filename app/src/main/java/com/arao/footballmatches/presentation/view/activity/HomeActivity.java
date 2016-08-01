package com.arao.footballmatches.presentation.view.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.arao.footballmatches.R;
import com.arao.footballmatches.data.entity.Match;
import com.arao.footballmatches.injection.components.ActivityComponent;
import com.arao.footballmatches.injection.components.ActivityComponentProvider;
import com.arao.footballmatches.presentation.FootballMatchesApplication;
import com.arao.footballmatches.presentation.navigation.Navigator;
import com.arao.footballmatches.presentation.view.adapter.HomeFragmentAdapter;
import com.arao.footballmatches.presentation.view.adapter.HomeFragmentAdapterFactory;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements ActivityComponentProvider, MatchClickListener {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.leagues_filter_pager)
    ViewPager viewPager;
    @BindView(R.id.leagues_filter_tabs)
    TabLayout tabLayout;

    @Inject
    Navigator navigator;
    @Inject
    HomeFragmentAdapterFactory adapterFactory;

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        resolveDependencies();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        initToolbar();
        setupViewPager();
    }

    @Override
    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    @Override
    public void onMatchClick(Match match) {
        navigator.navigateToUserDetails(this, match);
    }

    private void initToolbar() {
        toolbar.setTitle(R.string.home_toolbar_title);
    }

    private void setupViewPager() {
        HomeFragmentAdapter homeFragmentAdapter = adapterFactory.getHomeFragmentAdapter(getSupportFragmentManager());
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setOffscreenPageLimit(homeFragmentAdapter.getCount() - 1);
        viewPager.setAdapter(homeFragmentAdapter);
    }

    private void resolveDependencies() {
        activityComponent = FootballMatchesApplication
                .getApplication()
                .getAppComponent()
                .homeComponent();
        activityComponent.resolveDependenciesFor(this);
    }

}
