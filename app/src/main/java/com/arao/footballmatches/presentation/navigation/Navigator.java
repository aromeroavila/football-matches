package com.arao.footballmatches.presentation.navigation;

import android.content.Context;
import android.content.Intent;

import com.arao.footballmatches.data.entity.Match;
import com.arao.footballmatches.presentation.view.activity.MatchDetailActivity;

public class Navigator {

    public void navigateToUserDetails(Context context, Match match) {
        if (context != null) {
            Intent intentToLaunch = MatchDetailActivity.getCallingIntent(context, match);
            context.startActivity(intentToLaunch);
        }
    }

}
