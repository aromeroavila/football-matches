package com.arao.footballmatches.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.arao.footballmatches.R;
import com.arao.footballmatches.data.entity.Match;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MatchDetailActivity extends BaseActivity {

    private static final String INTENT_EXTRA_MATCH = "intent_extra_match";

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    private Match match;

    public static Intent getCallingIntent(Context context, Match match) {
        Intent callingIntent = new Intent(context, MatchDetailActivity.class);
        callingIntent.putExtra(INTENT_EXTRA_MATCH, match);
        return callingIntent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_detail);
        match = getIntent().getExtras().getParcelable(INTENT_EXTRA_MATCH);
        ButterKnife.bind(this);


        initToolbar();
    }

    private void initToolbar() {
        toolbar.setTitle(match.getName());
    }

}
