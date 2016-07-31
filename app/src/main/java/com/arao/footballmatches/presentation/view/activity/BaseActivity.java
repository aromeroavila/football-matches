package com.arao.footballmatches.presentation.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.arao.footballmatches.injection.components.ActivityComponent;
import com.arao.footballmatches.injection.components.ActivityComponentProvider;
import com.arao.footballmatches.presentation.FootballMatchesApplication;

public abstract class BaseActivity extends AppCompatActivity implements ActivityComponentProvider {

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        resolveDependencies();
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

}
