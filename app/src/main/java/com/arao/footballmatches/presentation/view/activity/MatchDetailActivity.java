package com.arao.footballmatches.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.arao.footballmatches.R;
import com.arao.footballmatches.data.entity.Match;
import com.arao.footballmatches.injection.components.ActivityComponent;
import com.arao.footballmatches.presentation.FootballMatchesApplication;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MatchDetailActivity extends AppCompatActivity implements ActivityComponentProvider {

    private static final String INTENT_EXTRA_MATCH = "intent_extra_match";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private Match match;
    private ActivityComponent activityComponent;

    public static Intent getCallingIntent(Context context, Match match) {
        Intent callingIntent = new Intent(context, MatchDetailActivity.class);
        callingIntent.putExtra(INTENT_EXTRA_MATCH, match);
        return callingIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_detail);
        resolveDependencies();
        match = getIntent().getExtras().getParcelable(INTENT_EXTRA_MATCH);
        ButterKnife.bind(this);


        initToolbar();
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
    }

}
