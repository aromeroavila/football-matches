package com.arao.footballmatches.presentation.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.arao.footballmatches.R;
import com.arao.footballmatches.injection.components.ActivityComponent;
import com.arao.footballmatches.presentation.FootballMatchesApplication;
import com.arao.footballmatches.presentation.presenter.HomePresenter;
import com.arao.footballmatches.presentation.view.fragment.LeaguesFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends AppCompatActivity implements ActivityComponentProvider {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Inject
    HomePresenter homePresenter;

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        resolveDependencies();
        ButterKnife.bind(this);

        initToolbar();
        LeaguesFragment leaguesFragment = loadLeaguesFragment();
        homePresenter.init(leaguesFragment);
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
        toolbar.setTitle(R.string.home_toolbar_title);
    }

    @NonNull
    private LeaguesFragment loadLeaguesFragment() {
        LeaguesFragment leaguesFragment = new LeaguesFragment();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.home_fragment_container, leaguesFragment);
        transaction.commit();
        return leaguesFragment;
    }

}
