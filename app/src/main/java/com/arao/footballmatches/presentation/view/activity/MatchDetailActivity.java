package com.arao.footballmatches.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.arao.footballmatches.R;

public class MatchDetailActivity extends AppCompatActivity {

    public static Intent getCallingIntent(Context context) {
        return new Intent(context, MatchDetailActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_match_detail);
    }

}
